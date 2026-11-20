package model;

public class Bill {
    private int id;
    private int appointmentId;
    private double amount;

    public Bill(int id, int appointmentId, double amount) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.amount = amount;
    }

    public int getId() { return id; }
    public int getAppointmentId() { return appointmentId; }
    public double getAmount() { return amount; }
}
