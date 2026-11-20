# Hospital Management System (Java Console)

A beginner-friendly project using classes, constructors, arrays, methods, loops, switch, Scanner and try-catch.

## Requirements
JDK 8 or newer. No external libraries or database.

## Compile and run
From the `HospitalManagementSystem` folder:

```bash
javac -d out src/main/java/model/*.java src/main/java/service/*.java src/main/java/app/*.java
java -cp out app.Main
```

In VS Code, open the folder, install Extension Pack for Java, and run `app/Main.java`.

## Demonstration
1. Add doctor: Dr A, General, Mon 10AM-12PM, 500.
2. Register patient: Ravi, 21.
3. Book appointment for patient ID 1, doctor ID 1, date 25-11-2026, time 10:00.
4. View appointments and generate bill for appointment ID 1 (Rs.500).
5. Try booking the same doctor at the same date/time: it is rejected.

## Simplifications
- Arrays hold up to 100 patients, 50 doctors, 100 appointments and 100 bills.
- Data is lost when the program exits.
- Schedules are descriptive text; the program prevents exact duplicate doctor/date/time bookings, but does not validate schedule hours or calendar dates.
- Billing is a one-time consultation fee per active appointment; it does not track payments or refunds.
- No real patient data should be used; this is a classroom demonstration only.

## Updated features
- Patient and doctor IDs are assigned automatically and displayed before entering details.
- Appointment booking asks about symptoms and suggests a specialization using simple keyword checks.
- Matching registered doctors are listed; the user chooses the doctor ID.
- Suggestions are only a classroom demonstration, not medical diagnosis or emergency advice.
- Data is stored in arrays and is not saved after exiting.
