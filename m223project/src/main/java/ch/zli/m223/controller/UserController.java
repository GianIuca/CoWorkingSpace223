package ch.zli.m223.controller;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.User;
import ch.zli.m223.service.UserService;

@Path("/user")
@RolesAllowed({"Administrator"})
@Tag(name = "Entries", description = "Handling of users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "returns all users", description = "returns all users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "create new user", description = "create new user")
    public User create(User user) {
        return userService.createUsers(user);
    }

   
    @DELETE
    @Path("/{id}")
    @Operation(summary = "delete user by ID", description = "delete user by ID")
    public void delete(@PathParam("id") Long id) {
        userService.deleteUser(id);
    }

    
}
