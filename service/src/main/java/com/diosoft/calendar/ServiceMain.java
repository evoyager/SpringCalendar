package com.diosoft.calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.RemoteException;
import java.util.UUID;
import java.util.logging.Logger;

public class ServiceMain {

    public static final Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) throws RemoteException {

        UUID uuid = UUID.randomUUID();
        ApplicationContext context = new ClassPathXmlApplicationContext("service.xml");
        logger.info("Service started");
    }
}
