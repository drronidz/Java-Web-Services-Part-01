package com.cleverdeveloper.soap;

/*
PROJECT NAME : Java-Web-Services-Part-01
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 27/01/2022 15:13
*/


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorldWS {

    @WebMethod
    public String helloWorld() {
        return "Hello world (This is our first SOAP web services)";
    }
}
