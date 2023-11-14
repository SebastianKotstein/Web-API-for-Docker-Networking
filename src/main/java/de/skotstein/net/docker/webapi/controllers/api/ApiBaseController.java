package de.skotstein.net.docker.webapi.controllers.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import de.skotstein.lib.spring.restfulspring.model.entities.Hypermedia;
import de.skotstein.lib.spring.restfulspring.model.representations.HypermediaRepresentation;
import de.skotstein.net.docker.webapi.services.api.ApiBaseService;
import de.skotstein.net.docker.webapi.model.Representations;
import org.springframework.http.MediaType;

@RestController
public class ApiBaseController {
    
    private static final Logger logger = LoggerFactory.getLogger(ApiBaseController.class);

    @Autowired
    private ApiBaseService baseService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = {Representations.MIME_TYPE_HYPERMEDIA_V1_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @JsonView(HypermediaRepresentation.class)
    public Hypermedia getBase(){
        logger.info("GET /");
        return baseService.getBase();
    }
}
