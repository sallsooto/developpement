package org.sfd.gestionHopital;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class GlobalRepository extends RepositoryRestConfigurerAdapter{
@Override
public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration)
{
	repositoryRestConfiguration.getCorsRegistry()
	.addMapping("/**")
	.allowedOrigins("http://localhost:4200")
	.allowedHeaders("*")
	.allowedMethods("OPTIONS","HEAD","GET","PUT","POST","DELETE","PATCH");
}
}
