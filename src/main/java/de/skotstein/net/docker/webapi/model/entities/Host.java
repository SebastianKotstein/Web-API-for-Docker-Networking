package de.skotstein.net.docker.webapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import de.skotstein.lib.spring.restfulspring.model.entities.Hypermedia;
import de.skotstein.net.docker.webapi.model.Representations;

@JsonPropertyOrder({"name","ipAddress","version","apiVersion","architecture","os","_links"})
public class Host extends Hypermedia{
    
    @JsonIgnore
    private String name;

    @JsonIgnore
    private String ipAddress;

    @JsonIgnore
    private String version;

    @JsonIgnore
    private String apiVersion;

    @JsonIgnore
    private String architecture;

    @JsonIgnore
    private String os;

    @JsonProperty("name")
    @JsonView({Representations.HostsRepresentation.class, Representations.HostRepresentation.class})
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ipAddress")
    @JsonView({Representations.HostsRepresentation.class, Representations.HostRepresentation.class})
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @JsonProperty("version")
    @JsonView({Representations.HostsRepresentation.class, Representations.HostRepresentation.class})
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("apiVersion")
    @JsonView({Representations.HostRepresentation.class})
    public String getApiVersion() {
        return apiVersion;
    }
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("architecture")
    @JsonView({Representations.HostRepresentation.class})
    public String getArchitecture() {
        return architecture;
    }
    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    @JsonProperty("os")
    @JsonView({Representations.HostRepresentation.class})
    public String getOs() {
        return os;
    }
    public void setOs(String os) {
        this.os = os;
    }

    

}
