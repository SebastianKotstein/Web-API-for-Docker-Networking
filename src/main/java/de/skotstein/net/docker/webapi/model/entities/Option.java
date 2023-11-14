package de.skotstein.net.docker.webapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import de.skotstein.net.docker.webapi.model.Representations;

@JsonPropertyOrder({"key","value"})
public class Option {
    
    @JsonIgnore
    private String key;

    @JsonIgnore 
    private String value;

    @JsonProperty("key")
    @JsonView({Representations.NetworkRepresentation.class})
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("value")
    @JsonView({Representations.NetworkRepresentation.class})
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    
}
