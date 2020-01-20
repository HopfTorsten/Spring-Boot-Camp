package com.mhp.snippetsdemo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("(LOCAL & DANGEROUS) | PROD")
@Configuration
public class FirstConfiguration {

    @ConditionalOnExpression("#{environment.acceptsProfiles('profile1') || environment.acceptsProfiles('anotherProfile')}")
    @Bean
    public NoXmlNeeded noXmlNeeded() {
        return new NoXmlNeeded();
    }
}
