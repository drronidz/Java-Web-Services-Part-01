package com.cleverdeveloper.soap.ws;

/*
PROJECT NAME : Java-Web-Services-Part-01
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 27/01/2022 22:49
*/


import com.cleverdeveloper.ws.soap.*;
import com.diogonunes.jcolor.Attribute;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.cxf.feature.Features;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

/*
* Dependencies to be fixed in generated sources folder ...
* */

@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersWSImpl implements CustomerOrdersPortType {

    Map<BigInteger, List<Order>> customerOrders = new HashMap<>();
    int currentId;

    public CustomerOrdersWSImpl() {
        init();
    }

    public void init() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setId(BigInteger.valueOf(1));

        Product product = new Product();
        product.setId(String.valueOf(1));
        product.setDescription("ThinkPad x260");
        product.setQuantity(BigInteger.valueOf(1));

        order.getProduct().add(product);

        orders.add(order);

        customerOrders.put(BigInteger.valueOf(++currentId), orders);
    }



    @Override
    public GetOrdersResponse getOrders(GetOrdersRequest request) {
        BigInteger customerId = request.getCustomerId();
        List<Order> orders = customerOrders.get(customerId);

        GetOrdersResponse response = new GetOrdersResponse();
        response.getOrder().addAll(orders);

        return response;
    }

    @Override
    public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
        BigInteger customerId = request.getCustomerId();
        Order order = request.getOrder();

        List<Order> orders = customerOrders.get(customerId);
        orders.add(order);

        CreateOrdersResponse response = new CreateOrdersResponse();
        response.setResult(true);

        return response;
    }

    @Override
    public DeleteOrdersResponse deleteOrders(DeleteOrdersRequest request) {
        BigInteger customerId = request.getCustomerId();
        BigInteger orderId = request.getOrderId();

        Order selectedOrder = null;
        Attribute backgroundColor = BACK_COLOR(39, 179, 118);
        Attribute textColor = TEXT_COLOR(45, 45, 45);

        System.out.println("CustomerId is : " + customerId);
        System.out.println("orderId  is : " + orderId);

        List<Order> orders = customerOrders.get(customerId);

        orders.removeIf(order -> order.getId().compareTo(orderId) == 0);

        DeleteOrdersResponse response = new DeleteOrdersResponse();
        response.setResult(true);

        return response;
    }



}
