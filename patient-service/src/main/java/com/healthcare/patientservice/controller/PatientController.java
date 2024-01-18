package com.healthcare.patientservice.controller;

import com.healthcare.patientservice.dto.PatientDTO;
import com.healthcare.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/")
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDTO) {
        PatientDTO savedPatientDTO = patientService.createPatient(patientDTO);
        return ResponseEntity.ok(savedPatientDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable String id) {
        PatientDTO patientDTO = patientService.getPatientById(id);
        return patientDTO != null ? ResponseEntity.ok(patientDTO) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable String id, @RequestBody PatientDTO patientDTO) {
        PatientDTO updatedPatientDTO = patientService.updatePatient(id, patientDTO);
        return updatedPatientDTO != null ? ResponseEntity.ok(updatedPatientDTO) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable String id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok().build();
    }
}
