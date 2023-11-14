package de.skotstein.net.docker.webapi.services;

import de.skotstein.lib.spring.restfulspring.util.Filter;
import de.skotstein.lib.spring.restfulspring.util.Pagination;
import de.skotstein.net.docker.webapi.model.entities.Container;
import de.skotstein.net.docker.webapi.model.entities.Containers;

public abstract class ContainerService {
    
    public Containers getContainers(String hostName, String networkId, Pagination pagination, Filter filter){
        Containers containers = new Containers();
        return containers;
    }

    public Container getContainer(String hostName, String networkId, String containerId){
        Container container = new Container();
        return container;
    }

    protected abstract Containers addHyperlinks(Containers containers, String hostName, String networkId);

    protected abstract Container addHyperlinkAsItem(Container container, String hostName, String networkId);

    protected abstract Container addHyperlinkAsEntity(Container container, String hostName, String networkId);

    
}
