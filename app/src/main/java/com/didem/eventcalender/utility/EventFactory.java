package com.didem.eventcalender.utility;

import com.didem.eventcalender.utility.entity.Event;

import java.util.ArrayList;
import java.util.List;

public final class EventFactory {

    private static final int LIMIT = 100 ;
    private static List<Event> eventList;

    private EventFactory() { }

   private static List<Event> createEventList() {

        eventList = new ArrayList<>();

        Event event;

        for (int i = 0; i < LIMIT ; i++) {

            event = new Event();
            event.setName("Event#" + (i + 1));
            event.setGone(i % 2 == 0);

            eventList.add(event);

        }

        return eventList;
   }

   public static List<Event> getEventList() {

        if(eventList == null) {

            eventList = createEventList();

        }

        return eventList;

   }


}
