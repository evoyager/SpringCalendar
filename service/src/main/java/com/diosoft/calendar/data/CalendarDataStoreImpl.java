package com.diosoft.calendar.data;

import com.diosoft.calendar.common.Event;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by EVGENIY on 21.03.14.
 */
public class CalendarDataStoreImpl implements CalendarDataStore {
    public Map<UUID, Event> getStorage() {
        return storage;
    }

    private Map<UUID, Event> storage = new HashMap<UUID, Event>();

    @Override
    public void publish(UUID uuid, Event event) {
        //UUID uuid = UUID.randomUUID();
        storage.put(uuid, event);
    }

    @Override
    public Event remove(UUID uuid) {
        Event deletedEvent;
        deletedEvent = storage.get(uuid);
        storage.remove(uuid);
        return deletedEvent;
    }

    @Override
    public Event getEvent(UUID uuid) {
        return storage.get(uuid);
    }

    public void setStorage(Map<UUID, Event> storage) {
        this.storage = storage;
    }
}
