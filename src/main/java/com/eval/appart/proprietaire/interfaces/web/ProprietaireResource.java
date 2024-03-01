package com.eval.appart.proprietaire.interfaces.web;

import com.eval.appart.proprietaire.application.ProprietaireCreate;
import com.eval.appart.proprietaire.application.ProprietaireDelete;
import com.eval.appart.proprietaire.application.ProprietaireFinder;
import com.eval.appart.proprietaire.application.ProprietaireUpdate;
import com.eval.appart.proprietaire.interfaces.web.input.ProprietaireInput;
import com.eval.appart.proprietaire.interfaces.web.output.ProprietaireOutput;
import com.eval.appart.proprietaire.interfaces.web.output.ProprietaireOutputMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.UUID;

@Path("/proprietaires")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
public class ProprietaireResource {
    @Inject
    ProprietaireOutputMapper proprietaireOutputMapper;

    @Inject
    ProprietaireFinder proprietaireFinder;

    @Inject
    ProprietaireCreate proprietaireCreate;

    @Inject
    ProprietaireUpdate proprietaireUpdate;

    @Inject
    ProprietaireDelete proprietaireDelete;

    @GET
    @Path("/")
    public List<ProprietaireOutput> getAllProprietaires() {
        return proprietaireOutputMapper.map(proprietaireFinder.getAllProprietaires());
    }

    @GET
    @Path("/{id}")
    public ProprietaireOutput getProprietaire(UUID id) {
        return proprietaireOutputMapper.map(proprietaireFinder.getProprietaire(id));
    }

    @POST
    @Path("/")
    public ProprietaireOutput createProprietaire(@Valid ProprietaireInput proprietaireInput) {
        return proprietaireOutputMapper.map(proprietaireCreate.createProprietaire(proprietaireInput));
    }

    @PUT
    @Path("/{id}")
    public ProprietaireOutput updateProprietaire(UUID id, @Valid ProprietaireInput proprietaireInput) {
        return proprietaireOutputMapper.map(proprietaireUpdate.updateProprietaire(id, proprietaireInput));
    }

    @DELETE
    @Path("/{id}")
    public void deleteProprietaire(UUID id) {
        proprietaireDelete.deleteProprietaire(id);
    }
}
