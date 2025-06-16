package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame {

    Main_Class() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1120, 630);
        add(img);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(330, 155, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        img.add(heading);

        JButton add = new JButton("Add Employee");
        add.setBounds(335, 270, 150, 40);
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setOpaque(true);
        add.setBorderPainted(false);
        add.setContentAreaFilled(true);
        add.setFocusPainted(false);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
            }
        });
        img.add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(565, 270, 150, 40);
        view.setForeground(Color.white);
        view.setBackground(Color.black);
        view.setOpaque(true);
        view.setBorderPainted(false);
        view.setContentAreaFilled(true);
        view.setFocusPainted(false);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEmployee();
                setVisible(false);
            }
        });
        img.add(view);

        JButton rem = new JButton("Remove Employee");
        rem.setBounds(420, 370, 170, 40);
        rem.setForeground(Color.white);
        rem.setBackground(Color.black);
        rem.setOpaque(true);
        rem.setBorderPainted(false);
        rem.setContentAreaFilled(true);
        rem.setFocusPainted(false);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();
            }
        });
        img.add(rem);

        JButton quit = new JButton("Quit");
        quit.setBounds(950, 520, 100, 40);
        quit.setForeground(Color.white);
        quit.setBackground(Color.getHSBColor(135, 206, 235));
        quit.setOpaque(true);
        quit.setBorderPainted(false);
        quit.setContentAreaFilled(true);
        quit.setFocusPainted(false);
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        img.add(quit);

        setSize(1120, 630);
        setLocation(170, 140);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_Class();
    }
}
