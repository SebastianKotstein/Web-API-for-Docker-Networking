package de.skotstein.net.docker.webapi.controllers.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import de.skotstein.lib.spring.restfulspring.util.Filter;
import de.skotstein.lib.spring.restfulspring.util.Pagination;
import de.skotstein.net.docker.webapi.model.Representations;
import de.skotstein.net.docker.webapi.model.entities.Network;
import de.skotstein.net.docker.webapi.model.entities.Networks;
import de.skotstein.net.docker.webapi.services.api.ApiNetworkService;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class ApiNetworkController{
    
    private static final Logger logger = LoggerFactory.getLogger(ApiNetworkController.class);

    @Autowired
    private ApiNetworkService networkService;

    @RequestMapping(value = "/hosts/{hostName}/networks", method = RequestMethod.GET, produces = {Representations.NetworksRepresentation.v1.json.MIME_TYPE_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @JsonView(Representations.NetworksRepresentation.class)
    public Networks getNetworks(
        @Parameter(description = "The name of the host") @PathVariable(value = "hostName") String hostName,
        @Parameter(description = "Allows to page through the returned collection of subnets. If set, the first item of the returned page is the i-th item of the collection (after applying all query filters) where i is the value of this query parameter")  @RequestParam(name="start", required = false) Integer start,
        @Parameter(description = "Allows to page through the returned collection of subnets. If set, the number of items of the returned page is limited to this value") @RequestParam(name="limit", required=false) Integer limit,
        @Parameter(description = "If set, only networks whose names contain the specified value (string) are returned") @RequestParam(name="name", required = false) String name,
        @Parameter(description = "If set, only networks whose IP addresses match the passed IP filter. The IP filter may contain wildcard segments (<code>*</code>)") @RequestParam(name="ip",required = false) String ipAddress,
        @Parameter(description = "If set, only networks whose driver contain the specified value (string) in their name are returned") @RequestParam(name="driver", required = false) String driver){
    
            Pagination pagination = Pagination.of(start, limit);
            Filter filter = Filter.create()
            .add("name", name, Filter.DefaultFilterMethod())
            .add("ip",ipAddress,Filter.IpAddressFilterMethod())
            .add("driver",driver,Filter.DefaultFilterMethod());
            Networks networks = networkService.getNetworks(hostName, pagination, filter);
            logger.info("GET /hosts/"+hostName+"/networks");
            return networks;
    }

    @RequestMapping(value = "/hosts/{hostName}/networks/{networkId}", method = RequestMethod.GET, produces = {Representations.NetworkRepresentation.v1.json.MIME_TYPE_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @JsonView(Representations.NetworkRepresentation.class)
    public Network getNetwork(
        @Parameter(description = "The name of the host") @PathVariable(value = "hostName") String hostName,
        @Parameter(description = "The ID of the network ") @PathVariable(value = "networkId") String networkId
    ){
        Network network = networkService.getNetwork(hostName, networkId);
        logger.info("GET /hosts/"+hostName+"/networks/"+networkId);
        return network;
    }
}
