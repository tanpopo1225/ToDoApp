package tanpopo.todoapp.data;

import java.util.Calendar;

public class Todo {
  private int id;
  private String title;
  private int category;
  private boolean finishFlag;

  public Todo(int id, String title, int category, boolean finishFlag) {
    this.id = id;
    this.title = title;
    this.category = category;
    this.finishFlag = finishFlag;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public int getCategory() {
    return category;
  }

  public boolean isFinishFlag() {
    return finishFlag;
  }
}