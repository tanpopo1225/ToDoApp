package tanpopo.todoapp.data;

import java.util.Calendar;

public class Todo {
  private int id;
  private String title;
  private int category;
  private boolean finishFlag;
  private Calendar updateTime;

  public Todo(int id, String title, int category, boolean finishFlag, Calendar updateTime) {
    this.id = id;
    this.title = title;
    this.category = category;
    this.finishFlag = finishFlag;
    this.updateTime = updateTime;
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
  public Calendar getUpdateTime() {
    return updateTime;
  }
}
