package de.skotstein.net.docker.webapi.services;

import de.skotstein.lib.spring.restfulspring.util.Filter;
import de.skotstein.lib.spring.restfulspring.util.Pagination;
import de.skotstein.net.docker.webapi.model.entities.Network;
import de.skotstein.net.docker.webapi.model.entities.Networks;

public abstract class NetworkService{

    public Networks getNetworks(String hostName, Pagination pagination, Filter filter){
        Networks networks = new Networks();
        this.addHyperlinks(networks, hostName);
        pagination.addHyperlinksIfUsed(networks, filter);
        return networks;      
    }

    public Network getNetwork(String hostName, String networkId){
        Network network = new Network();
        this.addHyperlinkAsEntity(network, hostName);
        return network;
    }

    protected abstract Networks addHyperlinks(Networks networks, String hostName);

    protected abstract Network addHyperlinkAsItm(Network network, String hostName);

    protected abstract Network addHyperlinkAsEntity(Network network, String hostName);
}

