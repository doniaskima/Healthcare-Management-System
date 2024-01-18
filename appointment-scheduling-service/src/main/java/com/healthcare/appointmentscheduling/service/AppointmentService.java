package com.healthcare.appointmentscheduling.service;

import com.healthcare.appointmentscheduling.model.Appointment;
import com.healthcare.appointmentscheduling.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointmentById(String id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public Appointment updateAppointment(String id, Appointment updatedAppointment) {
        return appointmentRepository.findById(id)
                .map(appointment -> {
                    appointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
                    appointment.setAppointmentType(updatedAppointment.getAppointmentType());
                    // Update other fields
                    return appointmentRepository.save(appointment);
                }).orElse(null);
    }

    public void deleteAppointment(String id) {
        appointmentRepository.deleteById(id);
    }
}
