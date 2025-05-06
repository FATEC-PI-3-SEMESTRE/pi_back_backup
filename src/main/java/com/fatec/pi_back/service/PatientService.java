package main.java.com.fatec.pi_back.service;

@Service
public class PatientService {

    public TimeInterval createPatient(PatientDTO data) {
        Patient patient = new Patient();
        patient.setPatient(data.Patient());
        return patient;
    }
}
