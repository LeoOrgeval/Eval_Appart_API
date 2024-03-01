package com.eval.appart.appartement.interfaces.web;

import com.eval.appart.appartement.application.AppartementCreate;
import com.eval.appart.appartement.application.AppartementDelete;
import com.eval.appart.appartement.application.AppartementFinder;
import com.eval.appart.appartement.application.AppartementUpdate;
import com.eval.appart.appartement.interfaces.web.input.AppartementInput;
import com.eval.appart.appartement.interfaces.web.output.AppartementOutput;
import com.eval.appart.appartement.interfaces.web.output.AppartementOutputMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.UUID;

@Path("/appartements")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
public class AppartementResource {
    @Inject
    AppartementOutputMapper appartementOutputMapper;

    @Inject
    AppartementFinder appartementFinder;

    @Inject
    AppartementCreate appartementCreate;

    @Inject
    AppartementUpdate appartementUpdate;

    @Inject
    AppartementDelete appartementDelete;

    @GET
    @Path("/")
    public List<AppartementOutput> getAllAppartements() {
        return appartementOutputMapper.map(appartementFinder.getAllAppartements());
    }

    @GET
    @Path("/{id}")
    public AppartementOutput getAppartement(UUID id) {
        return appartementOutputMapper.map(appartementFinder.getAppartement(id));
    }

    @POST
    @Path("/")
    public AppartementOutput createAppartement(@Valid AppartementInput appartementInput) {
        return appartementOutputMapper.map(appartementCreate.createAppartement(appartementInput));
    }

    @PUT
    @Path("/{id}")
    public AppartementOutput updateAppartement(UUID id, @Valid AppartementInput appartementInput) {
        return appartementOutputMapper.map(appartementUpdate.updateAppartement(id, appartementInput));
    }

    @DELETE
    @Path("/{id}")
    public void deleteAppartement(UUID id) {
        appartementDelete.deleteAppartement(id);
    }

    @POST
    @Path("/{id}/locatairePrincipal/{locataireId}")
    public AppartementOutput addLocatairePrincipal(@PathParam("id") UUID id, @PathParam("locataireId") UUID locataireId) {
        return appartementOutputMapper.map(appartementUpdate.addLocatairePrincipal(id, locataireId));
    }

    @POST
    @Path("/{id}/options/{optionId}")
    public AppartementOutput addOption(@PathParam("id") UUID id, @PathParam("optionId") UUID optionId) {
        return appartementOutputMapper.map(appartementUpdate.addOption(id, optionId));
    }
}
