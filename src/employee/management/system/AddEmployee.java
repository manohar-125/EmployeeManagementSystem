package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    Random rand = new Random();

    int number = 10000 + rand.nextInt(999999);

    JTextField tName, tFName, tAddress, tPhone, tAadhar, tEmail, tSalary, tDesignation;

    JLabel tEmpId;

    JDateChooser tDOB;

    JComboBox boxEducation;

    JButton btnAdd, back;

    AddEmployee() {

        getContentPane().setBackground(new Color(255, 218, 185));

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(name);

        tName = new JTextField();
        tName.setBounds(200, 150, 150, 30);
        tName.setBackground(new Color(230, 230, 250));
        add(tName);

        JLabel fName = new JLabel("Father's Name");
        fName.setBounds(400, 150, 150, 30);
        fName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(fName);

        tFName = new JTextField();
        tFName.setBounds(600, 150, 150, 30);
        tFName.setBackground(new Color(230, 230, 250));
        add(tFName);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400, 200, 150, 30);
        dob.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(dob);

        tDOB = new JDateChooser();
        tDOB.setMaxSelectableDate(new java.util.Date());
        tDOB.setBounds(600, 200, 150, 30);
        tDOB.setBackground(new Color(230, 230, 250));
        add(tDOB);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 350, 150, 30);
        salary.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(salary);

        tSalary = new JTextField();
        tSalary.setBounds(600, 350, 150, 30);
        tSalary.setBackground(new Color(230, 230, 250));
        add(tSalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        tAddress = new JTextField();
        tAddress.setBounds(200, 250, 150, 30);
        tAddress.setBackground(new Color(230, 230, 250));
        add(tAddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tPhone = new JTextField();
        tPhone.setBounds(600, 250, 150, 30);
        tPhone.setBackground(new Color(230, 230, 250));
        add(tPhone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        tEmail = new JTextField();
        tEmail.setBounds(200, 300, 150, 30);
        tEmail.setBackground(new Color(230, 230, 250));
        add(tEmail);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(50, 200, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhar);

        tAadhar = new JTextField();
        tAadhar.setBounds(200, 200, 150, 30);
        tAadhar.setBackground(new Color(230, 230, 250));
        add(tAadhar);

        JLabel education = new JLabel("Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        String courses[] = {"Select", "BBA", "BTech", "BCA", "BA", "BSC", "BCom", "MBA", "MCA", "MA", "MTech", "MSC", "PhD"};
        boxEducation = new JComboBox(courses);
        boxEducation.setBackground(new Color(230, 230, 250));
        boxEducation.setBounds(600, 300, 150, 30);
        add(boxEducation);

        JLabel empId = new JLabel("EmpId");
        empId.setBounds(50, 400, 150, 30);
        empId.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empId);

        tEmpId = new JLabel("" + number);
        tEmpId.setBounds(200, 400, 150, 30);
        tEmpId.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tEmpId.setForeground(Color.RED);
        add(tEmpId);

        JLabel degisnation = new JLabel("Designation");
        degisnation.setBounds(50, 350, 150, 30);
        degisnation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(degisnation);

        tDesignation = new JTextField();
        tDesignation.setBounds(200, 350, 150, 30);
        tDesignation.setBackground(new Color(230, 230, 250));
        add(tDesignation);

        btnAdd = new JButton("ADD");
        btnAdd.setBounds(450, 550, 150, 40);
        btnAdd.setBackground(Color.black);
        btnAdd.setForeground(Color.white);
        btnAdd.setOpaque(true);
        btnAdd.setBorderPainted(false);
        btnAdd.setContentAreaFilled(true);
        btnAdd.setFocusPainted(false);
        btnAdd.addActionListener(this);
        add(btnAdd);

        back = new JButton("BACK");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setContentAreaFilled(true);
        back.setFocusPainted(false);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(270, 110);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String name = tName.getText();
            String fName = tFName.getText();
            String dob = ((JTextField) tDOB.getDateEditor().getUiComponent()).getText();
            String salary = tSalary.getText();
            String address = tAddress.getText();
            String phone = tPhone.getText();
            String email = tEmail.getText();
            String education = (String) boxEducation.getSelectedItem();
            String designation = tDesignation.getText();
            String empId = tEmpId.getText();
            String aadhar = tAadhar.getText();

            if (name.isEmpty() || fName.isEmpty() || dob.isEmpty() || phone.isEmpty() || email.isEmpty() || aadhar.isEmpty() || salary.isEmpty() || address.isEmpty() || education.isEmpty() || designation.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all fields first");
                return;
            }

            if (!phone.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(null, "Phone number must be 10 digits");
                return;
            }

            if (!aadhar.matches("\\d{12}")) {
                JOptionPane.showMessageDialog(null, "Aadhar number must be 12 digits");
                return;
            }

            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                JOptionPane.showMessageDialog(null, "Enter a valid email address");
                return;
            }

            if (education.equals("Select")) {
                JOptionPane.showMessageDialog(null, "Please select an education qualification");
            }

            try {
                Conn c = new Conn();
                String query = "insert into employees values('" + name + "', '" + fName + "', '" + dob + "', '" + salary + "', '" + address + "', '" + phone + "', '" + email + "', '" + education + "', '" + designation + "', '" + aadhar + "', '" + empId + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added Successfully");
                setVisible(false);
                new Main_Class();

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
            new Main_Class();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
