package br.com.example.avaliacao.configs;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
@SecurityScheme(name="bearer Auth", type=SecuritySchemeType.HTTP, scheme="bearer", bearerFormat="JWT")
public class SwaggerConfigs {
	@Value("${prop.swagger.dev-url}")
	private String devUrl;

	@Bean
	public OpenAPI myOpenAPI() {
	Server server = new Server();
	server.setUrl(devUrl);
	server.setDescription("Development Server");

	Contact contact = new Contact();
	contact.setEmail("leticia.95lima@gmail.com");
	contact.setName("Leticia Peixoto");
	contact.setUrl("leticiapeixoto.net");

	License license = new License();
	license.setName("Apache Lincense 2.0");
	license.setUrl("https://www.apache.org/licenses/LICENSES-2.0.html");

	Info info = new Info();
	info.setTitle("Avalições");
	info.setVersion("3.0.0");
	info.setDescription("API de avaliações de filmes e séries");
	info.setContact(contact);
	info.setLicense(license);
	info.setTermsOfService("https://swagger.io/terms/");

	return new OpenAPI().info(info).servers(List.of(server));

	}

	}
