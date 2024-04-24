package com.riwi.entregable_spring.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.entregable_spring.Entity.Event;



public interface EventRepository extends JpaRepository<Event, String> {
    
        
   
}
