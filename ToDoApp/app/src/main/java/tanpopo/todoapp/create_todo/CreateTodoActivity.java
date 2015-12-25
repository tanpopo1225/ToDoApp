package tanpopo.todoapp.create_todo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import tanpopo.todoapp.R;
import tanpopo.todoapp.data.Category;
import tanpopo.todoapp.data.CategoryAdapter;

public class CreateTodoActivity extends ActionBarActivity {

  private Spinner categoriesSpinner;
  private ArrayList<Category> categories;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_todo);
    Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    setListener();
    setSpinner();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_create_todo, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    if (id == android.R.id.home) {
      finish();
      return true;
    }
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
  private void setListener() {
    categoriesSpinner = (Spinner)findViewById(R.id.categoies_spinner);
  }
  private void setSpinner() {
    categories = new ArrayList<>(); //後で変更
    CategoryAdapter adapter = new CategoryAdapter(this);
    adapter.setCategories(categories);
    categoriesSpinner.setAdapter(adapter);
  }
}
