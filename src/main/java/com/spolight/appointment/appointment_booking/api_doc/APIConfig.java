package com.spolight.appointment.appointment_booking.api_doc;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIConfig {

    @Bean
    public OpenAPI openApiInformation() {
        Server localServer = new Server()
                .url("http://localhost:7171")
                .description("Host Server URL");

        Contact contact = new Contact()
                .email("m.irfanawan77@gmail.com")
                .name("Irfan Malik");

        Info info = new Info()
                .contact(contact)
                .description("Appointment Booking API")
                .summary("Demo of Spring Boot 3 & Open API 3 Integration")
                .title("Appointment Booking API")
                .version("V0.0.1")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"));

        return new OpenAPI().info(info).addServersItem(localServer);
    }

}
