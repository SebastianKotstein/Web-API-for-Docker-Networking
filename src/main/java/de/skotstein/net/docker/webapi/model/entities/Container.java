package de.skotstein.net.docker.webapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import de.skotstein.lib.spring.restfulspring.model.entities.Hypermedia;
import de.skotstein.net.docker.webapi.model.Representations;

@JsonPropertyOrder({"containerId","name","ipAddress", "macAddress","_links"})
public class Container extends Hypermedia{
    
    @JsonIgnore
    private String containerId;

    @JsonIgnore
    private String name;

    @JsonIgnore
    private String ipAddress;

    @JsonIgnore
    private String macAddress;

    @JsonProperty("containerId")
    @JsonView({Representations.ContainersRepresentation.class, Representations.ContainerRepresentation.class})
    public String getContainerId() {
        return containerId;
    }
    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    @JsonProperty("name")
    @JsonView({Representations.ContainersRepresentation.class, Representations.ContainerRepresentation.class})
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ipAddress")
    @JsonView({Representations.ContainersRepresentation.class, Representations.ContainerRepresentation.class})
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @JsonProperty("macAddress")
    @JsonView({Representations.ContainersRepresentation.class, Representations.ContainerRepresentation.class})
    public String getMacAddress() {
        return macAddress;
    }
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    
}
