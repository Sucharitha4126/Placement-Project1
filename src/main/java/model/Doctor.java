package model;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private String schedule;
    private double fee;

    public Doctor(int id, String name, String specialization, String schedule, double fee) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.schedule = schedule;
        this.fee = fee;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public String getSchedule() { return schedule; }
    public double getFee() { return fee; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
}
