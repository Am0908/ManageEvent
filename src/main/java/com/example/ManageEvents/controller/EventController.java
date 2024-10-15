package com.example.ManageEvents.controller;

import com.example.ManageEvents.model.Event;
import com.example.ManageEvents.model.Registration;
import com.example.ManageEvents.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "index"; // Should match the name of the HTML file without .html
    }

    @PostMapping("/register/{eventId}")
    public String register(@PathVariable Long eventId, @ModelAttribute Registration registration) {
        eventService.registerForEvent(registration, eventId);
        return "redirect:/";
    }

    @GetMapping("/events")
    @ResponseBody
    public List<Event> getEvents() {
        return eventService.getAllEvents();
    }

}

