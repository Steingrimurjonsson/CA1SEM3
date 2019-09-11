package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Student;
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

//Todo Remove or change relevant parts before ACTUAL use
@Path("groupmembers")
public class ResourceStudent {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://157.230.18.125:3307/student",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final StudentFacade FACADE =  StudentFacade.getStudentFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Student\"}";
    }
   @Path("populate")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String populate() {
        FACADE.populateStudent();
        return "{\"msg\":\"done!\"}";
    }
    @Path("sId/{sId}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getStudentBysId(@PathParam ("sId") int sId) {
        Student student = FACADE.getStudentBysId(sId);
        return GSON.toJson(student);
    }
    
    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getStudentByID(@PathParam ("id") int id) {
        Student student = FACADE.getStudentByID(id);
        return GSON.toJson(student);
    }
    
        @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getStudentCount() {
        long count = FACADE.getStudentCount();
        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO
    }
    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllStudent() {
        List<Student>  student = FACADE.getAllStudent();
        return GSON.toJson(student);
        
    }
      @Path("color/{color}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getStudentsWithColor(@PathParam ("color") String color) {
        List<Student>  student = FACADE.getStudentsByColor(color);
         return GSON.toJson(student);
        
    }
       @Path("colorOf/{name}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAcotorsByStudentName(@PathParam ("name") String name) {
        List<Student>  color = FACADE.getColorsByStudentName(name);
        return GSON.toJson(color);
        
    }
       /*   @Path("jokes")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllJokes(@PathParam ("joke") String joke) {
        List<Joke>  joke = FACADE.getAllJokes(joke);
        return GSON.toJson(joke);
        
    }*/

    @Path("name/{name}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getStudentByName(@PathParam ("name") String name) {
        List <Student> student = FACADE.getStudentByName(name);
        return GSON.toJson(student);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Student entity) {
        throw new UnsupportedOperationException();
    }
    
 /*   @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(Student entity, @PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }*/
}
