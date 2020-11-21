package com.pi.meurole.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SqlDataSource {

    @Value("#{environment.URL}")
    private String URL;

    @Value("#{environment.USER}")
    private String USER;

    @Value("#{environment.PASSWORD}")
    private String PASSWORD;

    @Bean
    public DataSource getSqlDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);

        return dataSource;
    }

}
