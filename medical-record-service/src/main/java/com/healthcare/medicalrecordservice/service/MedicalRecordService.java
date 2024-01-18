package com.healthcare.medicalrecordservice.service;

import com.healthcare.medicalrecordservice.model.MedicalRecord;
import com.healthcare.medicalrecordservice.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecord createMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    public MedicalRecord getMedicalRecordById(String id) {
        return medicalRecordRepository.findById(id).orElse(null);
    }

    public MedicalRecord updateMedicalRecord(String id, MedicalRecord updatedMedicalRecord) {
        return medicalRecordRepository.findById(id)
                .map(record -> {
                    record.setRecordDate(updatedMedicalRecord.getRecordDate());
                    record.setDetails(updatedMedicalRecord.getDetails());
                    // Update other fields
                    return medicalRecordRepository.save(record);
                }).orElse(null);
    }

    public void deleteMedicalRecord(String id) {
        medicalRecordRepository.deleteById(id);
    }
}
