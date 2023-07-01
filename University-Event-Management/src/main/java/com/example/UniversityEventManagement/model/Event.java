package com.example.UniversityEventManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Event" )
public class Event {
    @Id
    private Integer eventId;
    @NotNull
    private String eventName;
    @NotNull
    private String locationOfEvent;
    @NotNull
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
}
