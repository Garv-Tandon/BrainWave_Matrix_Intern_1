import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class HospitalManagementSystem extends JFrame {

    private List<Patient> patients = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    private List<Staff> staffList = new ArrayList<>();
    private List<MedicalSupply> supplies = new ArrayList<>();
    private List<Doctor> doct = new ArrayList<>();
    public HospitalManagementSystem() {
        
        
        setTitle("Hospital Management System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton registerPatientButton = new JButton("Register Patient");
        registerPatientButton.setBounds(100, 20, 200, 30);
        registerPatientButton.setBackground(Color.GREEN);
        add(registerPatientButton);

        JButton scheduleAppointmentButton = new JButton("Schedule Appointment");
        scheduleAppointmentButton.setBounds(100, 70, 200, 30);
        scheduleAppointmentButton.setBackground(Color.GREEN);
        add(scheduleAppointmentButton);

        JButton viewEHRButton = new JButton("View EHR");
        viewEHRButton.setBounds(100, 120, 200, 30);
        viewEHRButton.setBackground(Color.GREEN);
        add(viewEHRButton);

        JButton manageBillingButton = new JButton("Manage Billing");
        manageBillingButton.setBounds(100, 170, 200, 30);
        manageBillingButton.setBackground(Color.GREEN);
        add(manageBillingButton);

        JButton manageSuppliesButton = new JButton("Manage Supplies");
        manageSuppliesButton.setBounds(100, 220, 200, 30);
        manageSuppliesButton.setBackground(Color.GREEN);
        add(manageSuppliesButton);

        JButton manageStaffButton = new JButton("Manage Staff");
        manageStaffButton.setBounds(100, 270, 200, 30);
        manageStaffButton.setBackground(Color.GREEN);
        add(manageStaffButton);

        JButton DoctorAvailableButton = new JButton("Doctor Available");
        DoctorAvailableButton .setBounds(100, 320, 200, 30);
        DoctorAvailableButton .setBackground(Color.GREEN);
        add(DoctorAvailableButton);

        registerPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerPatient();
            }
        });

        scheduleAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scheduleAppointment();
            }
        });

        viewEHRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewEHR();
            }
        });

        manageBillingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageBilling();
            }
        });

        manageSuppliesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageSupplies();
            }
        });

        manageStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageStaff();
            }
        });
        DoctorAvailableButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                doctors();
            }
        });

        setVisible(true);
    }
    private void registerPatient() {
        String name = JOptionPane.showInputDialog("Enter patient name:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter patient age:"));
        String gender = JOptionPane.showInputDialog("Enter patient gender:");
        String contact = JOptionPane.showInputDialog("Enter contact number:");
        String medicalHistory = JOptionPane.showInputDialog("Enter medical history:");
        if(name==" "|| age==0 || gender==" " || contact==" "|| medicalHistory==" ")
        {
            JOptionPane.showMessageDialog(this, "Please Fill all the details");
        }
        else
        {
        
        Patient patient = new Patient(name, age, gender, contact, medicalHistory);
        patients.add(patient);
        savePatientToFile(patient);

        JOptionPane.showMessageDialog(this, "Patient registered successfully!");
        }
    }
    private void savePatientToFile(Patient patient) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("PatientRecord.txt", true))) {
            writer.write(patient.toString());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving patient record!");
            e.printStackTrace();
        }
    }

    private void scheduleAppointment() {
        doctors();
        String patientName = JOptionPane.showInputDialog("Enter patient name:");
        String doctorName = JOptionPane.showInputDialog("Enter doctor name:");
        String date = JOptionPane.showInputDialog("Enter appointment date:");
        if(patientName==" "|| doctorName==" " || date==" ")
        {
            JOptionPane.showMessageDialog(this, "Please Fill all the details");
        }
        else
        {
        Appointment appointment = new Appointment(patientName, doctorName, date);
        appointments.add(appointment);

        JOptionPane.showMessageDialog(this, "Appointment scheduled successfully!");
        }
    }

    private void viewEHR(){
        String patientName = JOptionPane.showInputDialog("Enter patient name:");
        if(patientName==" ")
        {

            JOptionPane.showMessageDialog(this, "Please Fill all the details");
        }
        
        StringBuilder ehr = new StringBuilder();

        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(patientName)) {
                ehr.append(patient);
            }
        }

        if (ehr.length() > 0) {
            JOptionPane.showMessageDialog(this, ehr.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Patient not found!");
        }
       
    }

    private void manageBilling() {
        String patientName = JOptionPane.showInputDialog("Enter patient name:");
        double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter billing amount:"));
        if(patientName==" " || amount==0)
        {
            JOptionPane.showMessageDialog(this, "Please Fill all the details");
        }
        Billing billing = new Billing(patientName, amount);

        JOptionPane.showMessageDialog(this, "Billing managed successfully!\n" + billing);
    }

    private void manageSupplies() {
        String supplyName = JOptionPane.showInputDialog("Enter supply name:");
        int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter supply quantity:"));
        if(supplyName==" " || quantity==0)
        {
            JOptionPane.showMessageDialog(this, "Please Fill all the details");
        }
        MedicalSupply supply = new MedicalSupply(supplyName, quantity);
        supplies.add(supply);

        JOptionPane.showMessageDialog(this, "Supplies managed successfully!");
    }

    private void manageStaff() {
        String staffName = JOptionPane.showInputDialog("Enter staff name:");
        String position = JOptionPane.showInputDialog("Enter staff position:");
        if(staffName==" " || position==" ")
        {
            JOptionPane.showMessageDialog(this, "Please Fill all the details");
        }
        Staff staff = new Staff(staffName, position);
        staffList.add(staff);

        JOptionPane.showMessageDialog(this, "Staff managed successfully!");
    }

    private void doctors()
    {
        Frame f=new Frame();
        JOptionPane.showMessageDialog(f,"<--------------------Doctors Available------------------>\n\n1) Dr Gaurav Singh ------>  Orthopedic\n\n 2) Dr Shubhas Arora ------>  Pedestrian\n\n 3) Dr Shivam Agarwal ------>  Dermatologist\n\n 4) Dr Harsit Mahajan ------> Psytiachrist\n\n 5) Dr Jaya Sharma ------> Anesthesiologist\n\n 6) Dr Kiya Mullick ------> Oncologist\n\n 7) Dr Varshney Saini ------> Cardiologist\n\n 8) Dr Gauri Maggo ------> Endocrinologist\n\n 9) Dr Faran Khan ------> Allergist\n\n 10) Dr Tarun Singh ------> Hematologist ");
    }


    // Patient class
    class Patient {
        private String name;
        private int age;
        private String gender;
        private String contactNumber;
        private String medicalHistory;

        public Patient(String name, int age, String gender, String contactNumber, String medicalHistory) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.contactNumber = contactNumber;
            this.medicalHistory = medicalHistory;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Patient{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    ", contactNumber='" + contactNumber + '\'' +
                    ", medicalHistory='" + medicalHistory + '\'' +
                    '}';
        }
    }

    // Appointment class
    class Appointment {
        private String patientName;
        private String doctorName;
        private String date;

        public Appointment(String patientName, String doctorName, String date) {
            this.patientName = patientName;
            this.doctorName = doctorName;
            this.date = date;
        }

        @Override
        public String toString() {
            return "Appointment{" +
                    "patientName='" + patientName + '\'' +
                    ", doctorName='" + doctorName + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }
    }

    // Billing class
    class Billing {
        private String patientName;
        private double amount;

        public Billing(String patientName, double amount) {
            this.patientName = patientName;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Billing{" +
                    "patientName='" + patientName + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }

    // MedicalSupply class
    class MedicalSupply {
        private String name;
        private int quantity;

        public MedicalSupply(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "MedicalSupply{" +
                    "name='" + name + '\'' +
                    ", quantity=" + quantity +
                    '}';
        }
    }

    // Staff class
    class Staff {
        private String name;
        private String position;

        public Staff(String name, String position) {
            this.name = name;
            this.position = position;
        }

        @Override
        public String toString() {
            return "Staff{" +
                    "name='" + name + '\'' +
                    ", position='" + position + '\'' +
                    '}';
        }
    }
    // Doctor class
    class Doctor {
        private String dName;
        private String Speciliaty;
        private String dexp;

        public Doctor(String dName, String Speciliaty, String dexp) {
            this.dName = dName;
            this.Speciliaty = Speciliaty;
            this.dexp = dexp;
        }

        @Override
        public String toString() {
            return "Appointment{" +
                    "patientName='" + dName + '\'' +
                    ", doctorName='" + Speciliaty + '\'' +
                    ", date='" + dexp + '\'' +
                    '}';
        }
    }

    // Remaining methods (registerPatient, savePatientToFile, scheduleAppointment, etc.) go here

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HospitalManagementSystem::new);
    }
}
