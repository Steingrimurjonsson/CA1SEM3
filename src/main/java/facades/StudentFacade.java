package facades;

import entities.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
//todo
public class StudentFacade {

    private static StudentFacade instance;
    private static EntityManagerFactory emf;
    
    private StudentFacade() {}
    
    
 
    public static StudentFacade getStudentFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new StudentFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
 
    public long getStudentCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long studentCount = (long)em.createQuery("SELECT COUNT(m) FROM Student m").getSingleResult();
            return studentCount;
        }finally{  
            em.close();
        }
        
    }

    public Student getStudentByID(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            Student student = em.find(Student.class, id);
            return student;
        }finally{
            em.close();
        }
    }/*
      public Joke getJokeByID(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            Joke joke = em.find(Joke.class, id);
            return joke;
        }finally{
            em.close();
        }
    }
   
     public Student getStudentBysId(int sId) {
        EntityManager em = emf.createEntityManager();
        try{
            Student student = em.find(Student.class, sId);
            return student;
        }finally{
            em.close();
        }
    } */
    public List<Student> getStudentBysId(int sId) {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery <Student> query =
                    em.createQuery("Select m from Student m where m.sId =:sId", Student.class);
            return query.setParameter("sId", sId).getResultList();
        } finally{
            em.close();
        }
    }
    public List<Student> getStudentByName(String name) {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery <Student> query =
                    em.createQuery("Select m from Student m where m.name =:name", Student.class);
            return query.setParameter("name", name).getResultList();
        } finally{
            em.close();
        }
    }
    public List<Student> getStudentsByColor(String color) {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery <Student> query =
                    em.createQuery("Select m from Student m where m.color =:color", Student.class);
            return query.setParameter("color", color).getResultList();
        } finally{
            em.close();
        }
    }

    public Student addStudent(int sId, String name, String color) {
        Student student = new Student();
        student = new Student(sId, name, color);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
            return student;
        } finally {
            em.close();
        }
    }

    public List<Student> getAllStudent() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery query
                    = em.createQuery("Select m from Student m", Student.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Student> getColorsByStudentName(String name) {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery <Student> query =
                    em.createQuery("Select color from Student m where m.name =:name", Student.class);
            return query.setParameter("name", name).getResultList();
        } finally{
            em.close();
        }
    }
    public void populateStudent() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Student.deleteAllRows").executeUpdate();
            em.persist(new Student(1, "Stein", "yellow"));
            em.persist(new Student(2, "Noell", "green"));
            em.persist(new Student(3, "Joachim", "yellow"));
            em.persist(new Student(4, "Christian", "yellow"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}