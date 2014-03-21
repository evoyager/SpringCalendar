package com.diosoft.calendar.data;

import com.diosoft.calendar.common.Event;
import com.diosoft.calendar.common.Person;
import com.diosoft.calendar.service.CalendarServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by EVGENIY on 21.03.14.
 */
public class CalendarDataStoreImplTest {
    CalendarDataStoreImpl dataStore = new CalendarDataStoreImpl();
    Set<Event> eventSet;

    @Before
    public void setUp(){
        Person vasiliy = new Person.Builder()
                .setAge(30)
                .setEmail("vtegza@dio-soft.com")
                .setFirstName("Vasiliy")
                .setSecondName("Tegza")
                .build();

        Person evgeniy = new Person.Builder()
                .setAge(27)
                .setEmail("evgeniygusar@gmail.com")
                .setFirstName("Evgeniy")
                .setSecondName("Gusar")
                .build();

        Person ivan = new Person.Builder()
                .setAge(22)
                .setEmail("shapoval.ivan.ivanovich@gmail.com")
                .setFirstName("Ivan")
                .setSecondName("Shapoval")
                .build();

        Person igor = new Person.Builder()
                .setAge(27)
                .setEmail("sytniuk@gmail.com\"")
                .setFirstName("Igor")
                .setSecondName("Sytnuk")
                .build();

        Person nikolay = new Person.Builder()
                .setAge(40)
                .setEmail("nchigir@dio-soft.com")
                .setFirstName("Nikolay")
                .setSecondName("Chigir")
                .build();

        Person kostia = new Person.Builder()
                .setAge(30)
                .setEmail("kshraiber@dio-soft.com")
                .setFirstName("Kostia")
                .setSecondName("Shraiber")
                .build();

        ArrayList<String> listOfAttenders =  new ArrayList<String>();

        listOfAttenders.add(vasiliy.getEmail());
        listOfAttenders.add(evgeniy.getEmail());
        listOfAttenders.add(ivan.getEmail());
        listOfAttenders.add(igor.getEmail());
        listOfAttenders.add(nikolay.getEmail());
        listOfAttenders.add(kostia.getEmail());

        Event finishOfCourses = new Event.Builder()
                .setName("End of DIO-soft courses")
                .setDescription("Otprazdnovat okonchanie!")
                .setStartDate(new GregorianCalendar(2014, 2, 27, 11, 00, 00))
                .setAllDay(true)
                .setAttenders(listOfAttenders)
                .build();

        Map<UUID, Event> storage = new HashMap<UUID, Event>();

        storage.put(UUID.fromString("d849f178-b062-4fd6-b79c-0b824a7b0c"), finishOfCourses);

        Person i = new Person.Builder()
                .setAge(27)
                .setEmail("evgeniygusar@gmail.com")
                .setFirstName("Evgeniy")
                .setSecondName("Gusar")
                .build();

        Person girlfriend = new Person.Builder()
                .setAge(22)
                .setEmail("mashamasha@gmail.com")
                .setFirstName("Masha")
                .setSecondName("Kotnikova")
                .build();

        Person stepBrother = new Person.Builder()
                .setAge(30)
                .setEmail("dima.smirnov@gmail.com")
                .setFirstName("Dima")
                .setSecondName("Smirnov")
                .build();

        Person friend = new Person.Builder()
                .setAge(20)
                .setEmail("shalimovmisha@gmail.com")
                .setFirstName("Misha")
                .setSecondName("Shalimov")
                .build();

        Person brother = new Person.Builder()
                .setAge(32)
                .setEmail("maximgusar@gmail.com")
                .setFirstName("Maxim")
                .setSecondName("Gusar")
                .build();

        Person mother = new Person.Builder()
                .setAge(54)
                .setEmail("nataliagusar@gmail.com")
                .setFirstName("Natalia")
                .setSecondName("Gusar")
                .build();

        Person father = new Person.Builder()
                .setAge(55)
                .setEmail("valeriygusar@gmail.com")
                .setFirstName("Valeriy")
                .setSecondName("Gusar")
                .build();

        Person grandfather = new Person.Builder()
                .setAge(85)
                .setEmail("Mayakovskogo 10")
                .setFirstName("Konstantin")
                .setSecondName("Gusar")
                .build();

        Person grandmother = new Person.Builder()
                .setAge(82)
                .setEmail("Mayakovskogo 10")
                .setFirstName("Galina")
                .setSecondName("Gusar")
                .build();

        ArrayList<String> listOfAttenders2 =  new ArrayList<String>();

        listOfAttenders2.add(i.getEmail());
        listOfAttenders2.add(girlfriend.getEmail());
        listOfAttenders2.add(stepBrother.getEmail());
        listOfAttenders2.add(friend.getEmail());
        listOfAttenders2.add(brother.getEmail());
        listOfAttenders2.add(mother.getEmail());
        listOfAttenders2.add(father.getEmail());
        listOfAttenders2.add(grandmother.getEmail());
        listOfAttenders2.add(grandfather.getEmail());

        Event myBirthday = new Event.Builder()
                .setName("My Birthday")
                .setDescription("Celebrate with friends and family")
                .setStartDate(new GregorianCalendar(2014, 4, 15, 17, 30, 00))
                .setAllDay(true)
                .setAttenders(listOfAttenders2)
                .build();

        storage.put(UUID.fromString("477491d5-fe71-45e8-a1c9-986ec1905249"), myBirthday);

        dataStore.setStorage(storage);

        eventSet = new HashSet<Event>(storage.values());
//        driver.printEventSet(eventSet);
    }

    @Test
    public void testPublish() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testGetEvent() throws Exception {
        UUID uuid = UUID.fromString("477491d5-fe71-45e8-a1c9-986ec1905249");
        Event event = dataStore.getEvent(uuid);
        System.out.println(event);
    }
}
