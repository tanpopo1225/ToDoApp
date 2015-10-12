package tanpopo.todoapp.data;

/**
 * Created by takahashi on 2015/10/12.
 */
public class Category {
  private int id;
  private String name;

  public Category(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
