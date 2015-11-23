package tanpopo.todoapp.database;

import android.content.Context;

import java.util.List;

import tanpopo.todoapp.data.Todo;

/**
 * Created by takahashi on 2015/11/23.
 */
public class TodoDatabaseOperation {
  private TodoDatabase todoDatabase;

  public TodoDatabaseOperation(Context context) {
    todoDatabase = TodoDatabase.getInstance(context);
  }

  public List<Todo> selectTodo() {
    List<Todo> todos = todoDatabase.selectTodo();
    return todos;
  }

  public boolean insertTodo(Todo todo) {
    return todoDatabase.insertTodo(todo);
  }

  public boolean updateTodo(Todo todo) {
    return todoDatabase.updateTodo(todo);
  }

  public boolean deleteTodo(Todo todo) {
    return todoDatabase.deleteTodo(todo);
  }
}
