package service;

import model.Doctor;

public class DoctorService {
    private Doctor[] doctors = new Doctor[50];
    private int count = 0;

    public int getNextDoctorId() { return count + 1; }

    public void addDoctor(String name, String specialization, String schedule, double fee) {
        if (count == doctors.length) {
            System.out.println("Doctor list is full.");
            return;
        }
        if (name.length() == 0 || specialization.length() == 0 || schedule.length() == 0 || fee < 0) {
            System.out.println("Invalid doctor details.");
            return;
        }
        Doctor doctor = new Doctor(count + 1, name, specialization, schedule, fee);
        doctors[count] = doctor;
        count++;
        System.out.println("Doctor added. ID: " + doctor.getId());
    }

    public void suggestDoctors(String specialization) {
        boolean found = false;
        System.out.println("Available doctors for " + specialization + ":");
        for (int i = 0; i < count; i++) {
            Doctor d = doctors[i];
            if (d.getSpecialization().toLowerCase().contains(specialization.toLowerCase())) {
                System.out.println("ID: " + d.getId() + " | " + d.getName()
                    + " | " + d.getSpecialization() + " | " + d.getSchedule());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching specialist registered. Other doctors:");
            viewDoctors();
        }
    }

    public Doctor findDoctor(int id) {
        for (int i = 0; i < count; i++) {
            if (doctors[i].getId() == id) return doctors[i];
        }
        return null;
    }

    public void changeSchedule(int id, String schedule) {
        Doctor doctor = findDoctor(id);
        if (doctor == null || schedule.length() == 0) {
            System.out.println("Doctor not found or invalid schedule.");
        } else {
            doctor.setSchedule(schedule);
            System.out.println("Schedule updated.");
        }
    }

    public void viewDoctors() {
        if (count == 0) System.out.println("No doctors added.");
        for (int i = 0; i < count; i++) {
            Doctor d = doctors[i];
            System.out.println(d.getId() + " | " + d.getName() + " | " + d.getSpecialization()
                    + " | Schedule: " + d.getSchedule() + " | Fee: Rs." + d.getFee());
        }
    }
}
