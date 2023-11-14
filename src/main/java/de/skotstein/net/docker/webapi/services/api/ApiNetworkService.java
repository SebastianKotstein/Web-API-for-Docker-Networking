package de.skotstein.net.docker.webapi.services.api;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import de.skotstein.lib.spring.restfulspring.model.entities.Hyperlink;
import de.skotstein.net.docker.webapi.controllers.api.ApiHostController;
import de.skotstein.net.docker.webapi.controllers.api.ApiNetworkController;
import de.skotstein.net.docker.webapi.model.Representations;
import de.skotstein.net.docker.webapi.model.entities.Network;
import de.skotstein.net.docker.webapi.model.entities.Networks;
import de.skotstein.net.docker.webapi.services.NetworkService;

@Service
public class ApiNetworkService extends NetworkService{

    @Override
    protected Networks addHyperlinks(Networks networks, String hostName) {
        networks.clearHyperlinks();
        for (Network network : networks.getNetworks()) {
            this.addHyperlinkAsItm(network, hostName);
        }
        networks.addHyperlink(Representations.HYPERLINK_RELATION_HOST, WebMvcLinkBuilder.methodOn(ApiHostController.class).getHost(hostName), true);
        networks.addHyperlink(Hyperlink.SELF_REL, WebMvcLinkBuilder.methodOn(ApiNetworkController.class).getNetworks(hostName, null, null, null, null, null),true);
        return networks;
    }

    @Override
    protected Network addHyperlinkAsItm(Network network, String hostName) {
        network.clearHyperlinks();
        network.addHyperlink(Hyperlink.ITEM_REL, WebMvcLinkBuilder.methodOn(ApiNetworkController.class).getNetwork(hostName, network.getNetworkId()),true);
        return network;
    }

    @Override
    protected Network addHyperlinkAsEntity(Network network, String hostName) {
        network.clearHyperlinks();
        network.addHyperlink(Hyperlink.COLLECTION_REL, WebMvcLinkBuilder.methodOn(ApiNetworkController.class).getNetworks(hostName, null, null, null, null, null),true);
        network.addHyperlink(Hyperlink.SELF_REL, WebMvcLinkBuilder.methodOn(ApiNetworkController.class).getNetwork(hostName, network.getNetworkId()),true);
        return network;
    }
    
}
