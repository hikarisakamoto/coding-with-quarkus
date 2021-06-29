package org.acme.sakamoto;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
    info = @Info(
        title = "Getting Started With Quarkus API",
        description = "Our Quarkus Test API",
        version = "1.0.1"
    ),
    servers = @Server(
        url = "sakamoto.acme.org"
    )
)

public class QuarkusApplication extends Application {
}
