package com.riwi.entregable_spring.Controller;

import java.time.LocalDate;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.entregable_spring.Entity.Event;
import com.riwi.entregable_spring.Services.abstract_event.IEventService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/events")
@AllArgsConstructor
public class EventController {
    @Autowired
    private final IEventService ojbIEventService;

    @GetMapping
    public ResponseEntity<List<Event>> getAll(){
        return ResponseEntity.ok(this.ojbIEventService.getAll());
    }

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event objEvent){
        return ResponseEntity.ok(this.ojbIEventService.save(objEvent));
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> getById(@PathVariable String id){
        return ResponseEntity.ok(this.ojbIEventService.getById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Event> update(
        @RequestBody Event objEvent,
        @PathVariable String id
    ){
        objEvent.setId(id);
        return ResponseEntity.ok(this.ojbIEventService.update(objEvent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.ojbIEventService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
