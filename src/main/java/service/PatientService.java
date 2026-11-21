package service;

import model.Patient;

public class PatientService {
    private Patient[] patients = new Patient[100];
    private int count = 0;

    public int getNextPatientId() { return count + 1; }

    public void registerPatient(String name, int age) {
        if (count == patients.length) {
<<<<<<< HEAD
            System.out.println("Patient list is full.");
=======
            System.out.println("Patients list is full.");
>>>>>>> friend/main
            return;
        }
        if (name.length() == 0 || age <= 0) {
            System.out.println("Invalid patient details.");
            return;
        }
        Patient patient = new Patient(count + 1, name, age);
        patients[count] = patient;
        count++;
        System.out.println("Patient registered. ID: " + patient.getId());
    }

    public Patient findPatient(int id) {
        for (int i = 0; i < count; i++) {
            if (patients[i].getId() == id) return patients[i];
        }
        return null;
    }

    public void viewPatients() {
<<<<<<< HEAD
        if (count == 0) System.out.println("No patients registered.");
=======
        if (count == 0) System.out.println("No patient registered.");
>>>>>>> friend/main
        for (int i = 0; i < count; i++) {
            Patient p = patients[i];
            System.out.println(p.getId() + " | " + p.getName() + " | Age: " + p.getAge());
        }
    }
}
