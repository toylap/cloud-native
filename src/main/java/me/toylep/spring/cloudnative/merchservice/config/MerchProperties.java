package me.toylep.spring.cloudnative.merchservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="merch")
public class MerchProperties {
    private String greeting;

    public void setGreeting(String greeting){
        this.greeting = greeting;
    }

    public String getGreeting(){
        return greeting;
    }
}
