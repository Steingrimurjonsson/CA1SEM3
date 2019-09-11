package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Joke;
import entities.Student;
import facades.JokeFacade;
import utils.EMF_Creator;
import facades.StudentFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author stein
 * 
 * */
    

//Todo Remove or change relevant parts before ACTUAL use
@Path("joke")
public class ResourceJoke {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://157.230.18.125:3307/joke",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final JokeFacade FACADE =  JokeFacade.getJokeFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Joke\"}";
    }
   @Path("populate")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String populate() {
        FACADE.populateJoke();
        return "{\"msg\":\"done!\"}";
    }
    @Path("jId/{jId}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getJokeBysId(@PathParam ("jId") int jId) {
        Joke joke = FACADE.getJokeByjId(jId);
        return GSON.toJson(joke);
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllJokes(@PathParam ("theJoke") String theJoke) {
        List<Joke>  joke = FACADE.getAllJokes();
        return GSON.toJson(joke);
        
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Joke entity) {
        throw new UnsupportedOperationException();
    }
    
 /*   @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(Student entity, @PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }*/
}
