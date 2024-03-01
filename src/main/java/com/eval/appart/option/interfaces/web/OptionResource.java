package com.eval.appart.option.interfaces.web;

import com.eval.appart.option.application.OptionCreate;
import com.eval.appart.option.application.OptionDelete;
import com.eval.appart.option.application.OptionFinder;
import com.eval.appart.option.application.OptionUpdate;
import com.eval.appart.option.interfaces.web.input.OptionInput;
import com.eval.appart.option.interfaces.web.output.OptionOutput;
import com.eval.appart.option.interfaces.web.output.OptionOutputMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.UUID;

@Path("/options")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional

public class OptionResource {
    @Inject
    OptionOutputMapper optionOutputMapper;

    @Inject
    OptionFinder optionFinder;

    @Inject
    OptionCreate optionCreate;

    @Inject
    OptionUpdate optionUpdate;

    @Inject
    OptionDelete optionDelete;

    @GET
    @Path("/")
    public List<OptionOutput> getAllOptions() {
        return optionOutputMapper.map(optionFinder.getAllOptions());
    }

    @GET
    @Path("/{id}")
    public OptionOutput getOption(UUID id) {
        return optionOutputMapper.map(optionFinder.getOption(id));
    }

    @POST
    @Path("/")
    public OptionOutput createOption(@Valid OptionInput optionInput) {
        return optionOutputMapper.map(optionCreate.createOption(optionInput));
    }

    @PUT
    @Path("/{id}")
    public OptionOutput updateOption(@PathParam("id") UUID id, @Valid OptionInput optionInput) {
        return optionOutputMapper.map(optionUpdate.updateOption(id, optionInput));
    }

    @DELETE
    @Path("/{id}")
    public void deleteOption(@PathParam("id") UUID id) {
        optionDelete.deleteOption(id);
    }
}
