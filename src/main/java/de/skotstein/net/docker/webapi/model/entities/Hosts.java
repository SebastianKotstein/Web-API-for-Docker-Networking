package de.skotstein.net.docker.webapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import de.skotstein.lib.spring.restfulspring.model.entities.Hypermedia;
import de.skotstein.lib.spring.restfulspring.util.FilterableList;
import de.skotstein.net.docker.webapi.model.Representations;

@JsonPropertyOrder({"hosts","_links"})
public class Hosts extends Hypermedia{
    
    @JsonIgnore
    private FilterableList<Host> hosts = new FilterableList<Host>();

    @JsonProperty("hosts")
    @JsonView({Representations.HostsRepresentation.class})
    public FilterableList<Host> getHosts(){
        return this.hosts;
    }

    @JsonIgnore
    public void setHosts(FilterableList<Host> hosts){
        this.hosts = hosts;
    }
}
