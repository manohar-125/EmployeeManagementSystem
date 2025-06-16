package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tName, tFName, tAddress, tPhone, tAadhar, tEmail, tEducation, tSalary, tDesignation;

    JLabel tEmpId;

    JButton btnAdd, back;

    String number;

    UpdateEmployee(String number) {

        this.number = number;

        getContentPane().setBackground(new Color(255, 218, 185));

        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(280, 50, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(name);

        JLabel tName = new JLabel();
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
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(dob);

        JLabel tDOB = new JLabel();
        tDOB.setBounds(200, 200, 150, 30);
        tDOB.setFont(new Font("THOMA", Font.BOLD, 18));
        add(tDOB);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(salary);

        tSalary = new JTextField();
        tSalary.setBounds(600, 200, 150, 30);
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
        email.setBounds(400, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        tEmail = new JTextField();
        tEmail.setBounds(600, 300, 150, 30);
        tEmail.setBackground(new Color(230, 230, 250));
        add(tEmail);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(50, 300, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhar);

        JLabel tAadhar = new JLabel();
        tAadhar.setBounds(200, 300, 150, 30);
        tAadhar.setBackground(new Color(230, 230, 250));
        add(tAadhar);

        JLabel education = new JLabel("Education");
        education.setBounds(50, 350, 150, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        tEducation = new JTextField();
        tEducation.setBounds(200, 350, 150, 30);
        tEducation.setBackground(new Color(230, 230, 250));
        add(tEducation);

        JLabel empId = new JLabel("EmpId");
        empId.setBounds(50, 400, 150, 30);
        empId.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empId);

        tEmpId = new JLabel();
        tEmpId.setBounds(200, 400, 150, 30);
        tEmpId.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tEmpId.setForeground(Color.RED);
        add(tEmpId);

        JLabel degisnation = new JLabel("Designation");
        degisnation.setBounds(400, 350, 150, 30);
        degisnation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(degisnation);

        tDesignation = new JTextField();
        tDesignation.setBounds(600, 350, 150, 30);
        tDesignation.setBackground(new Color(230, 230, 250));
        add(tDesignation);

        try {
            Conn c = new Conn();
            String query = "select * from employees where empID = '" + number + "' ";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                tName.setText(resultSet.getString("name"));
                tFName.setText(resultSet.getString("fName"));
                tDOB.setText(resultSet.getString("dob"));
                tAddress.setText(resultSet.getString("address"));
                tSalary.setText((resultSet.getString("salary")));
                tPhone.setText(resultSet.getString("phone"));
                tEmail.setText(resultSet.getString("email"));
                tEducation.setText(resultSet.getString("education"));
                tAadhar.setText(resultSet.getString("aadhar"));
                tEmpId.setText(resultSet.getString("empID"));
                tDesignation.setText(resultSet.getString("designation"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        btnAdd = new JButton("UPDATE");
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
            String fName = tFName.getText();
            String salary = tSalary.getText();
            String address = tAddress.getText();
            String phone = tPhone.getText();
            String email = tEmail.getText();
            String education = tEducation.getText();
            String designation = tDesignation.getText();

            try {
                Conn c = new Conn();
                String query = "update employees set fName = '" + fName + "', salary = '" + salary + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "', education = '" + education + "', designation = '" + designation + "' where empID = '" + number + "' ";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
                new Main_Class();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
