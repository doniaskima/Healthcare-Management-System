package com.healthcare.medicalrecordservice.repository;

import com.healthcare.medicalrecordservice.model.MedicalRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicalRecordRepository extends MongoRepository<MedicalRecord, String> {
    
}