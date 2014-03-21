package com.diosoft.calendar.service;

import com.diosoft.calendar.common.Event;
import com.diosoft.calendar.common.Person;

import java.rmi.RemoteException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by EVGENIY on 21.03.14.
 */
public class CalendarServiceImpl implements CalendarService {
    @Override
    public void addEvent2(String name, String description, GregorianCalendar startDate, GregorianCalendar endDate, List<Person> attenders) throws RemoteException {

    }

    @Override
    public Event removeEvent(UUID uuid) throws RemoteException {
        return null;
    }

    @Override
    public Event addAttender(UUID uuid, Person... newPersons) throws RemoteException {
        return null;
    }

    @Override
    public Event getEvent(UUID uuid) throws RemoteException {
        return null;
    }
}
