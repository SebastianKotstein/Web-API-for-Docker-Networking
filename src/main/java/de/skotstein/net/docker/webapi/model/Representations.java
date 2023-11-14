package de.skotstein.net.docker.webapi.model;

import de.skotstein.lib.spring.restfulspring.model.representations.HypermediaRepresentation;

public class Representations {

    public static final String HYPERLINK_RELATION_HOSTS = "hosts";
    public static final String HYPERLINK_RELATION_HOST = "host";
    public static final String HYPERLINK_RELATION_NETWORKS = "networks";
    public static final String HYPERLINK_RELATION_NETWORK = "network";
    public static final String HYPERLINK_RELATION_CONTAINERS = "containers";
    public static final String HYPERLINK_RELATION_CONTAINER = "container";

    public static final String MIME_TYPE_HYPERMEDIA_V1_JSON_VALUE = "application/vnd.skotstein.net.docker.web-api.hypermedia.v1+json";
    
    public static class HostsRepresentation extends HypermediaRepresentation{
        public static class v1 extends HostsRepresentation{
            public static class json extends v1{
                public static final String MIME_TYPE_VALUE = "application/vnd.skotstein.net.docker.docker.web-api.hosts.v1+json";
            }
            public static class xhtml extends v1{
                public static final String MIME_TYPE_VALUE = "application/vnd.skotstein.net.docker.docker.web-api.hosts.v1+xhtml+xml";
            }
        }
    }

    public static class HostRepresentation extends HypermediaRepresentation{
        public static class v1 extends HostRepresentation{
            public static class json extends v1{
                public static final String MIME_TYPE_VALUE = "application/vnd.skotstein.net.docker.docker.web-api.host.v1+json";
            }
            public static class xhtml extends v1{
                public static final String MIME_TYPE_VALUE = "application/vnd.skotstein.net.docker.docker.web-api.host.v1+xhtml+xml";
            }
        }
    }

    public static class NetworksRepresentation extends HypermediaRepresentation{
        public static class v1 extends NetworksRepresentation{
            public static class json extends v1{
                public static final String MIME_TYPE_VALUE = "application/vnd.skotstein.net.docker.docker.web-api.networks.v1+json";
            }
            public static class xhtml extends v1{
                public static final String MIME_TYPE_VALUE = "application/vnd.skotstein.net.docker.docker.web-api.networks.v1+xhtml+xml";
            }
        }
    }

    public static class NetworkRepresentation extends HypermediaRepresentation{
        public static class v1 extends NetworkRepresentation{
            public static class json extends v1{
                public static final String MIME_TYPE_VALUE = "application/vnd.skotstein.net.docker.docker.web-api.network.v1+json";
            }
            public static class xhtml extends v1{
                public static final String MIME_TYPE_VALUE = "application/vnd.skotstein.net.docker.docker.web-api.network.v1+xhtml+xml";
            }
        }
    }

    public static class ContainersRepresentation extends HypermediaRepresentation{
        public static class v1 extends ContainersRepresentation{
            public static class json extends v1{
                public static final String MIME_TYPE_VALUE = "application/vnd.skotstein.net.docker.docker.web-api.containers.v1+json";
            }
            public static class xhtml extends v1{
                public static final String MIME_TYPE_VALUE = "application/vnd.skotstein.net.docker.docker.web-api.containers.v1+xhtml+xml";
            }
        }
    }

    public static class ContainerRepresentation extends HypermediaRepresentation{
        public static class v1 extends ContainerRepresentation{
            public static class json extends v1{
                public static final String MIME_TYPE_VALUE = "application/vnd.skotstein.net.docker.docker.web-api.container.v1+json";
            }
            public static class xhtml extends v1{
                public static final String MIME_TYPE_VALUE = "application/vnd.skotstein.net.docker.docker.web-api.container.v1+xhtml+xml";
            }
        }
    }


}
