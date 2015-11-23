package tanpopo.todoapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import tanpopo.todoapp.data.Todo;

/**
 * Created by takahashi on 2015/11/23.
 */
public class TodoDatabase extends SQLiteOpenHelper {
  private static TodoDatabase instance = null;
  private static SQLiteDatabase database = null;

  private TodoDatabase(Context context) {
    super(context, DatabaseManager.DATABASENAME, null, DatabaseManager.DATABASEVERSION);
  }

  public static synchronized TodoDatabase getInstance(Context context) {
    if (instance == null) {
      instance = new TodoDatabase(context);
      database = instance.getWritableDatabase();
    }
    return instance;
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(DatabaseManager.CREATE_TABLE_CATEGORY);
    db.execSQL(DatabaseManager.CREATE_TABLE_TODO);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(DatabaseManager.DROP_TABLE_TODO);
    db.execSQL(DatabaseManager.DROP_TABLE_CATEGORY);
    onCreate(db);
  }

  public List<Todo> selectTodo() {
    List todos = new ArrayList<Todo>();
    Cursor cursor = database.rawQuery(DatabaseManager.SELECT_TABLE_TODO, null);
    while (cursor.moveToNext()) {
      Todo todo = new Todo(cursor.getInt(cursor.getColumnIndex("_id")),
              cursor.getString(cursor.getColumnIndex("title")),
              cursor.getInt(cursor.getColumnIndex("category_id")),
              cursor.getInt(cursor.getColumnIndex("finish")) == 1 ? true : false);
      todos.add(todo);
    }
    return todos;
  }

  public boolean insertTodo(Todo todo) {
    boolean result = true;
    Object[] insert = new Object[] {
            todo.getTitle(),
            todo.getCategory(),
            todo.isFinishFlag()
    };
    try {
      database.execSQL(DatabaseManager.INSERT_RECODE_TODO, insert);
    }
    catch (SQLiteException e) {
      result = false;
    }
    return result;
  }

  public boolean updateTodo(Todo todo) {
    boolean result = true;
    Object[] update = new Object[] {
            todo.getTitle(),
            todo.getCategory(),
            todo.isFinishFlag() == true ? 1 : 0,
            todo.getId()
    };
    try {
      database.execSQL(DatabaseManager.UPDATE_RECODE_TODO, update);
    }
    catch (SQLiteException e) {
      result = false;
    }
    return result;
  }

  public boolean deleteTodo(Todo todo) {
    boolean result = true;
    Object[] delete = new Object[] {
            todo.getId()
    };
    try {
      database.execSQL(DatabaseManager.DELETE_RECODE_TODO, delete);
    }
    catch (SQLiteException e) {
      result = false;
    }
    return result;
  }
}
