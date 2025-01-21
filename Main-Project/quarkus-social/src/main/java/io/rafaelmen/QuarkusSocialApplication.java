package io.rafaelmen;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import static java.awt.SystemColor.info;

@OpenAPIDefinition(info = @Info(title = "API Social Media with Quarkus",version = "1.0",contact = @Contact(name = "Rafael")))
public class QuarkusSocialApplication extends Application {
}
