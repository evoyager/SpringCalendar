package com.diosoft.calendar.service;

import com.diosoft.calendar.common.Event;
import com.diosoft.calendar.common.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by EVGENIY on 21.03.14.
 */
public interface CalendarService extends Remote {

    void addEvent2(String name, String description, GregorianCalendar startDate, GregorianCalendar endDate, List<Person> attenders) throws RemoteException;

    Event removeEvent(UUID uuid) throws RemoteException;

    Event addAttender(UUID uuid, Person... newPersons) throws RemoteException;

    Event getEvent(UUID uuid) throws RemoteException;
}
