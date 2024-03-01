package com.eval.appart.immeuble.interfaces.web;

import com.eval.appart.immeuble.application.ImmeubleCreate;
import com.eval.appart.immeuble.application.ImmeubleDelete;
import com.eval.appart.immeuble.application.ImmeubleFinder;
import com.eval.appart.immeuble.application.ImmeubleUpdate;
import com.eval.appart.immeuble.interfaces.web.input.ImmeubleInput;
import com.eval.appart.immeuble.interfaces.web.output.ImmeubleOutput;
import com.eval.appart.immeuble.interfaces.web.output.ImmeubleOutputMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.UUID;

@Path("/immeubles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
public class ImmeubleResource {
    @Inject
    ImmeubleOutputMapper immeubleOutputMapper;

    @Inject
    ImmeubleFinder immeubleFinder;

    @Inject
    ImmeubleCreate immeubleCreate;

    @Inject
    ImmeubleUpdate immeubleUpdate;

    @Inject
    ImmeubleDelete immeubleDelete;

    @GET
    @Path("/")
    public List<ImmeubleOutput> getAllImmeubles() {
        return immeubleOutputMapper.map(immeubleFinder.getAllImmeubles());
    }

    @GET
    @Path("/{id}")
    public ImmeubleOutput getImmeuble(UUID id) {
        return immeubleOutputMapper.map(immeubleFinder.getImmeuble(id));
    }


    @POST
    @Path("/")
    public ImmeubleOutput createImmeuble(@Valid ImmeubleInput immeubleInput) {
        return immeubleOutputMapper.map(immeubleCreate.createImmeuble(immeubleInput));
    }


    @PUT
    @Path("/{id}")
    public ImmeubleOutput updateImmeuble(UUID id, @Valid ImmeubleInput immeubleInput) {
        return immeubleOutputMapper.map(immeubleUpdate.updateImmeuble(id, immeubleInput));
    }


    @DELETE
    @Path("/{id}")
    public void deleteImmeuble(UUID id) {
        immeubleDelete.deleteImmeuble(id);
    }

    @POST
    @Path("/{id}/equipement/{equipementId}")
    public ImmeubleOutput addEquipement(@PathParam("id") UUID id, @PathParam("equipementId") UUID equipementId) {
        return immeubleOutputMapper.map(immeubleUpdate.addEquipement(id, equipementId));
    }
}
