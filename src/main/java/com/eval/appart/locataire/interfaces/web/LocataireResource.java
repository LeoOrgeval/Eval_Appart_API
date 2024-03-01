package com.eval.appart.locataire.interfaces.web;

import com.eval.appart.locataire.application.LocataireCreate;
import com.eval.appart.locataire.application.LocataireDelete;
import com.eval.appart.locataire.application.LocataireFinder;
import com.eval.appart.locataire.application.LocataireUpdate;
import com.eval.appart.locataire.interfaces.web.input.LocataireInput;
import com.eval.appart.locataire.interfaces.web.output.LocataireOutput;
import com.eval.appart.locataire.interfaces.web.output.LocataireOutputMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.UUID;

@Path("/locataires")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
public class LocataireResource {
    @Inject
    LocataireOutputMapper locataireOutputMapper;

    @Inject
    LocataireFinder locataireFinder;

    @Inject
    LocataireCreate locataireCreate;

    @Inject
    LocataireUpdate locataireUpdate;

    @Inject
    LocataireDelete locataireDelete;

    @GET
    @Path("/")
    public List<LocataireOutput> getAllLocataires() {
        return locataireOutputMapper.map(locataireFinder.getAllLocataires());
    }

    @GET
    @Path("/{id}")
    public LocataireOutput getLocataire(UUID id) {
        return locataireOutputMapper.map(locataireFinder.getLocataire(id));
    }

    @POST
    @Path("/")
    public LocataireOutput createLocataire(@Valid LocataireInput locataireInput) {
        return locataireOutputMapper.map(locataireCreate.createLocataire(locataireInput));
    }

    @PUT
    @Path("/{id}")
    public LocataireOutput updateLocataire(@PathParam("id") UUID id, @Valid LocataireInput locataireInput) {
        return locataireOutputMapper.map(locataireUpdate.updateLocataire(id, locataireInput));
    }

    @DELETE
    @Path("/{id}")
    public void deleteLocataire(@PathParam("id") UUID id) {
        locataireDelete.deleteLocataire(id);
    }
}
