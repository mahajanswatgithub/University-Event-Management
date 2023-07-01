package com.example.UniversityEventManagement.repository;

import com.example.UniversityEventManagement.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IEventRepo extends CrudRepository<Event,Integer> {
    List<Event> findAllEventByDate(LocalDate date);
}
