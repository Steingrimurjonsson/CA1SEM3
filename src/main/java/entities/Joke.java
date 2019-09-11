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
@NamedQuery(name = "Joke.deleteAllRows", query = "DELETE from Joke"),
@NamedQuery(name = "Joke.getAll", query = "SELECT m FROM Joke m"),
@NamedQuery(name = "Joke.getByJoke", query = "SELECT m FROM Joke m WHERE m.theJoke LIKE :theJoke")
})
public class Joke implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int jId;
    private String theJoke;
    private String ref;
    
       public Joke() {
    }

    public Joke(int jId, String theJoke, String ref) {
        this.jId = jId;
        this.theJoke = theJoke;
        this.ref = ref;
    }
     @Override
    public String toString() {
        return "Joke{" + "id=" + id + ", jId=" + jId + ", theJoke=" + theJoke + ", ref=" + ref + '}';
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getjId() {
        return jId;
    }

    public void setjId(int jId) {
        this.jId = jId;
    }

    public String getTheJoke() {
        return theJoke;
    }

    public void setTheJoke(String theJoke) {
        this.theJoke = theJoke;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }



  
}

