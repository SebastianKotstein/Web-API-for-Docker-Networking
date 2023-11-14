package de.skotstein.net.docker.webapi.services.api;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import de.skotstein.lib.spring.restfulspring.model.entities.Hyperlink;
import de.skotstein.net.docker.webapi.controllers.api.ApiHostController;
import de.skotstein.net.docker.webapi.model.entities.Host;
import de.skotstein.net.docker.webapi.model.entities.Hosts;
import de.skotstein.net.docker.webapi.services.HostService;

@Service
public class ApiHostService extends HostService{

    @Override
    protected Hosts addHyperlinks(Hosts hosts) {
        hosts.clearHyperlinks();
        for (Host host : hosts.getHosts()) {
            this.addHyperlinkAsItem(host);
        }
        hosts.addHyperlink(Hyperlink.SELF_REL, WebMvcLinkBuilder.methodOn(ApiHostController.class).getHosts(null, null, null, null, null),true);
        return hosts;
    }

    @Override
    protected Host addHyperlinkAsItem(Host host) {
        host.clearHyperlinks();
        host.addHyperlink(Hyperlink.ITEM_REL,WebMvcLinkBuilder.methodOn(ApiHostController.class).getHost(host.getName()), true);
        return host;
    }

    @Override
    protected Host addHyperlinkAsEntity(Host host) {
        host.clearHyperlinks();
        host.addHyperlink(Hyperlink.COLLECTION_REL, WebMvcLinkBuilder.methodOn(ApiHostController.class).getHosts(null, null, null, null, null),true);
        host.addHyperlink(Hyperlink.SELF_REL,WebMvcLinkBuilder.methodOn(ApiHostController.class).getHost(host.getName()), true);
        return host;
    }
    
}
