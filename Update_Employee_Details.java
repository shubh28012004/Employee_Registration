package Employee.Registration;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Employee_Details extends JFrame {

    Update_Employee_Details() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Employee Details");
        label1.setBounds(124, 11, 260, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.white);
        panel.add(label1);


        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25, 88, 100, 14);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248, 85, 140, 25);
        panel.add(choice);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from EMP_INFO");
            while (resultSet.next()) {
                choice.add(resultSet.getString("Name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Number :");
        label3.setBounds(25, 129, 100, 14);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248, 129, 140, 20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("Gender  :");
        label4.setBounds(25, 174, 100, 14);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textFieldINTIme = new JTextField();
        textFieldINTIme.setBounds(248, 174, 140, 20);
        panel.add(textFieldINTIme);

        JLabel label5 = new JLabel("Department :");
        label5.setBounds(25, 216, 150, 14);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248, 216, 140, 20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Mail :");
        label6.setBounds(25, 261, 150, 14);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248, 261, 140, 20);
        panel.add(textFieldPending);

        JButton check = new JButton("CHECK");
        check.setBounds(281, 378, 89, 23);
        check.setBackground(Color.YELLOW);
        check.setForeground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from EMP_INFO where Name = '" + id + "'";
                try {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()) {
                        textFieldR.setText(resultSet.getString("Number"));
                        textFieldINTIme.setText(resultSet.getString("Gender"));
                        textFieldAmount.setText(resultSet.getString("Department"));
                        textFieldPending.setText(resultSet.getString("Mail"));

                    }


                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton update = new JButton("UPDATE");
        update.setBounds(56, 378, 89, 23);
        update.setBackground(Color.YELLOW);
        update.setForeground(Color.BLACK);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    String q = choice.getSelectedItem();
                    String number = textFieldR.getText();
                    String gender = textFieldINTIme.getText();
                    String department = textFieldAmount.getText();
                    String mail = textFieldPending.getText();
                    c.statement.executeUpdate("update EMP_INFO set Number = '" + number + "', Gender = '" + gender + "', Department = '" + department + "', Mail = '" + mail + "' where Name = '" + q + "'");
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(168, 378, 89, 23);
        back.setBackground(Color.YELLOW);
        back.setForeground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(950, 500);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Update_Employee_Details();
    }
}
