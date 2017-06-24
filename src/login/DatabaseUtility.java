/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseUtility {
    private String dName;
    private int dYear;
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
     List<List<String>> displayAll = new ArrayList<>();
    
    public DatabaseUtility(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/coitdatabase","root","");
            st = con.createStatement(); 
            
            
            
        }catch(Exception ex){
            System.out.println("Error");
        }
    }
    
    public void createData(String name,int year){
        try{
            
            //System.out.println(name + " "+ year);
            String query = "INSERT INTO `coitdatabase`.`student` (`studentID`, `studentName`, `yearLevel`) VALUES (NULL, '"+name+"','"+year+"');";
            st.executeUpdate(query);
            
        }catch(Exception ex){
            System.out.println("Error in create name and yaar " + ex);
        }
    }
    
    //Inserting value to 'grade' table
    public void createGrade(String name,int year, String subject, String assessment, String achievement,String knowledge,String skill){
        try{
            String query = "INSERT INTO `coitdatabase`.`grade` (`studentName`, `stuYear`, `subjectName`, `asseName`, `grade`, `knowledge`, `skill`) VALUES ('"+name+"', '"+year+"', '"+subject+"', '"+assessment+"', '"+achievement+"', '"+knowledge+"', '"+skill+"');";
            st.executeUpdate(query);
        }catch(Exception ex){
            System.out.println("Error in create grade "+ ex);
        }
    }
    
    //Retriving value form 'grade' table
    public void displayGrade(String name,int year){
        try{
            
            List<List<String>>displayAll = new ArrayList<>();
            List<String> displayRecord = new ArrayList<>();
            
            //Retriving value form 'grade' table
            System.out.println(name);
            String query = "SELECT * from grade WHERE studentName = '"+ name +"' AND stuYear = '"+year+"'";
            rs = st.executeQuery(query);
            
            while (rs.next()){
                String displaySubject = rs.getString("subjectName");
                String displayYear = rs.getString("asseName");
                String displayGrade = rs.getString("grade");
                String displaySkill = rs.getString("skill");
                String displayKnowledge = rs.getString("knowledge");
                
                Assessment newRecord = new Assessment();
                displayRecord = newRecord.displayRecord(displaySubject, displayYear, displayGrade, displaySkill, displayKnowledge);
                
                displayAll.add(displayRecord);
                
            }
            this.displayAll = displayAll;
            
        }catch(Exception ex){
            System.out.println("Error in display grade "+ ex);
        }
    }
    
    //Retriving value form 'grade' table for assessment
    public String checkGrade(String name,int year){
        
        String checkVar = new String();
        
        try{
            
            //Retriving value form 'grade' table
            String query = "SELECT * from grade WHERE studentName = '"+ name +"' AND stuYear = '"+year+"'";
            rs = st.executeQuery(query);
            
            while (rs.next()){
                
                if(rs.getString("grade").equals("Choose Achievement")){
                    checkVar = "Not Graded";
                }else{
                    checkVar =  "Graded";
                }
            }
        }catch(Exception ex){
            System.out.println("Error in display grade "+ ex);
        }
        
            return checkVar;
    }
    
    public List<List<String>> getAllRecord(){
        return displayAll;
    }
    
    //Get value of the Student name form 'student' table
    public String getData(){
        try{
            
            String query = "SELECT * from student";
            rs = st.executeQuery(query);
            rs.next();
            String name = rs.getString("studentName");
            return dName =  name;
                        
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
        
    }  
}
