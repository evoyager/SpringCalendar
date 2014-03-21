package com.diosoft.calendar.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by EVGENIY on 21.03.14.
 */
public class Event {
    private final String name;
    private final String description;
    private final Calendar startDate;
    private final Calendar endDate;
    private final boolean allDay;
    private final List<String> attenders;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public boolean getAllDay() {
        return allDay;
    }

    public List<String> getAttenders() {
        return attenders;
    }

    private Event(Builder builder){
        this.name = builder.name;
        this.description = builder.description;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.allDay = builder.allDay;
        this.attenders = builder.attenders;
    }

    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        return "Start date: " + sdf.format(startDate.getTime()) + ", End date: " + sdf.format(endDate.getTime()) +
                ", name: " + name + ", description: " + description + "\nattenders: " + attenders;
    }

    public static class Builder {
        private String name;
        private String description;
        private Calendar startDate;
        private Calendar endDate;
        private boolean allDay;
        private List<String> attenders;

        public Builder(){}

        public Builder(Event original){
            this.name = original.name;
            this.description = original.description;
            this.startDate = original.startDate;
            this.endDate = original.endDate;
            this.allDay = original.allDay;
            this.attenders = original.attenders;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setDescription(String description){
            this.description = description;
            return this;
        }

        public Builder setStartDate(Calendar startDate){
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(Calendar endDate){
            this.endDate = endDate;
            return this;
        }

        public Builder setAllDay(boolean allDay){
            if (allDay == true){
                int year = startDate.get(Calendar.YEAR);
                int month = startDate.get(Calendar.MONTH);
                int dayOfMonth = startDate.get(Calendar.DAY_OF_MONTH);
                endDate = new GregorianCalendar(year, month, dayOfMonth+1, 00, 00, 00);
            }
            this.allDay = allDay;
            return this;
        }

        public Builder setAttenders(List<String> attenders){
            this.attenders = attenders;
            return this;
        }

        public Event build(){
            return new Event(this);
        }
    }
}
