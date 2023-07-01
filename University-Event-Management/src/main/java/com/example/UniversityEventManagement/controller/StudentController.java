package com.example.UniversityEventManagement.controller;

import com.example.UniversityEventManagement.model.Event;
import com.example.UniversityEventManagement.model.Student;
import com.example.UniversityEventManagement.model.Type;
import com.example.UniversityEventManagement.service.EventService;
import com.example.UniversityEventManagement.service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.executable.ValidateOnExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    EventService eventService;

    //    Add student
    @PostMapping("student")
    public void addStudent(@RequestBody @Valid Student student)
    {
        studentService.addStudentInfo(student);
    }

    @PostMapping("students")
    public String addStudents(@RequestBody @Valid List<Student> students){
        return studentService.addStudents(students);
    }

    //    update student department
    @PutMapping("student/{id}/{department}")
    public String updateStudentDepartmentById(@PathVariable Integer id,@PathVariable Type department){
        return studentService.updateStudentDepartmentById(id,department);
    }
    //    delete student
    @DeleteMapping("student/{id}")
    public String deleteStudentById(@PathVariable Integer id){
        return studentService.deleteStudentById(id);
    }
    //    Get all students
    @GetMapping("students")
    public Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    //    Get student by Id
    @GetMapping("student/{id}")
    public Optional<Student> getRoomById(@PathVariable Integer id){
        return studentService.getRoomById(id);
    }
    //    Add event
    @PostMapping("event")
    public String addEvent(@RequestBody @Valid Event event)
    {
        return eventService.addEventInfo(event);
    }

    @PostMapping("events")
    public String addEvents(@RequestBody @Valid List<Event> events){
        return eventService.addEvents(events);
    }

    //    Update event
    @PutMapping("event/{id}/{location}")
    public String updateEventLocationById(@PathVariable Integer id,@PathVariable String location) {
        return eventService.updateEventLocationById(id, location);
    }
    //    Delete event
    @DeleteMapping("event/{id}")
    public String deleteEventById(@PathVariable Integer id){
        return eventService.deleteEventById(id);
    }
    //    Get All events by date
    @GetMapping("events/date/{date}")
    public List<Event> getEventByDate(@PathVariable LocalDate date)
    {
        return eventService.getAllEventByDate(date);
    }
    @GetMapping("events")
    public Iterable<Event> getAllEvents(){
        return eventService.getAllEvents();
    }
}
