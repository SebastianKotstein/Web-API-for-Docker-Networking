package de.skotstein.net.docker.webapi.services.api;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import de.skotstein.lib.spring.restfulspring.model.entities.Hypermedia;
import de.skotstein.net.docker.webapi.controllers.api.ApiHostController;
import de.skotstein.net.docker.webapi.model.Representations;
import de.skotstein.net.docker.webapi.services.BaseService;

@Service
public class ApiBaseService extends BaseService{

    @Override
    protected Hypermedia addHyperlinks(Hypermedia hypermedia) {
        hypermedia.clearHyperlinks();
        hypermedia.addHyperlink(Representations.HYPERLINK_RELATION_HOSTS, WebMvcLinkBuilder.methodOn(ApiHostController.class).getHosts(null, null, null, null, null),true);
        return hypermedia;
    }
    
}
