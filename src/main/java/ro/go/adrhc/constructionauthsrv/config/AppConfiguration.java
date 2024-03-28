package ro.go.adrhc.constructionauthsrv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ro.go.adrhc.constructionauth.ConstructionAuthConfig;

@Configuration
@Import(ConstructionAuthConfig.class)
public class AppConfiguration {
}
