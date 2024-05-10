package Employee.Registration;





import javax.swing.*; // Importing the Swing library
import java.awt.*; // Importing the AWT library
import java.awt.event.ActionEvent; // Importing ActionEvent class from the event package
import java.awt.event.ActionListener; // Importing ActionListener interface from the event package
import java.sql.ResultSet; // Importing ResultSet class from the sql package
import java.util.Date; // Importing Date class from the java.util package

public class NEW_EMPLOYEE extends JFrame implements ActionListener { // Class declaration, extending JFrame and implementing ActionListener
    JComboBox comboBox; // Declaration of a JComboBox variable
    JTextField textFieldNumber, textName, textFieldAge, textFieldmail , textFieldDepartment; // Declaration of JTextField variables
    JRadioButton r1, r2; // Declaration of JRadioButton variables
    Choice c1; // Declaration of Choice variable
    JLabel date; // Declaration of JLabel variable
    JButton b1 ,b2; // Declaration of JButton variables

    NEW_EMPLOYEE(){ // Constructor definition

        JPanel panel = new JPanel(); // Creating a new JPanel
        panel.setBounds(5,5,840,540); // Setting bounds for the panel
        panel.setBackground(new Color(90, 156, 163)); // Setting background color for the panel
        panel.setLayout(null); // Setting layout for the panel as null
        add(panel); // Adding the panel to the frame

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png")); // Creating an ImageIcon object
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT); // Getting and scaling the image
        ImageIcon imageIcon1 = new ImageIcon(image); // Creating a new ImageIcon object with the scaled image
        JLabel label = new JLabel(imageIcon1); // Creating a new JLabel with the image
        label.setBounds(550,150,200,200); // Setting bounds for the label
        panel.add(label); // Adding the label to the panel

        JLabel labelName = new JLabel("NEW EMPLOYEE FORM"); // Creating a new JLabel
        labelName.setBounds(118,11,260,53); // Setting bounds for the label
        labelName.setFont(new Font("Tahoma",Font.BOLD,20)); // Setting font for the label
        panel.add(labelName); // Adding the label to the panel

        JLabel labelID = new JLabel("ID :"); // Creating a new JLabel
        labelID.setBounds(35,76,200,14); // Setting bounds for the label
        labelID.setFont(new Font("Tahoma",Font.BOLD,14)); // Setting font for the label
        labelID.setForeground(Color.white); // Setting foreground color for the label
        panel.add(labelID); // Adding the label to the panel

        comboBox = new JComboBox(new String[] {"Aadhar Card","Voter Id","Driving License"}); // Creating a new JComboBox
        comboBox.setBounds(271,73,150,20); // Setting bounds for the combo box
        comboBox.setBackground(new Color(3,45,48)); // Setting background color for the combo box
        comboBox.setForeground(Color.white); // Setting foreground color for the combo box
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14)); // Setting font for the combo box
        panel.add(comboBox); // Adding the combo box to the panel

        JLabel labelNumber = new JLabel("Number :"); // Creating a new JLabel
        labelNumber.setBounds(35,111,200,14); // Setting bounds for the label
        labelNumber.setFont(new Font("Tahoma",Font.BOLD,14)); // Setting font for the label
        labelNumber.setForeground(Color.white); // Setting foreground color for the label
        panel.add(labelNumber); // Adding the label to the panel

        textFieldNumber = new JTextField(); // Creating a new JTextField
        textFieldNumber.setBounds(271,111,150,20); // Setting bounds for the text field
        panel.add(textFieldNumber); // Adding the text field to the panel

        JLabel labelName1 = new JLabel("Name :"); // Creating a new JLabel
        labelName1.setBounds(35,151,200,14); // Setting bounds for the label
        labelName1.setFont(new Font("Tahoma",Font.BOLD,14)); // Setting font for the label
        labelName1.setForeground(Color.white); // Setting foreground color for the label
        panel.add(labelName1); // Adding the label to the panel

        textName = new JTextField(); // Creating a new JTextField
        textName.setBounds(271,151,150,20); // Setting bounds for the text field
        panel.add(textName); // Adding the text field to the panel

        JLabel labelGender = new JLabel("Gender :"); // Creating a new JLabel
        labelGender.setBounds(35,191,200,14); // Setting bounds for the label
        labelGender.setFont(new Font("Tahoma",Font.BOLD,14)); // Setting font for the label
        labelGender.setForeground(Color.white); // Setting foreground color for the label
        panel.add(labelGender); // Adding the label to the panel

        r1 = new JRadioButton("Male"); // Creating a new JRadioButton
        r1.setFont(new Font("Tahoma",Font.BOLD,14)); // Setting font for the radio button
        r1.setForeground(Color.white); // Setting foreground color for the radio button
        r1.setBackground(new Color(109, 164, 170)); // Setting background color for the radio button
        r1.setBounds(271,191,80,15); // Setting bounds for the radio button
        panel.add(r1); // Adding the radio button to the panel

        r2 = new JRadioButton("Female"); // Creating a new JRadioButton
        r2.setFont(new Font("Tahoma",Font.BOLD,14)); // Setting font for the radio button
        r2.setForeground(Color.white); // Setting foreground color for the radio button
        r2.setBackground(new Color(109, 164, 170)); // Setting background color for the radio button
        r2.setBounds(350,191,80,15); // Setting bounds for the radio button
        panel.add(r2); // Adding the radio button to the panel

        JLabel labelAge = new JLabel("Age :"); // Creating a new JLabel
        labelAge.setBounds(35,231,200,14); // Setting bounds for the label
        labelAge.setFont(new Font("Tahoma",Font.BOLD,14)); // Setting font for the label
        labelAge.setForeground(Color.white); // Setting foreground color for the label
        panel.add(labelAge); // Adding the label to the panel

        textFieldAge = new JTextField(); // Creating a new JTextField
        textFieldAge.setBounds(271,231,150,20); // Setting bounds for the text field
        panel.add(textFieldAge); // Adding the text field to the panel

        JLabel labelmail = new JLabel("Email :"); // Creating a new JLabel
        labelmail.setBounds(35,274,200,14); // Setting bounds for the label
        labelmail.setFont(new Font("Tahoma",Font.BOLD,14)); // Setting font for the label
        labelmail.setForeground(Color.white); // Setting foreground color for the label
        panel.add(labelmail); // Adding the label to the panel

        textFieldmail = new JTextField(); // Creating a new JTextField
        textFieldmail.setBounds(271,274,150,20); // Setting bounds for the text field
        panel.add(textFieldmail); // Adding the text field to the panel

        JLabel department = new JLabel("Department :"); // Creating a new JLabel
        department.setBounds(35,317,200,14); // Setting bounds for the label
        department.setFont(new Font("Tahoma",Font.BOLD,14)); // Setting font for the label
        department.setForeground(Color.white); // Setting foreground color for the label
        panel.add(department); // Adding the label to the panel

        textFieldDepartment= new JTextField(); // Creating a new JTextField
        textFieldDepartment.setBounds(271,317,150,20); // Setting bounds for the text field
        panel.add(textFieldDepartment); // Adding the text field to the panel








        b1 = new JButton("ADD"); // Creating a new JButton
        b1.setBounds(100,430,120,30); // Setting bounds for the button
        b1.setForeground(Color.black); // Setting foreground color for the button
        b1.setBackground(Color.YELLOW); // Setting background color for the button
        b1.addActionListener(this); // Adding action listener to the button
        panel.add(b1); // Adding the button to the panel

        b2 = new JButton("Back"); // Creating a new JButton
        b2.setBounds(260,430,120,30); // Setting bounds for the button
        b2.setForeground(Color.BLACK); // Setting foreground color for the button
        b2.setBackground(Color.yellow); // Setting background color for the button
        b2.addActionListener(this); // Adding action listener to the button
        panel.add(b2); // Adding the button to the panel

        setUndecorated(true); // Setting the frame undecorated
        setSize(850,550); // Setting size for the frame
        setLayout(null); // Setting layout for the frame as null
        setLocation(300,250); // Setting location for the frame
        setVisible(true); // Setting the frame visible

    }

    @Override
    public void actionPerformed(ActionEvent e) { // Overriding actionPerformed method
        if (e.getSource() == b1){ // Checking if the source of the event is button b1
            Conn c = new Conn(); // Creating a new Conn object
            String radioBTN = null; // Initializing radioBTN variable
            if (r1.isSelected()){ // Checking if radio button r1 is selected
                radioBTN = "Male"; // Setting radioBTN to "Male"
            }else if (r2.isSelected()){ // Checking if radio button r2 is selected
                radioBTN = "Female"; // Setting radioBTN to "Female"
            }
            String s1 = (String)comboBox.getSelectedItem(); // Getting selected item from the combo box
            String s2 =  textFieldNumber.getText(); // Getting text from the text field
            String s3 =  textName.getText(); // Getting text from the text field
            String s4 =  radioBTN; // Getting text from the radio button
            String s5 =  textFieldAge.getText(); // Getting text from the text field
            String s6 =  textFieldmail.getText(); // getting mail
            String s7 =  textFieldDepartment.getText(); // Getting text from the label


            try { // Try block to handle exceptions

                String q ="insert into EMP_INFO values ('"+s1+"', '"+s2+"','"+s3+"','"+s4+"', '"+s5+"', '"+s6+"', '"+s7+"')"; // Creating a query

                c.statement.executeUpdate(q); // Executing the query

                JOptionPane.showMessageDialog(null, "added Successfully"); // Displaying a message dialog
                setVisible(false); // Setting the frame invisible

            }catch (Exception E) { // Catch block to handle exceptions
                E.printStackTrace(); // Printing the stack trace
            }
        }else { // If the source of the event is not button b1
            setVisible(false); // Setting the frame invisible
        }
    }

    public static void main(String[] args) { // Main method
        new NEW_EMPLOYEE(); // Creating an instance of the class
    }
}

