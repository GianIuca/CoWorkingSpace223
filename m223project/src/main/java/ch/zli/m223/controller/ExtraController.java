package ch.zli.m223.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.zli.m223.model.Extra;
import ch.zli.m223.service.ExtraService;

@Path("/extra")
@RolesAllowed({"Administrator", "Mitglied"})
@Tag(name = "Entries", description = "Handling of extras")
public class ExtraController {

    @Inject
    ExtraService extraService;

    //POST 
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "create new extra", description = "create new extra")
    public Extra create(Extra extra) {
        return extraService.createExtra(extra);
    }
}
