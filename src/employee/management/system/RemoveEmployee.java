package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice choiceEmpID;

    JButton delete, back;

    RemoveEmployee() {

        JLabel label = new JLabel("Employee ID");
        label.setBounds(50, 50, 150, 30);
        label.setFont(new Font("THOMA", Font.BOLD, 20));
        add(label);

        choiceEmpID = new Choice();
        choiceEmpID.setBounds(210, 50, 150, 30);
        add(choiceEmpID);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employees");
            choiceEmpID.add("Select");
            while (resultSet.next()) {
                choiceEmpID.add(resultSet.getString("empID"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50, 100, 100, 30);
        labelName.setFont(new Font("THOMA", Font.BOLD, 18));
        add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(200, 100, 100, 30);
        add(textName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(50, 150, 100, 30);
        labelPhone.setFont(new Font("THOMA", Font.BOLD, 18));
        add(labelPhone);

        JLabel textPhone = new JLabel();
        textPhone.setBounds(200, 150, 100, 30);
        add(textPhone);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(50, 200, 100, 30);
        labelEmail.setFont(new Font("THOMA", Font.BOLD, 18));
        add(labelEmail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(200, 200, 100, 30);
        add(textEmail);


        try {
            Conn c = new Conn();
            ;
            ResultSet resultSet = c.statement.executeQuery("select * from employees where empID = '" + choiceEmpID.getSelectedItem() + "' ");
            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText((resultSet.getString("eMail")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        choiceEmpID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from employees where empID = '" + choiceEmpID.getSelectedItem() + "' ");
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText((resultSet.getString("eMail")));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        delete = new JButton("DELETE");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.setOpaque(true);
        delete.setBorderPainted(false);
        delete.setContentAreaFilled(true);
        delete.setFocusPainted(false);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("BACK");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setContentAreaFilled(true);
        back.setFocusPainted(false);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700, 80, 200, 200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        setSize(1000, 400);

        setLocation(250, 200);

        setLayout(null);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            if (choiceEmpID.getSelectedItem().equals("Select")) {
                JOptionPane.showMessageDialog(null, "Please select a valid Employee ID to delete.");
                return;
            }
            try {
                Conn c = new Conn();
                String query = "delete from employees where empID = '" + choiceEmpID.getSelectedItem() + "' ";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Details Deleted Successfully");
                setVisible(false);
                new Main_Class();

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
