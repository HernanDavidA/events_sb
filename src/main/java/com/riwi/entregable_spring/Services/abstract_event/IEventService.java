package com.riwi.entregable_spring.Services.abstract_event;

import java.util.List;

import com.riwi.entregable_spring.Entity.Event;

public interface IEventService {


    public List<Event> getAll();


    public Event save(Event objEvent);

    public Event getById(String id);

    public void delete(String id);

    public Event update(Event objEvent);

}
