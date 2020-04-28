package com.appointments.project;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AppointmentsRepository extends CrudRepository<Appointment, Long>{
    Appointment findById(long id);
}