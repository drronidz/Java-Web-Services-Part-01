package com.cleverdeveloper.soap.client;

/*
PROJECT NAME : Java-Web-Services-Part-01
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 28/01/2022 23:30
*/

import com.cleverdeveloper.soap.ws.CustomerOrdersWSImplService;
import com.cleverdeveloper.ws.soap.CustomerOrdersPortType;
import com.cleverdeveloper.ws.soap.GetOrdersRequest;
import com.cleverdeveloper.ws.soap.GetOrdersResponse;
import com.cleverdeveloper.ws.soap.Order;
import com.diogonunes.jcolor.Attribute;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class CustomerOrderWSClient {
    public static void main(String[] args) throws MalformedURLException {

        CustomerOrdersWSImplService service =
                new CustomerOrdersWSImplService(new URL("http://localhost:8080/services/customerordersservice?wsdl"));

        CustomerOrdersPortType customerOrdersWSImplPort = service.getCustomerOrdersWSImplPort();

        GetOrdersRequest request = new GetOrdersRequest();
        request.setCustomerId(BigInteger.valueOf(1));

        GetOrdersResponse response = customerOrdersWSImplPort.getOrders(request);
        List<Order> orders = response.getOrder();

        Attribute backgroundColor = BACK_COLOR(39, 179, 118);
        Attribute textColor = TEXT_COLOR(0, 0, 0);

        System.out.println(colorize("Number of order of customer id " + request.getCustomerId() + " are :" + orders.size(), BOLD(),textColor, backgroundColor));
    }
}
