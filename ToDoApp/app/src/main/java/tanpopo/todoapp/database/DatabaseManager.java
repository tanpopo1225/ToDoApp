package tanpopo.todoapp.database;

/**
 * Created by takahashi on 2015/10/09.
 */
public final class DatabaseManager {
  private DatabaseManager(){}
  protected static final String DATABASENAME = "todoAppDB";
  protected static final int DATABASEVERSION = 1;

  protected static final String TABLE_NAME_CATEGORY = "category";
  protected static final String TABLE_NAME_TODO = "todo";

  protected static final String CREATE_TABLE_CATEGORY = "create table " + TABLE_NAME_CATEGORY + "(_id integer primary key autoincrement, name text)";
  protected static final String CREATE_TABLE_TODO = "create table " + TABLE_NAME_TODO + "(_id integer primary key autoincrement, title text, category_id integer, finish integer, foreign key(category_id)references "+TABLE_NAME_CATEGORY+"(_id))";

  protected static final String DROP_TABLE_CATEGORY = "drop table " + TABLE_NAME_CATEGORY;
  protected static final String DROP_TABLE_TODO = "drop table " + TABLE_NAME_TODO;

  protected static final String SELECT_TABLE_CATEGORY = "select _id, name from " + TABLE_NAME_CATEGORY;
  protected static final String SELECT_TABLE_TODO = "select _id, title, category_id, finish from " + TABLE_NAME_TODO;

  protected static final String INSERT_RECODE_TODO = "insert into " + TABLE_NAME_TODO + "(title, category_id, finish) value(?, ?, ?)";

  protected static final String UPDATE_RECODE_CATEGORY = "update " + TABLE_NAME_CATEGORY + "(name) values(?, ?, ?) where _id = ?";
  protected static final String UPDATE_RECODE_TODO = "update " + TABLE_NAME_TODO + "(title, category_id, finish) values(?, ?, ?) where _id = ?";

  protected static final String DELETE_RECODE_TODO = "delete from " + TABLE_NAME_TODO + "where _id = ?";
}
