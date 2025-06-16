package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {

    Choice choiceEmpId;

    JTable table;

    JButton searchBtn, print, update, back;

    ViewEmployee() {

        getContentPane().setBackground(new Color(255, 131, 122));
        JLabel search = new JLabel("Search by employee id");
        search.setBounds(20, 25, 150, 20);
        add(search);

        choiceEmpId = new Choice();
        choiceEmpId.setBounds(180, 25, 150, 20);
        add(choiceEmpId);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employees");
            choiceEmpId.add("Select");
            while (resultSet.next()) {
                choiceEmpId.add(resultSet.getString("empID"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employees");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 100, 900, 600);
        add(jp);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(20, 70, 80, 20);
        searchBtn.addActionListener(this);
        add(searchBtn);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(270, 110);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchBtn) {
            if (choiceEmpId.getSelectedItem().equals("Select")) {
                JOptionPane.showMessageDialog(null, "Please select an Employee ID");
                return;
            }
            String query = "select * from employees where empID = '" + choiceEmpId.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                boolean complete = table.print();
                if (complete) {
                    JOptionPane.showMessageDialog(this, "Printed Successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Printing Cancelled");
                }
            } catch (Exception E) {
                JOptionPane.showMessageDialog(this, "Printing Failed: " + E.getMessage());
                E.printStackTrace();
            }
        } else if (e.getSource() == update) {
            if (choiceEmpId.getSelectedItem().equals("Select")) {
                JOptionPane.showMessageDialog(null, "Please select an Employee ID to update");
                return;
            }
            setVisible(false);
            new UpdateEmployee(choiceEmpId.getSelectedItem());
        } else {
            setVisible(false);
            new Main_Class();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
