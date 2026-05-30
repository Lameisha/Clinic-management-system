import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.ArrayList;

class Patient {
    String idNumber;
    String firstName;
    String lastName;
    String category;
    String priorityLevel;

    public Patient(String idNumber, String firstName, String lastName, String category, String priorityLevel) {
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.category = category;
        this.priorityLevel= priorityLevel;
    }
}

class Appointment {

    String id;
    String date;
    String time;
    String status;

    Appointment(String id,  String date, String time, String status) {

        this.id = id;
        this.date = date;
        this.time = time;
        this.status = status;

    }
}


public class ClinicFileSystem {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Patient> patientDatabase = new ArrayList<>();
        ArrayList<Appointment> appointment = new ArrayList<>();

        try {
            String url = "jdbc:mysql://localhost:3306/mydb";
            String user = "root";
            String password = "";

            java.sql.Connection testConn = java.sql.DriverManager.getConnection(url, user, password);
            System.out.println("🚀 SUCCESS: Java is connected to MySQL Workbench!");
            testConn.close();

        } catch (java.sql.SQLException e) {
            System.out.println("❌ CONNECTION FAILED: " + e.getMessage());
        }
        String[] doctors = {"Dr Lopez", "Dr Khumalo", "Dr Johnson", "Dr Mathe", "Dr Dlamini"};
        String[] nurses = {"Nurse Ndlovu", "Nurse Jacobs", "Nurse Zwane", "Nurse Naidoo", "Nurse Gumede"};
        boolean[] doctorAvailable = {false, true};


        patientDatabase.add(new Patient("PAT-1002", "Amahle", "Mathe", "Regular", "Low"));
        patientDatabase.add(new Patient("PAT-1043", "Thando", "Sithebe", "Regular", "Low"));
        patientDatabase.add(new Patient("PAT-1602", "Siya", "Pholwane", "Critical", "Urgent"));
        patientDatabase.add(new Patient("PAT-2071", "John", "Loate", "Elder", "Urgent"));
        patientDatabase.add(new Patient("PAT-1103", "Blakely", "Paracha", "Pregnant", "High"));
        patientDatabase.add(new Patient("PAT-1126", "Lethabo", "Dlamini", "Regular", "Low"));
        patientDatabase.add(new Patient("PAT-2201", "Ayanda", "Ndlovu", "Critical", "Urgent"));
        patientDatabase.add(new Patient("PAT-6681", "Catherine", "Diallo", "Pregnant", "High"));
        patientDatabase.add(new Patient("PAT-8831", "Ousmane", "Lysiak", "Elder", "Medium"));
        patientDatabase.add(new Patient("PAT-4023", "Sipho", "Zulu", "Regular", "Low"));
        patientDatabase.add(new Patient("PAT-5927", "Gabriel", "Gumede", "Critical", "Urgent"));
        patientDatabase.add(new Patient("PAT-2399", "Ava", "Steven", "Pregnant", "High"));
        patientDatabase.add(new Patient("PAT-9783", "Fumani", "Ngwenya", "Elder", "Medium"));
        patientDatabase.add(new Patient("PAT-4755", "Oscar", "Phiri", "Regular", "Low"));
        patientDatabase.add(new Patient("PAT-9631", "Rachel", "Mwenye", "Critical", "Urgent"));
        patientDatabase.add(new Patient("PAT-1198", "Cord", "Asante", "Pregnant", "High"));
        patientDatabase.add(new Patient("PAT-6139", "Deja", "Ture", "Elder", "Medium"));
        patientDatabase.add(new Patient("PAT-1954", "Kofi", "Tau", "Regular", "Low"));
        patientDatabase.add(new Patient("PAT-3001", "Zuri", "Jamela", "Pregnant", "High"));
        patientDatabase.add(new Patient("PAT-9771", "Adelaide", "Conor", "Critical", "Urgent"));

        appointment.add(new Appointment("PAT-1002", "2024-06-08", "08:00:00", "Confirmed"));
        appointment.add(new Appointment("PAT-1043", "2024-06-08", "09:00:00", "Scheduled"));
        appointment.add(new Appointment("PAT-1602", "2024-06-09", "10:00:00", "Confirmed"));
        appointment.add(new Appointment("PAT-2071", "2024-06-09", "11:00:00", "Pending"));
        appointment.add(new Appointment("PAT-1103", "2024-06-10", "12:00:00", "Scheduled"));
        appointment.add(new Appointment("PAT-1126", "2024-06-10", "14:00:00", "Confirmed"));
        appointment.add(new Appointment("PAT-2201", "2024-06-11", "08:30:00", "Scheduled"));
        appointment.add(new Appointment("PAT-6681", "2024-06-11", "09:30:00", "Pending"));
        appointment.add(new Appointment("PAT-8831", "2024-06-12", "10:30:00", "Confirmed"));
        appointment.add(new Appointment("PAT-4023", "2024-06-12", "11:30:00", "Scheduled"));
        appointment.add(new Appointment("PAT-5927", "2024-06-15", "13:00:00", "Confirmed"));
        appointment.add(new Appointment("PAT-2399", "2024-06-15", "14:30:00", "Pending"));
        appointment.add(new Appointment("PAT-9783", "2024-06-16", "08:15:00", "Scheduled"));
        appointment.add(new Appointment("PAT-4755", "2024-06-16", "09:45:00", "Confirmed"));
        appointment.add(new Appointment("PAT-9631", "2024-06-17", "11:10:00", "Scheduled"));
        appointment.add(new Appointment("PAT-1198", "2024-06-17", "12:45:00", "Pending"));
        appointment.add(new Appointment("PAT-6139", "2024-06-18", "14:00:00", "Confirmed"));
        appointment.add(new Appointment("PAT-1954", "2024-06-18", "15:00:00", "Scheduled"));
        appointment.add(new Appointment("PAT-3001", "2024-06-19", "09:00:00", "Confirmed"));
        appointment.add(new Appointment("PAT-9771", "2024-06-19", "10:35:00", "Pending"));

        int nurseCounter = 0;
        mainLoop:
        while (true) {
            System.out.println();
            JOptionPane.showMessageDialog(null, "Welcome to Clinic File_System!\n" +
                    "Current Files: " + patientDatabase.size());
            String idNumber = JOptionPane.showInputDialog(null, "Enter patient ID: ");
            System.out.println();
            if (idNumber == null || idNumber.equalsIgnoreCase("Exit")) {
                JOptionPane.showMessageDialog(null, "System closed...\nGoodbye!");
                break mainLoop;
            }

            if (idNumber.equalsIgnoreCase("Doctor")) {
                System.out.println("\n--- Doctor's Urgent List---");
                for (Patient p : patientDatabase) {
                    if (p.priorityLevel.equals("Urgent")) {
                        System.out.println("ID: " + p.idNumber + " | Name: " + p.firstName + " " + p.lastName);
                    }
                }
                continue;
            }

            if (idNumber.equalsIgnoreCase("Appointment")) {
                System.out.println("\n--- Clinic Appointments List ---");
                for (Appointment a : appointment) {
                    System.out.println("ID: " + a.id + " | Date: " + a.date + " | Time: " + a.time + " | Status: " + a.status);
                }
                continue;

            }

            boolean isAssignedNurse = false;
            boolean found = false;
            for (Patient p : patientDatabase) {
                if (p.idNumber.equalsIgnoreCase(idNumber)) {
                    found = true;
                    JOptionPane.showMessageDialog(null, "Patient File Found!\n" +
                            "Patient Name: " + p.firstName + " " + p.lastName + "\n" + "Category: " + p.category);

                    String choice = JOptionPane.showInputDialog(null, "\nWhy are you here today?\n\n" +
                            "1. Appointment\n" +
                            "2. Medication\n" +
                            "3. Check-up\n\n" +
                            "Choose option: ");

                    System.out.println();

                    try {


                        int option = Integer.parseInt(choice);
                        switch (option) {

                            case 1:

                                int appt = JOptionPane.showConfirmDialog(null, "Do you have an appointment?",
                                        "Appointment",
                                        JOptionPane.YES_NO_OPTION);
                                if (appt == JOptionPane.YES_OPTION) {
                                    boolean idInSystem = false;
                                    for (Appointment a : appointment) {
                                        if (a.id.equalsIgnoreCase(p.idNumber)) {
                                            idInSystem = true;
                                            break;
                                        }
                                    }
                                    if (idInSystem) {
                                        String appointmentSymptoms = JOptionPane.showInputDialog(null, "Describe your symptoms: ");
                                        JOptionPane.showMessageDialog(null, "Appointment confirmed.\n\n" +
                                                "Assigned to : " + "Dr Lopez\n" +
                                                "Symptoms: " + appointmentSymptoms + "\n\nPlease proceed to waiting queue.");
                                           isAssignedNurse = false;
                                        int docIndex = 0;
                                        if (!doctorAvailable[docIndex]) {
                                            String assignedNurse = nurses[nurseCounter];
                                            JOptionPane.showMessageDialog(null, "Doctor Lopez is currently busy.\n\n" + assignedNurse + " will assist you in the meantime.");
                                            nurseCounter = (nurseCounter + 1) % nurses.length;
                                            isAssignedNurse = true;
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Doctor is available. Please procced to Dr Lopez.\n");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "System alert: No scheduled found for patient id.");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Please book an appointment first.");


                                    int bookAppt = JOptionPane.showConfirmDialog(null, "Would you like to book an appointment?",
                                            "Appointment", JOptionPane.YES_NO_OPTION);

                                    if (bookAppt == JOptionPane.YES_OPTION) {
                                        String doctorChoice = (String) JOptionPane.showInputDialog(null, "Choose doctor:\n\n",
                                                "Appointment",
                                                JOptionPane.QUESTION_MESSAGE,
                                                null,
                                                doctors,
                                                doctors[0]);
                                        if (doctorChoice != null) {
                                            String day = JOptionPane.showInputDialog(null, "Enter day (today or date): ");
                                            String time = JOptionPane.showInputDialog(null, "Enter time: ");
                                            JOptionPane.showMessageDialog(null, "Appointment booked with : " + doctorChoice +

                                                    "\n" + day  +
                                                    " : " + time);
                                                isAssignedNurse = true;
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No appointment booked.");
                                        isAssignedNurse = true;
                                    }
                                }
                                break;
                            case 2:
                                String medSymptoms = JOptionPane.showInputDialog(null, "Describe your symptoms or medication problem: ");
                                JOptionPane.showMessageDialog(null, "Medication concern confirmed.\n\n" +
                                        "Assigned Doctor: Dr Khumalo\n" +
                                        "Symptoms: " + medSymptoms + "\n\nProceed to pharmacy/waiting room.");

                                break;
                            case 3:
                                String checkupSymptoms = JOptionPane.showInputDialog(null, "Describe your symptoms or concerns: ");
                                JOptionPane.showMessageDialog(null, "Check-up request recorded.\n\n" +
                                        "Assigned Doctor: Dr Johnson\n" +
                                        "Symptoms: " + checkupSymptoms + "\n\nPlease proceed to waiting queue.");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Invalid option entered! Please try again.");
                        }

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please enter numbers only!");
                    }

                    String staffMessage = "";
                    if (p.priorityLevel.equals("Urgent")) {
                        staffMessage = "[STAFF ONLY]\n" + "Doctor: Immediate assistance required for this patient!";
                    } else if (p.priorityLevel.equals("High")) {
                        staffMessage = "[STAFF ONLY]\n" +
                                "Doctor: High priority - assist as soon as possible.";
                    } else if (p.priorityLevel.equals("Medium")) {
                        staffMessage = "[STAFF ONLY]\n" + "Doctor: Standard queue priority.";
                    } else {
                        staffMessage = "[STAFF ONLY]\n" + "Doctor: Routine check/consultation.";
                    }
                    System.out.println(staffMessage);

                    if (!isAssignedNurse) {
                        if (p.priorityLevel.equals("Urgent")) {
                            JOptionPane.showMessageDialog(null, "A healthcare professional will assist you shortly!");
                        } else if (p.priorityLevel.equals("High")) {
                            JOptionPane.showMessageDialog(null, "You will be assisted soon!");
                        } else if (p.priorityLevel.equals("Medium")) {
                            JOptionPane.showMessageDialog(null, "Please wait in the Queue!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Standard waiting time applies!");
                        }
                    }
                    break;
                }
            }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Patient Not found!\nRedirecting to file Registration Form....");
                    Thread.sleep(3000);
                    System.out.println();

                    String firstName = JOptionPane.showInputDialog(null, "Enter First Name: ");
                    String lastName = JOptionPane.showInputDialog(null, "Enter Last Name: ");
                    String category = JOptionPane.showInputDialog(null, "Enter Category (Critical, Pregnant, Elder, Regular): ");


                    String priorityLevel;
                    if (category != null && category.equalsIgnoreCase("Critical")) {
                        priorityLevel = "Urgent";
                    } else if (category != null && category.equalsIgnoreCase("Pregnant")) {
                        priorityLevel = "High";
                    } else if (category != null && category.equalsIgnoreCase("Elder")) {
                        priorityLevel = "Medium";
                    } else {
                        priorityLevel = "Low";
                    }

                    patientDatabase.add(new Patient(idNumber, firstName, lastName, category, priorityLevel));
                    JOptionPane.showMessageDialog(null, "\nPatient successfully registered!\n\n" + "Priority Level: " + priorityLevel);


                }
            }

        }

    }


