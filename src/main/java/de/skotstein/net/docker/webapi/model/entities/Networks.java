package de.skotstein.net.docker.webapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import de.skotstein.lib.spring.restfulspring.model.entities.Hypermedia;
import de.skotstein.lib.spring.restfulspring.util.FilterableList;
import de.skotstein.net.docker.webapi.model.Representations;

@JsonPropertyOrder({"networks","_links"})
public class Networks extends Hypermedia{
    
    @JsonIgnore
    private FilterableList<Network> networks = new FilterableList<Network>();

    @JsonProperty("networks")
    @JsonView({Representations.NetworksRepresentation.class})
    public FilterableList<Network> getNetworks(){
        return this.networks;
    }

    @JsonIgnore
    public void setNetworks(FilterableList<Network> networks){
        this.networks = networks;
    }
}
