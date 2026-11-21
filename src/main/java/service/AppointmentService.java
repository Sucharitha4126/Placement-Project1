package service;

import model.Appointment;

public class AppointmentService {
    private Appointment[] appointments = new Appointment[100];
    private int count = 0;

    public void bookAppointment(int patientId, int doctorId, String date, String time,
                                PatientService patientService, DoctorService doctorService) {
        if (patientService.findPatient(patientId) == null || doctorService.findDoctor(doctorId) == null) {
            System.out.println("Patient or doctor not found.");
            return;
        }
        if (date.length() == 0 || time.length() == 0) {
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> nisha/main
            System.out.println("Date and time cannot be empty.");
            return;
        }
        if (count == appointments.length) {
            System.out.println("Appointment list is full.");
<<<<<<< HEAD
=======
            System.out.println("Date and time  cannot be empty.");
            return;
        }
        if (count == appointments.length) {
            System.out.println("Appointments list is full.");
>>>>>>> friend/main
=======
>>>>>>> nisha/main
            return;
        }
        for (int i = 0; i < count; i++) {
            Appointment a = appointments[i];
            if (a.isActive() && a.getDoctorId() == doctorId &&
                a.getDate().equals(date) && a.getTime().equals(time)) {
<<<<<<< HEAD
<<<<<<< HEAD
                System.out.println("Doctor is already booked at that time.");
=======
                System.out.println("The doctor has another appointment at that time.");
>>>>>>> friend/main
=======
                System.out.println("Doctor is already booked at that time.");
>>>>>>> nisha/main
                return;
            }
        }
        Appointment appointment = new Appointment(count + 1, patientId, doctorId, date, time);
        appointments[count] = appointment;
        count++;
        System.out.println("Appointment booked. ID: " + appointment.getId());
    }

    public Appointment findAppointment(int id) {
        for (int i = 0; i < count; i++) {
            if (appointments[i].getId() == id) return appointments[i];
        }
        return null;
    }

    public void cancelAppointment(int id) {
        Appointment a = findAppointment(id);
        if (a == null || !a.isActive()) {
            System.out.println("Active appointment not found.");
        } else {
            a.cancel();
<<<<<<< HEAD
<<<<<<< HEAD
            System.out.println("Appointment cancelled.");
=======
            System.out.println("The appointment has been cancelled.");
>>>>>>> friend/main
=======
            System.out.println("Appointment cancelled.");
>>>>>>> nisha/main
        }
    }

    public void viewAppointments() {
        if (count == 0) System.out.println("No appointments.");
        for (int i = 0; i < count; i++) {
            Appointment a = appointments[i];
            String status = a.isActive() ? "Booked" : "Cancelled";
            System.out.println(a.getId() + " | Patient: " + a.getPatientId()
                + " | Doctor: " + a.getDoctorId() + " | " + a.getDate()
                + " " + a.getTime() + " | " + status);
        }
    }
}
 