/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author lucke
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class StudyMonitorInterface extends JFrame {
    
    //Variable Decleration for GUI
    
    private JLabel loginText;
    private JTextField loginField1;
    private JLabel loginPassText;
    private JPasswordField loginPass1;
    private JButton loginOk;
    
    private JLabel stuNameText;
    private JTextField studentName;
    private JLabel stuYearText;
    private JFormattedTextField studentYear;
    
    private JLabel subjectText;
    JComboBox<String> subjectCombo = new JComboBox<>();
    private JLabel asseText;
    JComboBox<String> asseCombo = new JComboBox<>();
    private JLabel achieveText;
    JComboBox<String> achieveCombo = new JComboBox<>();
    
    private JTextArea infoBox;
    
    private JButton createStudent;
    private JButton loadAsse;
    private JButton setGrade;
    private JButton save;
    private JButton displayAsse;
    private JButton displayGrade;
    private JButton clearDisplay;
    private JButton exit;
    
    
            //Variable Declaration for assigning different values from the class
    
            private ArrayList<String> allSub;
            private String createSub;
            private String subGrade;
            private String asseGrade;
            private String achieveGrade;
            private String knowledge;
            private String skill;
            
    //Constructor for the StudyMonitorInterface
    
    public StudyMonitorInterface(){
        
        //Adding GUI Component
        
        setLayout(new FlowLayout());
        
        Box box1  = Box.createHorizontalBox();
        Box box2  = Box.createHorizontalBox();
        Box box3  = Box.createHorizontalBox();
        Box box4  = Box.createHorizontalBox();
        Box box5  = Box.createHorizontalBox();
        
        loginText = new JLabel("Admin Name");
        box1.add(loginText);
        loginField1 = new JTextField(30);
        box1.add(loginField1);
        
        loginPassText = new JLabel("Password");
        box1.add(loginPassText);
        loginPass1 = new JPasswordField(30);
        box1.add(loginPass1);
        
        loginOk = new JButton("Login");
        box1.add(loginOk);
        loginOk.addActionListener(new Action());
        
        stuNameText = new JLabel("Student Name");
        box2.add(stuNameText);
        studentName = new JTextField(40);
        box2.add(studentName);
        
        stuYearText = new JLabel("Year");
        box2.add(stuYearText);
        studentYear = new JFormattedTextField(11);
        studentYear.setColumns(15);
        box2.add(studentYear);
        
        subjectText = new JLabel("Subject");
        box3.add(subjectText);
        subjectCombo.addItem("Choose Subject");
        box3.add(subjectCombo);
        
        asseText = new JLabel("Assessment");
        box3.add(asseText);
        asseCombo.addItem("Choose Assessment");
        box3.add(asseCombo);
        
        achieveText = new JLabel("Achievement");
        box3.add(achieveText);
        achieveCombo.addItem("Choose Achievement");
        box3.add(achieveCombo);
        
        infoBox = new JTextArea(20,85);
        box4.add(infoBox);
        
        createStudent = new JButton("Create Student");
        box5.add(createStudent);
        createStudent.setEnabled(false);
        createStudent.addActionListener(new createAction());
        
        loadAsse = new JButton("Load Assessment");
        box5.add(loadAsse);
        loadAsse.setEnabled(false);
        loadAsse.addActionListener(new createLoad());
        
        setGrade = new JButton("Set Grade");
        box5.add(setGrade);
        setGrade.setEnabled(false);
        setGrade.addActionListener(new createSetGrade());
        
        save = new JButton("Save");
        box5.add(save);
        save.setEnabled(false);
        save.addActionListener(new createSave());
        
        displayAsse = new JButton("Display Assessment");
        box5.add(displayAsse);
        displayAsse.setEnabled(false);
        displayAsse.addActionListener(new createDisplayAsse());
        
        
        displayGrade = new JButton("Display Grade");
        box5.add(displayGrade);
        displayGrade.setEnabled(false);
        displayGrade.addActionListener(new createDisplayGrade());
        
        clearDisplay = new JButton("Clear Display");
        box5.add(clearDisplay);
        clearDisplay.setEnabled(true);
        clearDisplay.addActionListener(new createClearDisplay());
        
        exit = new JButton("Exit");
        box5.add(exit);
        exit.setEnabled(true);
        exit.addActionListener(new createExit());
        
        this.add(box1);
        this.add(box2);
        this.add(box3);
        this.add(box4);
        this.add(box5);
    }
    
    //ActionListener for "Login" Button
        
    public class Action implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent evt){
            String user = loginField1.getText();
            String pass = loginPass1.getText();
            
            //Checking username and password
            
            if(user.equals("admin") & pass.equals("admin"))
            {
                createStudent.setEnabled(true);    
            }

        }
    }
        
    //ActionListener for "Create" Button
    
    public class createAction implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent evt){
            
            loadAsse.setEnabled(true); 
            
            String stuName = studentName.getText();
            int stuYear =(int) studentYear.getValue();
            
            Student newStudent = new Student(stuName,stuYear);
            newStudent.createStudent();
            allSub = newStudent.getSub();
            createSub = "Subject:";
            for(String sub: newStudent.getSub()){
                createSub = createSub +", " + sub;
            }
            
            //Displaying the Student, Year and Subjec
            
            infoBox.append("\n\nStudent added to the system." +
                            "\n\n" + "Name: " + newStudent.getName() + ", Year: " + newStudent.getYear() + "\n" +
                            createSub);

        }
    }

    //ActionListener for "Load Assesssment" Button
    
    public class createLoad implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent evt){
            
            //Enabling all the corresponding button after the event is activated
            displayGrade.setEnabled(true);
            displayAsse.setEnabled(true);
            setGrade.setEnabled(true);
            save.setEnabled(true);
            
            
            //Retriving the information of Subject and Assessment
            Subject newSubject = new Subject();
            newSubject.create(allSub);
            
            //Adding item to combo box "Subject"
            for(String s: newSubject.getSubHash()){
                subjectCombo.addItem(s);
            }
            
            //Adding item to combo box "Assessment"
            for(String s: newSubject.getAsseHash()){
                asseCombo.addItem(s);
            }
            
            //Adding item to combo box "Achievemnt"
            achieveCombo.addItem("Very High");
            achieveCombo.addItem("High");
            achieveCombo.addItem("Sound");
            achieveCombo.addItem("Developing");
            achieveCombo.addItem("Emerging");
            
            
        }
    }
    
    //ActionListener for the "Set Grade" Button
    
    public class createSetGrade implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent evt){
            
            //Empty Graded field will be '-' with value
            knowledge = "-";
            skill = "-";
            
            //Get the value from combobox
            subGrade = (String)subjectCombo.getSelectedItem();
            asseGrade = (String)asseCombo.getSelectedItem();
            achieveGrade = (String)achieveCombo.getSelectedItem();
            
            //Put the respective knowledge and skill of the given achievement
            if(achieveGrade.equals("Very High")){
                knowledge = "thorogh understanding";
                skill = "uses of high level of skill in both familiar and new situation";
            }else if (achieveGrade.equals("High")){
                knowledge = "clear understanding";
                skill = "uses a high level of skill in familiar situations, and is beginning to use skills in new situations ";
            }else if (achieveGrade.equals("Sound")){
                knowledge = "understanding";
                skill = "uses skills in situations familiar to them";
            }else if (achieveGrade.equals("Developing")){
                knowledge = "understands aspects of";
                skill = "uses varying levels of skill in situations familiar to them";
            }else if(achieveGrade.equals("Emerging")){
                knowledge = "basic understanding";
                skill = "beginning to use skills in familiar situations ";
            }else {
                
            }
            
            //Info in Textarea
            infoBox.setText("Grade Set to the Student's info");

        }
    }
    
    //ActionListener for the "Save" Button
    
    public class createSave implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent evt){
            
            String stuName = studentName.getText();
            int stuYear = (int) studentYear.getValue();
            
            String subject = subGrade;
            String assessment = asseGrade;
            String achievement = achieveGrade;
            String knowledgeValue = knowledge;
            String skillValue = skill;
            
            //Save the value of Student's name, year ,subject, assessment, achievement, knowledge, skill in database
            DatabaseUtility stuData = new DatabaseUtility();
            stuData.createGrade(stuName, stuYear, subject, assessment, achievement,knowledgeValue,skillValue);
            
            infoBox.setText("Data saved to the database");
            
        }
    }
    
    //ActionListener for "Display Assessment" Button
    
    public class createDisplayAsse implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent evt){
            
            List<List<String>> disAsse = new ArrayList<>();
            
            String stuName = studentName.getText();
            int stuYear = (int) studentYear.getValue();
            String subject = subGrade;
                            
            //Getting value of Assessment from database
            Subject stuData = new Subject();
            disAsse = stuData.displayAsse(stuName, subject, stuYear);
            
            infoBox.setText(subject + "\n\n");
            
            for (List temp : disAsse) {
                for(Object display : temp){
                    infoBox.append(display + ", ");
                }
                infoBox.append(" \n ");
            }
        }
    }
    
    //ActionListener for "Display Grade" Button
    public class createDisplayGrade implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent evt){
            
            List<List<String>> displayAll = new ArrayList<>();
            
            String stuName = studentName.getText();
            int stuYear = (int) studentYear.getValue();
            
            //Getting value of assessment, achievement and skill of particular student
            DatabaseUtility stuData = new DatabaseUtility();
            stuData.displayGrade(stuName, stuYear);
            displayAll = stuData.getAllRecord();
            
            infoBox.setText("\n\n");
            
            for (List temp : displayAll) {
                
                infoBox.append((String)temp.get(0));
                infoBox.append(" \n  ");
                infoBox.append((String)temp.get(1));
                infoBox.append(" \n Achievement:  ");
                infoBox.append((String)temp.get(2));
                infoBox.append(" \n Skill: ");
                infoBox.append((String)temp.get(3));
                infoBox.append(" \n Knowledge: ");
                infoBox.append((String)temp.get(4));
                infoBox.append(" \n \n ");
            }
        }
    }
    
    //ActioinListener for the "Clear Display" button
    public class createClearDisplay implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent evt){
            
            //Clear the textarea
            infoBox.setText("");
            
            //Set Comboboxes to default value
            subjectCombo.removeAllItems();
            subjectCombo.addItem("Choose Subject");
            asseCombo.removeAllItems();
            asseCombo.addItem("Choose Assessment");
            achieveCombo.removeAllItems();
            achieveCombo.addItem("Choose Achievement");
            
            infoBox.append("Display Cleared");
        }
    }
    
    //ActionListener for the "Exit" Button
    
    public class createExit implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent evt){
            
            System.exit(0);
            
        }
    }
    
    /**
     * @param args the command line arguments
     */
        
    public static void main(String[] args) {
        StudyMonitorInterface student = new StudyMonitorInterface();
        student.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        student.setResizable(false);
        student.setSize(1100, 500);
        student.setVisible(true);
        student.setTitle("Assignment Two Application");
    }
    
}
