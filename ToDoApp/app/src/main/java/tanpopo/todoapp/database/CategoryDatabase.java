package tanpopo.todoapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import tanpopo.todoapp.data.Category;

/**
 * Created by takahashi on 2015/11/23.
 */
public class CategoryDatabase extends SQLiteOpenHelper {
  private static CategoryDatabase instance = null;
  private static SQLiteDatabase database = null;

  private CategoryDatabase(Context context) {
    super(context, DatabaseManager.DATABASENAME, null, DatabaseManager.DATABASEVERSION);
  }

  protected static synchronized CategoryDatabase getInstance(Context context) {
    if (instance == null) {
      instance = new CategoryDatabase(context);
      database = instance.getWritableDatabase();
    }
    return instance;
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(DatabaseManager.CREATE_TABLE_CATEGORY);
    db.execSQL(DatabaseManager.INSERT_RECODE_CATEGORY, new Object[]{"カテゴリー1", "blue"});
    db.execSQL(DatabaseManager.INSERT_RECODE_CATEGORY, new Object[]{"カテゴリー2", "gray"});
    db.execSQL(DatabaseManager.INSERT_RECODE_CATEGORY, new Object[]{"カテゴリー3", "green"});
    db.execSQL(DatabaseManager.INSERT_RECODE_CATEGORY, new Object[]{"カテゴリー4", "red"});
    db.execSQL(DatabaseManager.INSERT_RECODE_CATEGORY, new Object[]{"カテゴリー5", "yellow"});
    db.execSQL(DatabaseManager.INSERT_RECODE_CATEGORY, new Object[]{"カテゴリー6", "purple"});
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(DatabaseManager.DROP_TABLE_TODO);
    db.execSQL(DatabaseManager.DROP_TABLE_CATEGORY);
    onCreate(db);
  }

  public List<Category> selectCategory() {
    List<Category> categories = new ArrayList<>();
    Cursor cursor = database.rawQuery(DatabaseManager.SELECT_TABLE_CATEGORY, null);
    while (cursor.moveToNext()) {
      Category category = new Category(cursor.getInt(cursor.getColumnIndex("_id")),
              cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("color")));
      categories.add(category);
    }
    return categories;
  }

  public boolean updateCategory(Category category) {
    boolean result = true;
    Object[] update = new Object[] {
            category.getId(),
            category.getName()
    };
    try {
      database.execSQL(DatabaseManager.UPDATE_RECODE_CATEGORY, update);
    }
    catch (SQLiteException e) {
      result = false;
    }
    return result;
  }
}
