package com.eval.appart.equipement.interfaces.web;

import com.eval.appart.equipement.application.EquipementCreate;
import com.eval.appart.equipement.application.EquipementDelete;
import com.eval.appart.equipement.application.EquipementFinder;
import com.eval.appart.equipement.application.EquipementUpdate;
import com.eval.appart.equipement.interfaces.web.input.EquipementInput;
import com.eval.appart.equipement.interfaces.web.output.EquipementOutput;
import com.eval.appart.equipement.interfaces.web.output.EquipementOutputMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.UUID;

@Path("/equipements")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
public class EquipementResource {
    @Inject
    EquipementOutputMapper equipementOutputMapper;

    @Inject
    EquipementFinder equipementFinder;

    @Inject
    EquipementCreate equipementCreate;

    @Inject
    EquipementUpdate equipementUpdate;

    @Inject
    EquipementDelete equipementDelete;

    @GET
    @Path("/")
    public List<EquipementOutput> getAllEquipements() {
        return equipementOutputMapper.map(equipementFinder.getAllEquipements());
    }

    @GET
    @Path("/{id}")
    public EquipementOutput getEquipement(UUID id) {
        return equipementOutputMapper.map(equipementFinder.getEquipement(id));
    }

    @POST
    @Path("/")
    public EquipementOutput createEquipement(@Valid EquipementInput equipementInput) {
        return equipementOutputMapper.map(equipementCreate.createEquipement(equipementInput));
    }

    @PUT
    @Path("/{id}")
    public EquipementOutput updateEquipement(@PathParam("id") UUID id, @Valid EquipementInput equipementInput) {
        return equipementOutputMapper.map(equipementUpdate.updateEquipement(id, equipementInput));
    }

    @DELETE
    @Path("/{id}")
    public void deleteEquipement(@PathParam("id") UUID id) {
        equipementDelete.deleteEquipement(id);
    }


}
