package de.skotstein.net.docker.webapi.model.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import de.skotstein.lib.spring.restfulspring.model.entities.Hypermedia;
import de.skotstein.net.docker.webapi.model.Representations;

@JsonPropertyOrder({"networkId","name","ipAddress","subnetMask","driver","options","_links"})
public class Network extends Hypermedia{
    
    @JsonIgnore
    private String networkId;

    @JsonIgnore
    private String name;

    @JsonIgnore
    private String ipAddress;

    @JsonIgnore
    private String subnetMask;

    @JsonIgnore
    private String driver;

    @JsonIgnore
    private List<Option> options = new ArrayList<Option>();

    @JsonProperty("networkId")
    @JsonView({Representations.NetworksRepresentation.class, Representations.NetworkRepresentation.class})
    public String getNetworkId() {
        return networkId;
    }
    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }


    @JsonProperty("name")
    @JsonView({Representations.NetworksRepresentation.class, Representations.NetworkRepresentation.class})
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ipAddress")
    @JsonView({Representations.NetworksRepresentation.class, Representations.NetworkRepresentation.class})
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @JsonProperty("subnetMask")
    @JsonView({Representations.NetworksRepresentation.class, Representations.NetworkRepresentation.class})
    public String getSubnetMask() {
        return subnetMask;
    }
    public void setSubnetMask(String subnetMask) {
        this.subnetMask = subnetMask;
    }

    @JsonProperty("driver")
    @JsonView({Representations.NetworksRepresentation.class, Representations.NetworkRepresentation.class})
    public String getDriver() {
        return driver;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }

    @JsonProperty("options")
    @JsonView({Representations.NetworkRepresentation.class})
    public List<Option> getOptions() {
        return options;
    }
    public void setOptions(List<Option> options) {
        this.options = options;
    }
    
}
