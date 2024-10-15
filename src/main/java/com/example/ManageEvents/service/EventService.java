package com.example.ManageEvents.service;

import com.example.ManageEvents.model.Event;
import com.example.ManageEvents.model.Registration;
import com.example.ManageEvents.repository.EventRepository;
import com.example.ManageEvents.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public void registerForEvent(Registration registration, Long eventId) {
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event != null) {
            registration.setEvent(event);
            registrationRepository.save(registration);
        }
    }
}


