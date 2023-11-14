package de.skotstein.net.docker.webapi.controllers.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import de.skotstein.lib.spring.restfulspring.util.Filter;
import de.skotstein.lib.spring.restfulspring.util.Pagination;
import de.skotstein.net.docker.webapi.model.entities.Containers;
import de.skotstein.net.docker.webapi.model.Representations;
import de.skotstein.net.docker.webapi.model.entities.Container;
import de.skotstein.net.docker.webapi.services.api.ApiContainerService;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class ApiContainerController {
    
    private static final Logger logger = LoggerFactory.getLogger(ApiContainerController.class);

    @Autowired
    private ApiContainerService containerService;

    @RequestMapping(value = "/hosts/{hostName}/networks/{networkId}/containers", method = RequestMethod.GET, produces = {Representations.ContainersRepresentation.v1.json.MIME_TYPE_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @JsonView(Representations.ContainersRepresentation.class)
    public Containers getContainers(
        @Parameter(description = "The name of the host") @PathVariable(value = "hostName") String hostName,
        @Parameter(description = "The ID of the network ") @PathVariable(value = "networkId") String networkId,
        @Parameter(description = "Allows to page through the returned collection of containers. If set, the first item of the returned page is the i-th item of the collection (after applying all query filters) where i is the value of this query parameter")  @RequestParam(name="start", required = false) Integer start,
        @Parameter(description = "Allows to page through the returned collection of containers. If set, the number of items of the returned page is limited to this value") @RequestParam(name="limit", required=false) Integer limit,
        @Parameter(description = "If set, only containers whose names contain the specified value (string) are returned") @RequestParam(name="name", required = false) String name,
        @Parameter(description = "If set, only containers whose IP addresses match the passed IP filter. The IP filter may contain wildcard segments (<code>*</code>)") @RequestParam(name="ip",required = false) String ipAddress,
        @Parameter(description = "If set, only hosts whose MAC addresses contained the specified value (string) are returned") @RequestParam(name="mac", required = false) String mac){
            
            Pagination pagination = Pagination.of(start, limit);
            Filter filter = Filter.create()
            .add("name", name, Filter.DefaultFilterMethod())
            .add("ip",ipAddress,Filter.IpAddressFilterMethod())
            .add("mac",mac,Filter.DefaultFilterMethod());
            Containers containers = containerService.getContainers(hostName, networkId, pagination, filter);
            logger.info("GET /hosts/"+hostName+"/networks/"+networkId+"/containers");
            return containers;
    }

    @RequestMapping(value = "/hosts/{hostName}/networks/{networkId}/containers/{containerId}", method = RequestMethod.GET, produces = {Representations.ContainerRepresentation.v1.json.MIME_TYPE_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @JsonView(Representations.ContainerRepresentation.class)
    public Container getContainer(
        @Parameter(description = "The name of the host") @PathVariable(value = "hostName") String hostName,
        @Parameter(description = "The ID of the network ") @PathVariable(value = "networkId") String networkId,
        @Parameter(description = "The ID of the container ") @PathVariable(value = "containerId") String containerId)
    {
        Container container = containerService.getContainer(hostName, networkId, containerId);
        logger.info("GET /hosts/"+hostName+"/networks/"+networkId+"/containers/"+ containerId);
        return container;
    }

    
}
