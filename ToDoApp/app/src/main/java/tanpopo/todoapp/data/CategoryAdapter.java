package tanpopo.todoapp.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tanpopo.todoapp.R;

/**
 * Created by takahashi on 2015/12/10.
 */
public class CategoryAdapter extends BaseAdapter {
  private Context context;
  private ArrayList<Category> categories;

  public CategoryAdapter(Context context) {
    super();
    this.context = context;
    this.categories = null;
  }

  public void setCategories(List data) {
    categories = (ArrayList)data;
  }
  @Override
  public int getCount() {
    return categories.size();
  }

  @Override
  public Object getItem(int position) {
    return categories.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    return setView(convertView, position);
  }

  @Override
  public View getDropDownView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
      LayoutInflater inflater = LayoutInflater.from(context);
      convertView = inflater.inflate(R.layout.spinner_item, null);
      Category category = categories.get(position);
      String categoryName = category.getName();

      View view = convertView.findViewById(R.id.category_color);
      TextView textView = (TextView)convertView.findViewById(R.id.category_title);
      switch (category.getColor()) {
        case CategoryColor.BLUE:
          view.setBackgroundResource(R.drawable.category_item_color_blue);
          break;
        case CategoryColor.GRAY:
          view.setBackgroundResource(R.drawable.category_item_color_gray);
          break;
        case CategoryColor.GREEN:
          view.setBackgroundResource(R.drawable.category_item_color_green);
          break;
        case CategoryColor.PURPLE:
          view.setBackgroundResource(R.drawable.category_item_color_purple);
          break;
        case CategoryColor.RED:
          view.setBackgroundResource(R.drawable.category_item_color_red);
          break;
        case CategoryColor.YELLOW:
          view.setBackgroundResource(R.drawable.category_item_color_yellow);
          break;
        default:
          view.setBackgroundResource(R.drawable.category_item_color_black);
      }
      textView.setText(categoryName);
    }
    return convertView;
  }

  private View setView(View convertView, int position) {
    if (convertView == null) {
      LayoutInflater inflater = LayoutInflater.from(context);
      convertView = inflater.inflate(R.layout.spinner_item, null);
      Category category = categories.get(position);
      String categoryName = category.getName();

      View view = convertView.findViewById(R.id.category_color);
      TextView textView = (TextView)convertView.findViewById(R.id.category_title);
      switch (category.getColor()) {
        case CategoryColor.BLUE:
          view.setBackgroundResource(R.drawable.category_item_color_blue);
          break;
        case CategoryColor.GRAY:
          view.setBackgroundResource(R.drawable.category_item_color_gray);
          break;
        case CategoryColor.GREEN:
          view.setBackgroundResource(R.drawable.category_item_color_green);
          break;
        case CategoryColor.PURPLE:
          view.setBackgroundResource(R.drawable.category_item_color_purple);
          break;
        case CategoryColor.RED:
          view.setBackgroundResource(R.drawable.category_item_color_red);
          break;
        case CategoryColor.YELLOW:
          view.setBackgroundResource(R.drawable.category_item_color_yellow);
          break;
        default:
          view.setBackgroundResource(R.drawable.category_item_color_black);
      }
      textView.setText(categoryName);
    }
    return convertView;
  }
}
