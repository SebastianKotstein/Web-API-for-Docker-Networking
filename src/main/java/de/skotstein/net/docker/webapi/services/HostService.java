package de.skotstein.net.docker.webapi.services;

import de.skotstein.lib.spring.restfulspring.util.Filter;
import de.skotstein.lib.spring.restfulspring.util.Pagination;
import de.skotstein.net.docker.webapi.model.entities.Host;
import de.skotstein.net.docker.webapi.model.entities.Hosts;

public abstract class HostService {
    
    public Hosts getHosts(Pagination pagination, Filter filter){
        Hosts hosts = new Hosts();
        this.addHyperlinks(hosts);
        pagination.addHyperlinksIfUsed(hosts, filter);
        return hosts;
    }

    public Host getHost(String hostName){
        Host host = new Host();
        this.addHyperlinkAsEntity(host);
        return host;
    }

    protected abstract Hosts addHyperlinks(Hosts hosts);

    protected abstract Host addHyperlinkAsItem(Host host);

    protected abstract Host addHyperlinkAsEntity(Host host);
}
