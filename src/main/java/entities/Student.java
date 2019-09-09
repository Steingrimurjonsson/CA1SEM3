package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name = "Student.deleteAllRows", query = "DELETE from Student"),
@NamedQuery(name = "Student.getAll", query = "SELECT m FROM Student m"),
@NamedQuery(name = "Student.getByName", query = "SELECT m FROM Student m WHERE m.name LIKE :name")
})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sId;
    private String name;
    private String color;
    
       public Student() {
    }

    public Student(int sId, String name, String color) {
        this.sId = sId;
        this.name = name;
        this.color = color;
    }
     @Override
    public String toString() {
        return "Student{" + "id=" + id + ", sId=" + sId + ", name=" + name + ", color=" + color + '}';
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


  
}

