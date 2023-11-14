package de.skotstein.net.docker.webapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import de.skotstein.lib.spring.restfulspring.model.entities.Hypermedia;
import de.skotstein.lib.spring.restfulspring.util.FilterableList;
import de.skotstein.net.docker.webapi.model.Representations;

@JsonPropertyOrder({"containers","_links"})
public class Containers extends Hypermedia{
    
    @JsonIgnore
    private FilterableList<Container> containers = new FilterableList<Container>();

    @JsonProperty("containers")
    @JsonView({Representations.ContainersRepresentation.class})
    public FilterableList<Container> getContainers() {
        return containers;
    }

    @JsonIgnore
    public void setContainers(FilterableList<Container> containers) {
        this.containers = containers;
    }

    

}
