package com.healthcare.patientservice.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Patient {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;

}
