package de.skotstein.net.docker.webapi.controllers.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import de.skotstein.lib.spring.restfulspring.util.Filter;
import de.skotstein.lib.spring.restfulspring.util.Pagination;
import de.skotstein.net.docker.webapi.model.Representations;
import de.skotstein.net.docker.webapi.model.entities.Host;
import de.skotstein.net.docker.webapi.model.entities.Hosts;
import de.skotstein.net.docker.webapi.services.api.ApiHostService;

@RestController
@Tag(name="hosts", description = "Endpoints for querying resources that represents docker hosts.")
public class ApiHostController {
    
    private static final Logger logger = LoggerFactory.getLogger(ApiHostController.class);

    @Autowired
    private ApiHostService hostService;

    @RequestMapping(value = "/hosts", method = RequestMethod.GET, produces = {Representations.HostsRepresentation.v1.json.MIME_TYPE_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @JsonView(Representations.HostsRepresentation.class)
    public Hosts getHosts(
        @Parameter(description = "Allows to page through the returned collection of subnets. If set, the first item of the returned page is the i-th item of the collection (after applying all query filters) where i is the value of this query parameter")  @RequestParam(name="start", required = false) Integer start,
        @Parameter(description = "Allows to page through the returned collection of subnets. If set, the number of items of the returned page is limited to this value") @RequestParam(name="limit", required=false) Integer limit,
        @Parameter(description = "If set, only hosts whose names contain the specified value (string) are returned") @RequestParam(name="name", required = false) String name,
        @Parameter(description = "If set, only hosts whose IP addresses match the passed IP filter. The IP filter may contain wildcard segments (<code>*</code>)") @RequestParam(name="ip",required = false) String ipAddress,
        @Parameter(description = "If set, only hosts whose version the specified value (string) are returned") @RequestParam(name="version", required = false) String version){
            Pagination pagination = Pagination.of(start, limit);
            Filter filter = Filter.create()
            .add("name",name,Filter.DefaultFilterMethod())
            .add("ip",ipAddress,Filter.IpAddressFilterMethod())
            .add("version",version,Filter.DefaultFilterMethod());

            Hosts hosts = hostService.getHosts(pagination, filter);
            logger.info("GET /hosts");
            return hosts;
    }

    @RequestMapping(value = "/hosts/{hostName}", method = RequestMethod.GET, produces = {Representations.HostRepresentation.v1.json.MIME_TYPE_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @JsonView(Representations.HostRepresentation.class)
    public Host getHost(@Parameter(description = "The name of the host") @PathVariable("hostName") String hostName){
        Host host = hostService.getHost(hostName);
        logger.info("GET /hosts/"+hostName);
        return host;
    }
}
