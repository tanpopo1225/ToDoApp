package tanpopo.todoapp.todo_detail;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import tanpopo.todoapp.R;
import tanpopo.todoapp.data.Category;
import tanpopo.todoapp.data.CategoryAdapter;

public class TodoDetailActivity extends ActionBarActivity {
  EditText todoTitle;
  Spinner categorySpinner;
  CheckBox finishCheck;
  EditText todoMemo;
  ArrayList<Category> categories;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_todo_detail);

    Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    setListener();
    setSpinner();
    setValue();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_todo_detail, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  private void setListener() {
    todoTitle = (EditText)findViewById(R.id.todo_title);
    categorySpinner = (Spinner)findViewById(R.id.categoies_spinner);
    finishCheck = (CheckBox)findViewById(R.id.finish_flag);
    todoMemo = (EditText)findViewById(R.id.edit_memo);
  }
  private void setSpinner() {
    categories = new ArrayList<>(); //後で変更
    CategoryAdapter adapter = new CategoryAdapter(this);
    adapter.setCategories(categories);
    categorySpinner.setAdapter(adapter);
  }
  private void setValue() {
    todoTitle.setText("");
    categorySpinner.setSelection(0);
    finishCheck.setChecked(false);
    todoMemo.setText("");
  }
}
