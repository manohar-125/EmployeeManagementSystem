package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {


    JTextField tusername;

    JPasswordField tpassword;

    JButton login, back;

    Login() {

        JLabel username = new JLabel("Username");
        username.setBounds(40, 30, 100, 30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 30, 150, 30);
        add(tusername);


        JLabel password = new JLabel("Password");
        password.setBounds(40, 80, 100, 30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 80, 150, 30);
        add(tpassword);


        login = new JButton("LOGIN");
        login.setBounds(100, 140, 150, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.setOpaque(true);
        login.setBorderPainted(false);
        login.setContentAreaFilled(true);
        login.addActionListener(this);
        add(login);


        back = new JButton("BACK");
        back.setBounds(100, 190, 150, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setContentAreaFilled(true);
        back.addActionListener(this);
        add(back);


        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(350, 0, 600, 400);
        add(imgg);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 600, 300);
        add(img);


        setSize(600, 300);
        setLocation(400, 270);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                String userName = tusername.getText();
                String password = tpassword.getText();

                Conn conn = new Conn();

                String query = "select * from login where username = '" + userName + "' and password = '" + password + "' ";

                ResultSet resultSet = conn.statement.executeQuery(query);

                if (resultSet.next()) {
                    setVisible(false);
                    new Main_Class();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }

        } else if (e.getSource() == back) {
            System.exit(90);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
