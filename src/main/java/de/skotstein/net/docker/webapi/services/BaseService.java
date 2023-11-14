package de.skotstein.net.docker.webapi.services;

import de.skotstein.lib.spring.restfulspring.model.entities.Hypermedia;
import de.skotstein.lib.spring.restfulspring.model.entities.PlainHypermedia;

public abstract class BaseService {
    
    public Hypermedia getBase(){
        return addHyperlinks(new PlainHypermedia());
    }

    protected abstract Hypermedia addHyperlinks(Hypermedia hypermedia);
}
