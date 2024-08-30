Hospital Management System Overview
Purpose:
The Java-based Hospital Management System is designed to manage various aspects of hospital operations, including patient registration, appointment scheduling, electronic health records (EHR), billing, medical supplies, and staff management. The user interface is built using Java Swing, providing a graphical interface for interaction.

Main Features:

Patient Registration:

Allows users to register new patients by collecting their name, age, gender, contact number, and medical history.
Validates the input to ensure that all fields are filled.
Patient records are saved in a text file (PatientRecord.txt).
Appointment Scheduling:

Users can schedule appointments by entering the patient's name, doctor’s name, and appointment date.
The system checks for mandatory fields and shows available doctors before scheduling.
Electronic Health Records (EHR):

Users can view a patient's electronic health record by entering their name.
Displays patient details if found in the system.
Billing Management:

Enables users to manage billing for patients by entering the patient’s name and the billing amount.
Displays the billing details after successful entry.
Medical Supplies Management:

Manages hospital supplies by allowing users to enter the supply name and quantity.
Supplies are tracked within the system for inventory purposes.
Staff Management:

Facilitates staff management by allowing users to enter staff names and their positions.
Adds new staff members to the internal list.
Doctor Availability:

Displays a predefined list of doctors with their specialties, providing users with information about available doctors.
Class Structure:

Patient Class: Stores patient details including name, age, gender, contact number, and medical history.
Appointment Class: Manages appointment details such as patient name, doctor name, and appointment date.
Billing Class: Stores billing information for patients.
MedicalSupply Class: Tracks medical supplies by name and quantity.
Staff Class: Manages staff information including name and position.
Doctor Class: Contains details of doctors, including their name, specialty, and experience.
Overall Design: The system is well-structured with a user-friendly interface that makes hospital management tasks more efficient. Each module is designed to handle a specific function, contributing to an integrated management system. Validation checks ensure data integrity, while the use of file handling enables persistent storage of patient records.
