package com.healthcare.patientservice.service;

import com.healthcare.patientservice.dto.PatientDTO;
import com.healthcare.patientservice.model.Patient;
import com.healthcare.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient = convertToEntity(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        return convertToDto(savedPatient);
    }

    public PatientDTO getPatientById(String id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.map(this::convertToDto).orElse(null);
    }

    public PatientDTO updatePatient(String id, PatientDTO patientDTO) {
        return patientRepository.findById(id).map(patient -> {
            updatePatientEntity(patient, patientDTO);
            Patient updatedPatient = patientRepository.save(patient);
            return convertToDto(updatedPatient);
        }).orElse(null);
    }

    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }

    private Patient convertToEntity(PatientDTO dto) {
        Patient patient = new Patient();
        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setEmail(dto.getEmail());
        patient.setPhoneNumber(dto.getPhoneNumber());
        return patient;
    }

    private PatientDTO convertToDto(Patient patient) {
        PatientDTO dto = new PatientDTO();
        dto.setId(patient.getId());
        dto.setFirstName(patient.getFirstName());
        dto.setLastName(patient.getLastName());
        dto.setDateOfBirth(patient.getDateOfBirth());
        dto.setEmail(patient.getEmail());
        dto.setPhoneNumber(patient.getPhoneNumber());
        return dto;
    }

    private void updatePatientEntity(Patient patient, PatientDTO dto) {
        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setEmail(dto.getEmail());
        patient.setPhoneNumber(dto.getPhoneNumber());
    }
}
