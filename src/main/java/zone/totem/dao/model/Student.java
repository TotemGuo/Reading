package zone.totem.dao.model;

/**
 * Created by Holmes on 2016/12/13.
 */
public class Student {
    int id;
    String name;
    int age;

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}