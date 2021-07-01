package com.didem.eventcalender.utility.entity;


import com.didem.eventcalender.utility.Util;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Event {

    private UUID eventID;
    private String name;
    private String date;
    private boolean isGone;

    public Event() {

        eventID = UUID.randomUUID();
        date = Util.formatDate(new Date(), false);

    }

    public UUID getEventID() {
        return eventID;
    }

    public void setEventID(UUID eventID) {
        this.eventID = eventID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isGone() {
        return isGone;
    }

    public void setGone(boolean gone) {
        isGone = gone;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventID=" + eventID +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", isGone=" + isGone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return eventID.equals(event.eventID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventID);
    }
}
