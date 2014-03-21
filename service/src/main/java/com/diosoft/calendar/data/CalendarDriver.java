package com.diosoft.calendar.data;

import com.diosoft.calendar.common.Event;
import com.diosoft.calendar.common.Person;

import java.util.*;

/**
 * Created by EVGENIY on 21.03.14.
 */
public class CalendarDriver extends CalendarDataStoreImpl {
    public Event editEvent(UUID uuid, String key, Object value){
        Event event = getEvent(uuid);
        if(key.equals("startTime"))
            event = new Event.Builder()
                    .setName(event.getName())
                    .setDescription(event.getDescription())
                    .setStartDate((Calendar) value)
                    .setEndDate(event.getEndDate())
                    .setAllDay(event.getAllDay())
                    .setAttenders(event.getAttenders())
                    .build();
        else if(key.equals("endTime"))
            event = new Event.Builder()
                    .setName(event.getName())
                    .setDescription(event.getDescription())
                    .setStartDate(event.getStartDate())
                    .setEndDate((Calendar) value)
                    .setAllDay(event.getAllDay())
                    .setAttenders(event.getAttenders())
                    .build();
        else if(key.equals("name")){
            event = new Event.Builder()
                    .setName((String)value)
                    .setDescription(event.getDescription())
                    .setStartDate(event.getStartDate())
                    .setEndDate(event.getEndDate())
                    .setAllDay(event.getAllDay())
                    .setAttenders(event.getAttenders())
                    .build();
        }
        else if(key.equals("description"))
            event = new Event.Builder()
                    .setName(event.getName())
                    .setDescription((String) value)
                    .setStartDate(event.getStartDate())
                    .setEndDate(event.getEndDate())
                    .setAllDay(event.getAllDay())
                    .setAttenders(event.getAttenders())
                    .build();
        remove(uuid);
        publish(uuid, event);
        return event;
    }

    public boolean isPersonAvailable(Person person, Calendar desireDate){
        Set<Event> eventSet = new HashSet<Event>(getStorage().values());
        for(Event event : eventSet){
            if((event.getStartDate().getTimeInMillis() <= desireDate.getTimeInMillis()) &&
                    (event.getEndDate().getTimeInMillis() > desireDate.getTimeInMillis()) &&
                    (event.getAttenders().contains(person.getEmail())))
                return false;
        }
        return true;
    }

    public List<Calendar> checkAvailability(Person... persons){
        Set<Event> eventSet = new HashSet<Event>(getStorage().values());
        List <Calendar> checkAvailabilityList = new ArrayList<Calendar>();
        for(Person p: persons){
            for(Event event : eventSet){
                if (event.getAttenders().contains(p.getEmail()))
                    checkAvailabilityList.add(event.getStartDate());
            }
        }
        return checkAvailabilityList;
    }

    public static void printEventSet(Set<Event> eventSet){
        int eventCounter = 1;
        for(Event event : eventSet){
            System.out.println("[" + eventCounter + "] " + event);
            eventCounter++;
        }
    }
}
