package com.riwi.entregable_spring.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.riwi.entregable_spring.Entity.Event;
import com.riwi.entregable_spring.Repository.EventRepository;
import com.riwi.entregable_spring.Services.abstract_event.IEventService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService implements IEventService{
    @Autowired
    public EventRepository objEventRepository;
    
    @Override
    public List<Event> getAll() {
         return this.objEventRepository.findAll();
    }

    @Override
    public Event save(Event objEvent) {
        
          return objEvent.getCapacidad() > 0  && objEvent.getFecha().isAfter(LocalDate.now()) 
          ?  this.objEventRepository.save(objEvent)
            : null;
    }

    @Override
    public Event getById(String id) {
        return this.objEventRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(String id) {
        this.objEventRepository.deleteById(id);
    }
    @Override
    public Event update(Event objEvent) {
        return this.objEventRepository.save(objEvent);
    }
}
