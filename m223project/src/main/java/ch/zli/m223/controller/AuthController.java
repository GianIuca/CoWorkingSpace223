package ch.zli.m223.controller;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;


import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.zli.m223.model.User;
import ch.zli.m223.service.AuthService;
import ch.zli.m223.service.UserService;


@Path("/auth")  
@PermitAll
public class AuthController {

    @Inject
    AuthService authService;

    @Inject
    UserService userService;

    /*
     * @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    @Operation(summary = "login user with email + password", description = "login user with email + password")
    public String login(User user)  {
        System.out.println("C: "+user.getEmail());
        System.out.println("C: "+user.getPassword());

        return authService.login(user);
    }
     */
    
    @POST
    @Path("/login/{email}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "returns jwt for user", description = "returns jwt for user")
    public String authlogin(@PathParam("email") String username, @PathParam("password") String password) {
        if(authService.doesThisUserExistsAlready(username, password) == true && username == "gianluca.ferrara@gmail.ch"){
            return this.authService.generateTokenAdmin();
        }else if (authService.doesThisUserExistsAlready(username, password) == true){
            return this.authService.generateTokenMitglied();
        }        else{
            return null;
        }
    }

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "create new user", description = "create new user")
    public User create(User user) {
       return userService.createUsers(user);
    }
    
    
 


    
} 
