package tanpopo.todoapp.todo_list;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import java.util.ArrayList;

import tanpopo.todoapp.R;
import tanpopo.todoapp.data.Todo;
import tanpopo.todoapp.data.TodoAdapter;

public class TodoListActivityFragment extends Fragment implements OnClickListener {

  private RecyclerView recyclerView;
  private FloatingActionButton floatingActionButton;
  private RecyclerView.Adapter adapter;
  private RecyclerView.LayoutManager layoutManager;
  private ArrayList<Todo> todos;

  public TodoListActivityFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_todo_list, container, false);

    findView(view);
    setListener();
    setRecyclerView();

    return view;
  }

  private void findView(View view) {
    recyclerView = (RecyclerView)view.findViewById(R.id.todo_list);
    floatingActionButton = (FloatingActionButton)view.findViewById(R.id.add_button);
  }

  private void setListener() {
    floatingActionButton.setOnClickListener(this);
  }

  public void onClick(View view) {
    if (view.getId() == R.id.add_button) {
      //Todo作成画面へ
    }
  }

  private void setRecyclerView() {
    recyclerView.setHasFixedSize(true);
    layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);

    todos = new ArrayList<>(); //後に変更
    adapter = new TodoAdapter(todos);
    recyclerView.setAdapter(adapter);
  }

//  public void addTodo() {
//    todos.add(0,);
//    adapter.notifyItemInserted(0);
//  }
}
