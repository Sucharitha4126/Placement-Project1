package model;

public class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private String date;
    private String time;
    private boolean active;

    public Appointment(int id, int patientId, int doctorId, String date, String time) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.active = true;
    }

    public int getId() { return id; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public boolean isActive() { return active; }
    public void cancel() { active = false; }
}
