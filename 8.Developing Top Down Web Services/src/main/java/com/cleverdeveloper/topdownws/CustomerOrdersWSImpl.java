package com.cleverdeveloper.topdownws;

/*
PROJECT NAME : Java-Web-Services-Part-01
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 27/01/2022 22:49
*/


import cleverdeveloper.trainings.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Dependencies to be fixed in generated sources folder ...
* */
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
    public GetOrdersResponse getOrders(GetOrdersRequest parameters) {
        return null;
    }

    @Override
    public CreateOrdersResponse createOrders(CreateOrdersRequest parameters) {
        return null;
    }
}
