package tanpopo.todoapp.data;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import tanpopo.todoapp.R;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {
  ArrayList<Todo> todos;

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public CardView cardView;

    public ViewHolder(View view) {
      super(view);
      cardView = (CardView)view;
    }
  }

  public TodoAdapter(ArrayList<Todo> todos) {
    this.todos = todos;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
    View  view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.todo_card, viewGroup, false);
    view.setClickable(true);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder viewHolder, int position) {
    Todo todo = todos.get(position);
    View view = viewHolder.cardView;
//    後に変更
//    (LinearLayout)view.findViewById(R.id.value_linear).setBackground(todo.getCategory());
    ((TextView)view.findViewById(R.id.todo_title)).setText(todo.getTitle());
    ((CheckBox)view.findViewById(R.id.finish_flag)).setChecked(todo.isFinishFlag());
  }

  @Override
  public int getItemCount() {
    return todos.size();
  }
}
