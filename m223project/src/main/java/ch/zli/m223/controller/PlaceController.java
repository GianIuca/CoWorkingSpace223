package ch.zli.m223.controller;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "returns all places", description = "returns all places")
    public List<Place> getPlaces() {
        return placeService.getPlaces();
    }
   // POST ADMIN

   /*
    * @PUT
    @Path("/update/{id}")
    @Operation(summary = "delete place by ID", description = "delete place by ID")
    public Place update(@PathParam("id") Place place, Long id){
        return placeService.updatPlace(place, id);
            
    } 
    */
    
 

}
