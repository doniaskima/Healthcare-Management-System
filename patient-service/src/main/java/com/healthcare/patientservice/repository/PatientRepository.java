package com.healthcare.patientservice.repository;

import com.healthcare.patientservice.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
   
}
