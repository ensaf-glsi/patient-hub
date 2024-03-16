package com.ids.patienthub.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new SpringSecurityAuditorAware();
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
        return builder -> builder.failOnEmptyBeans(false).failOnUnknownProperties(false);
    }
}

class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("anonymous");
//    return Optional.ofNullable(SecurityContextHolder.getContext())
//            .map(SecurityContext::getAuthentication)
//            .filter(Authentication::isAuthenticated)
//            .map(Authentication::getPrincipal)
//            .map(User.class::cast);
    }

}
