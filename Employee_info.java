package Employee.Registration;





import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {
    Employee_info(){
        // Creating a panel to hold the components
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);

        // Creating a table to display employee information
        JTable table = new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(table);

        try{
            // Establishing a database connection
            Conn c = new Conn();
            // Executing a SQL query to retrieve employee information from the EMP_INFO table
            String q = "select * from EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            // Setting the table model with the retrieved data
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            // Printing the stack trace if an exception occurs
            e.printStackTrace();
        }

        // Adding labels for column headers
        JLabel label1 = new JLabel("ID");
        label1.setBounds(41,9,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Number");
        label2.setBounds(180,9,70,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Name");
        label3.setBounds(350,9,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(550,9,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 = new JLabel("Age");
        label5.setBounds(730,9,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6 = new JLabel("Mail");
        label6.setBounds(800,9,150,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JLabel label7 = new JLabel("Department");
        label6.setBounds(870,9,150,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label7);

        // Adding a button to go back
        JButton button = new JButton("BACK");
        button.setBounds(350,500,120,30);
        button.setBackground(Color.YELLOW);
        button.setForeground(Color.BLACK);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1000,600);
        setLocation(350,230);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {

        new Employee_info();
    }
}

