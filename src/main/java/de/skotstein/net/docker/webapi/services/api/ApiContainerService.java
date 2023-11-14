package de.skotstein.net.docker.webapi.services.api;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import de.skotstein.lib.spring.restfulspring.model.entities.Hyperlink;
import de.skotstein.net.docker.webapi.controllers.api.ApiContainerController;
import de.skotstein.net.docker.webapi.controllers.api.ApiNetworkController;
import de.skotstein.net.docker.webapi.model.Representations;
import de.skotstein.net.docker.webapi.model.entities.Container;
import de.skotstein.net.docker.webapi.model.entities.Containers;
import de.skotstein.net.docker.webapi.services.ContainerService;

@Service
public class ApiContainerService extends ContainerService{

    @Override
    protected Containers addHyperlinks(Containers containers, String hostName, String networkId) {
        containers.clearHyperlinks();
        for (Container container : containers.getContainers()) {
            this.addHyperlinkAsItem(container, hostName, networkId);
        }
        containers.addHyperlink(Representations.HYPERLINK_RELATION_NETWORK, WebMvcLinkBuilder.methodOn(ApiNetworkController.class).getNetwork(hostName, networkId),true);
        containers.addHyperlink(Hyperlink.SELF_REL, WebMvcLinkBuilder.methodOn(ApiContainerController.class).getContainers(hostName, networkId, null, null, null, null, null),true);
        return containers;
    }

    @Override
    protected Container addHyperlinkAsItem(Container container, String hostName, String networkId) {
        container.clearHyperlinks();
        container.addHyperlink(Hyperlink.ITEM_REL, WebMvcLinkBuilder.methodOn(ApiContainerController.class).getContainer(hostName, networkId, container.getContainerId()), true);
        return container;
    }

    @Override
    protected Container addHyperlinkAsEntity(Container container, String hostName, String networkId) {
        container.clearHyperlinks();
        container.addHyperlink(Hyperlink.COLLECTION_REL, WebMvcLinkBuilder.methodOn(ApiContainerController.class).getContainers(hostName, networkId, null, null, null, null, null),true);
        container.addHyperlink(Hyperlink.SELF_REL, WebMvcLinkBuilder.methodOn(ApiContainerController.class).getContainer(hostName, networkId, container.getContainerId()), true);
        return container;
    }
    
}
