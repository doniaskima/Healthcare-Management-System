package com.healthcare.appointmentscheduling.repository;

import com.healthcare.appointmentscheduling.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
     
}
