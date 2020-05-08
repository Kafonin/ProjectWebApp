package com.appointments.project;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HomeController
 */
@Controller
public class HomeController {

    @Autowired
    private AppointmentsRepository repository;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping("/addAppointment")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment, Model model) {
        repository.save(appointment);
        
        List<Appointment> appointments = (List<Appointment>) repository.findAll();
        model.addAttribute("appointments", appointments);
        return "index";
    }

    /*@RequestMapping("getAppointmentById")
    public String getAppointment(@RequestParam("name") String name, Model model) {
        model.addAttribute("users", ((Collection<Appointment>) repository.findAll()).stream().filter(u -> u.getName().equalsIgnoreCase(name)).findAny().get());
        
        return "index";
    }*/
}

