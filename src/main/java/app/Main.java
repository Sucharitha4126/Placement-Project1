package app;

import java.util.Scanner;
import service.PatientService;
import service.DoctorService;
import service.AppointmentService;
import service.BillingService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientService patients = new PatientService();
        DoctorService doctors = new DoctorService();
        AppointmentService appointments = new AppointmentService();
        BillingService billing = new BillingService();
        int choice = 0;

        do {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors and Schedules");
            System.out.println("5. Update Doctor Schedule");
            System.out.println("6. Book Appointment");
            System.out.println("7. View Appointments");
            System.out.println("8. Cancel Appointment");
            System.out.println("9. Generate Bill");
            System.out.println("10. View Bills");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Automatically assigned Patient ID: " + patients.getNextPatientId());
                        System.out.print("Patient name: ");
                        String patientName = sc.nextLine();
                        System.out.print("Age: ");
                        int age = Integer.parseInt(sc.nextLine());
                        patients.registerPatient(patientName, age);
                        break;
                    case 2:
                        patients.viewPatients();
                        break;
                    case 3:
                        System.out.println("Automatically assigned Doctor ID: " + doctors.getNextDoctorId());
                        System.out.print("Doctor name: ");
                        String doctorName = sc.nextLine();
                        System.out.print("Specialization: ");
                        String specialization = sc.nextLine();
                        System.out.print("Schedule (e.g. Mon 10AM-12PM): ");
                        String schedule = sc.nextLine();
                        System.out.print("Consultation fee: ");
                        double fee = Double.parseDouble(sc.nextLine());
                        doctors.addDoctor(doctorName, specialization, schedule, fee);
                        break;
                    case 4:
                        doctors.viewDoctors();
                        break;
                    case 5:
                        System.out.print("Doctor ID: ");
                        int scheduleDoctorId = Integer.parseInt(sc.nextLine());
                        System.out.print("New schedule: ");
                        doctors.changeSchedule(scheduleDoctorId, sc.nextLine());
                        break;
                    case 6:
                        System.out.print("Patient ID: ");
                        int patientId = Integer.parseInt(sc.nextLine());
                        if (patients.findPatient(patientId) == null) {
                            System.out.println("Patient not found. Register the patient first.");
                            break;
                        }
                        System.out.print("Describe the patient's problem or symptoms: ");
                        String problem = sc.nextLine();
                        String specialist = suggestSpecialization(problem);
                        System.out.println("Suggested specialization: " + specialist);
                        System.out.println("This is a basic suggestion, not a medical diagnosis.");
                        doctors.suggestDoctors(specialist);
                        System.out.print("Enter Doctor ID to book: ");
                        int doctorId = Integer.parseInt(sc.nextLine());
                        System.out.print("Date (DD-MM-YYYY): ");
                        String date = sc.nextLine();
                        System.out.print("Time (e.g. 10:00): ");
                        String time = sc.nextLine();
                        appointments.bookAppointment(patientId, doctorId, date, time, patients, doctors);
                        break;
                    case 7:
                        appointments.viewAppointments();
                        break;
                    case 8:
                        System.out.print("Appointment ID: ");
                        appointments.cancelAppointment(Integer.parseInt(sc.nextLine()));
                        break;
                    case 9:
                        System.out.print("Appointment ID: ");
                        billing.generateBill(Integer.parseInt(sc.nextLine()), appointments, doctors);
                        break;
                    case 10:
                        billing.viewBills();
                        break;
                    case 11:
                        System.out.println("Thank you!");
                        break;
                    default:
                        System.out.println("Invalid menu choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        } while (choice != 11);
        sc.close();
    }

    // Simple keyword matching; this is not a medical diagnosis.
    public static String suggestSpecialization(String problem) {
        String p = problem.toLowerCase();
        if (p.contains("chest pain") || p.contains("heart") || p.contains("palpitation")) {
            return "Cardiologist";
        } else if (p.contains("skin") || p.contains("rash") || p.contains("acne") || p.contains("itch")) {
            return "Dermatologist";
        } else if (p.contains("tooth") || p.contains("teeth") || p.contains("gum") || p.contains("dental")) {
            return "Dentist";
        } else if (p.contains("eye") || p.contains("vision")) {
            return "Ophthalmologist";
        } else if (p.contains("ear") || p.contains("nose") || p.contains("throat")) {
            return "ENT";
        } else if (p.contains("bone") || p.contains("joint") || p.contains("fracture") || p.contains("knee")) {
            return "Orthopedic";
        } else if (p.contains("child") || p.contains("baby") || p.contains("infant")) {
            return "Pediatrician";
        } else if (p.contains("headache") || p.contains("migraine") || p.contains("seizure")) {
            return "Neurologist";
        } else if (p.contains("stomach") || p.contains("digestion") || p.contains("abdomen")) {
            return "Gastroenterologist";
        } else {
            return "General Physician";
        }
    }
}
