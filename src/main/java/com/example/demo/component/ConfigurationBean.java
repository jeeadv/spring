package com.example.demo.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("demoapp")
public class ConfigurationBean
{
    public long id;
    public String name;
    public boolean isSalaried;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSalaried() {
        return isSalaried;
    }

    public void setSalaried(boolean salaried) {
        isSalaried = salaried;
    }
}
