package com.cleverdeveloper.soap.ws.config;

/*
PROJECT NAME : Java-Web-Services-Part-01
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 27/01/2022 15:10
*/



import com.cleverdeveloper.soap.ws.CustomerOrdersWSImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        Endpoint endpoint = new EndpointImpl(bus, new CustomerOrdersWSImpl());
        endpoint.publish("/customerordersservice");
        return endpoint;
    }
}
