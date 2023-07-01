package com.example.UniversityEventManagement.service;

import com.example.UniversityEventManagement.model.Event;
import com.example.UniversityEventManagement.model.Student;
import com.example.UniversityEventManagement.repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    IEventRepo eventRepo;

    public String addEventInfo(Event event) {
        eventRepo.save(event);
        return "Event Info Added";
    }

    public Iterable<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public String updateEventLocationById(Integer id, String location) {
        Optional<Event> event = eventRepo.findById(id);
        Event e = null;
        if(event.isPresent())
        {
            e = event.get();
        }
        else {
            return "Id not Found!!!";
        }
        e.setLocationOfEvent(location);
        eventRepo.save(e);
        return "Event Location updated";
    }

    public String deleteEventById(Integer id) {
        eventRepo.deleteById(id);
        return "Event deleted successfully of id "+id;
    }

    public List<Event> getAllEventByDate(LocalDate date) {
        return eventRepo.findAllEventByDate(date);
    }

    public String addEvents(List<Event> events) {
        eventRepo.saveAll(events);
        return "Events Added"+events;
    }
}
