package ch.zli.m223.controller;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;
import javax.ws.rs.PathParam;

@Path("/booking")
@Tag(name = "Entries", description = "Handling of buchungen")
public class BookingController {

    @Inject
    BookingService bookingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "returns all bookings", description = "returns all bookings")
    public List<Booking> getBooking() {
        return bookingService.getBookings();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "return booking by ID", description = "return booking by ID")
    public Booking getBooking(@PathParam("id") long id) {
        return bookingService.getBookingById(id);
    }


    @DELETE
    @Path("/{id}")
    @Operation(summary = "delete booking by ID", description = "delete booking by ID")
    public void delete(@PathParam("id") Long id) {
        bookingService.deleteBooking(id);
    }

    /*
 * @PUT
    @Path("/update/{id}")
    @Operation(summary = "delete booking by ID", description = "delete booking by ID")
    public Booking update(@PathParam("id") Booking booking, Long id){
        return bookingService.updateBooking(booking, id);
            
    } 
 */
       

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "create new bookin", description = "create new bookin")
    public Booking create(Booking booking) {
        return bookingService.createBooking(booking);
    }
     
    
}