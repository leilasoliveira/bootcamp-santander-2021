package com.digitalinnovationone.profilesspringboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DbConfiguration {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev") // seleciona o profile DEV
    @Bean // executa no startup da aplicação
    public String testDataBaseConnection() {
        System.out.println("DB connection for DEV - H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to H2_TEST - Test instance";
    }

    @Profile("prod") // seleciona o profile DEV
    @Bean // executa no startup da aplicação
    public String productionDataBaseConnection() {
        System.out.println("DB connection for Production - MYSQL");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to MYSQL_PROD - Production instance";
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}