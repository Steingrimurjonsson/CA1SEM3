/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;


import entities.Joke;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author stein
 */
public class JokeFacade {

    private static JokeFacade instance;
    private static EntityManagerFactory emf;
    
    private JokeFacade() {}
    
    
 
    public static JokeFacade getJokeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new JokeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
      public long getJokeCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long studentCount = (long)em.createQuery("SELECT COUNT(m) FROM Joke m").getSingleResult();
            return studentCount;
        }finally{  
            em.close();
        }
        
    }
    
  public Joke getJokeByjId(int jId) {
        EntityManager em = emf.createEntityManager();
        try{
            Joke joke = em.find(Joke.class, jId);
            return joke;
        }finally{
            em.close();
        }
    }

       public List<Joke> getAllJokes() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery query
                    = em.createQuery("Select m from Joke m", Joke.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
 
    public void populateJoke() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Joke.deleteAllRows").executeUpdate();
            em.persist(new Joke(1, "I hate Russian dolls, they're so full of themselves.", "short"));
            em.persist(new Joke(2, "Say what you want about deaf people...", "short"));
            em.persist(new Joke(3, "PMS jokes are not funny or appropriate. Period!", "short"));
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}