package service;

import model.Appointment;
import model.Bill;
import model.Doctor;

public class BillingService {
    private Bill[] bills = new Bill[100];
    private int count = 0;

    public void generateBill(int appointmentId, AppointmentService appointmentService,
                             DoctorService doctorService) {
        Appointment appointment = appointmentService.findAppointment(appointmentId);
        if (appointment == null || !appointment.isActive()) {
            System.out.println("Active appointment not found.");
            return;
        }
        for (int i = 0; i < count; i++) {
            if (bills[i].getAppointmentId() == appointmentId) {
                System.out.println("Bill already generated for this appointment.");
                return;
            }
        }
        if (count == bills.length) {
            System.out.println("Bill list is full.");
            return;
        }
        Doctor doctor = doctorService.findDoctor(appointment.getDoctorId());
        Bill bill = new Bill(count + 1, appointmentId, doctor.getFee());
        bills[count] = bill;
        count++;
        System.out.println("Bill ID: " + bill.getId() + " | Amount: Rs." + bill.getAmount());
    }

    public void viewBills() {
        if (count == 0) System.out.println("No bills generated.");
        for (int i = 0; i < count; i++) {
            Bill b = bills[i];
            System.out.println("Bill: " + b.getId() + " | Appointment: "
                + b.getAppointmentId() + " | Rs." + b.getAmount());
        }
    }
}
