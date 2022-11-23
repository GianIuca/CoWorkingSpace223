package ch.zli.m223.controller;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Place;
import ch.zli.m223.service.PlaceService;

@Path("/place")
@Tag(name = "Entries", description = "Handling of place")
public class PlaceController {
    

    @Inject
    PlaceService placeService;

   // GET all
    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "returns all places", description = "returns all places")
    public List<Place> getPlaces() {
        return placeService.getPlaces();
    }
   // POST ADMIN
   @POST
   @RolesAllowed("Administrator")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   @Operation(summary = "create new place", description = "create new place")
   public Place create(Place place) {
       return placeService.creatPlace(place);
   }

   
    @PUT
    @PermitAll
    @Path("/update/{id}")
    @Operation(summary = "delete place by ID", description = "delete place by ID")
    public Place update( Place place,@PathParam("id") Long id){
        return placeService.updatePlace(place, id);
            
    } 
    

    
    
 

}
