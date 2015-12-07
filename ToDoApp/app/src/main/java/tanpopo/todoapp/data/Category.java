package tanpopo.todoapp.data;

/**
 * Created by takahashi on 2015/11/23.
 */
public class Category {
  private int id;
  private String name;
  private String color;

  public Category(int id, String name, String color) {
    this.id = id;
    this.name = name;
    this.color = color;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
  public String getColor() {
    return color;
  }
}
