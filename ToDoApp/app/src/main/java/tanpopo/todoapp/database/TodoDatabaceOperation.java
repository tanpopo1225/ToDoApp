package tanpopo.todoapp.database;

import android.content.Context;

import java.util.List;

import tanpopo.todoapp.data.Todo;

/**
 * Created by takahashi on 2015/10/09.
 */
public class TodoDatabaceOperation {
  private TodoDatabase todoDatabase;

  public TodoDatabaceOperation(Context context) {
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
