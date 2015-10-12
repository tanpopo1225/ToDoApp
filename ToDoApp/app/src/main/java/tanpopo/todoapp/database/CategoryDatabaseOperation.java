package tanpopo.todoapp.database;

import android.content.Context;

import java.util.List;

import tanpopo.todoapp.data.Category;

/**
 * Created by takahashi on 2015/10/12.
 */
public class CategoryDatabaseOperation {
  private CategoryDatabase categoryDatabase;

  public CategoryDatabaseOperation(Context context) {
    categoryDatabase = CategoryDatabase.getInstance(context);
  }

  public List<Category> selectCategory() {
    return categoryDatabase.selectCategory();
  }

  public boolean updateCategory(Category category) {
    return categoryDatabase.updateCategory(category);
  }
}
