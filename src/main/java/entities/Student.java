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

    /**
     *
     * @param sId
     * @param name
     * @param color
     */
    public Student(int sId, String name, String color) {
        this.sId = sId;
        this.name = name;
        this.color = color;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", sId=" + sId + ", name=" + name + ", color=" + color + '}';
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public int getsId() {
        return sId;
    }

    /**
     *
     * @param sId
     */
    public void setsId(int sId) {
        this.sId = sId;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }


  
}

