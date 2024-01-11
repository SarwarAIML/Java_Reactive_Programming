package com.gs.rp.sec05HotColdPublisher;


import com.gs.rp.courseutil.Util;
import com.gs.rp.sec05HotColdPublisher.assignment.*;

public class Lec06Assignment {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        // revenue and inv - observe the order stream
        orderService.orderStream().subscribe(revenueService.subscribeOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscribeOrderStream());

        inventoryService.inventoryStream().subscribe(Util.subscriber("inventory"));

        revenueService.revenueStream().subscribe(Util.subscriber("revenue"));

        Util.sleepSecond(60);

    }


}