package com.diosoft.calendar.data;

import com.diosoft.calendar.common.Event;

import java.util.UUID;

/**
 * Created by EVGENIY on 21.03.14.
 */
public interface CalendarDataStore {

    void publish(UUID uuid, Event event);

    Event remove(UUID uuid);

    Event getEvent(UUID uuid);
}
