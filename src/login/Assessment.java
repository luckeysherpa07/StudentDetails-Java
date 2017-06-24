/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucke
 */
public class Assessment {
    
    String sub;
    String asseID;
    String type;
    String topic;
    String format;
    String dueDate;
    String grade;
    ArrayList<String> asseDetail = new ArrayList<>();
    ArrayList<String> displayRecord = new ArrayList<>();
        
    
    public Assessment(){
    }
    
    public List<String> asseAssign(String loadSub, String loadID, String loadType, String loadTopic, String loadFormat, String loadDueDate){
        
        asseDetail.add(loadSub);
        asseDetail.add(loadID);
        asseDetail.add(loadType);
        asseDetail.add(loadTopic);
        asseDetail.add(loadFormat);
        asseDetail.add(loadDueDate);
        grade ="false";
        asseDetail.add(grade);
        
        return asseDetail;
    }
    
    public List<String> displayAsse(String loadName, int stuYear, String loadID, String loadType, String loadTopic, String loadFormat, String loadDueDate){
        
        asseDetail.add(loadID);
        asseDetail.add(loadType);
        asseDetail.add(loadTopic);
        asseDetail.add(loadFormat);
        asseDetail.add(loadDueDate);
        DatabaseUtility check = new DatabaseUtility();
        //System.out.println(check.checkGrade(loadName,stuYear));
        grade =check.checkGrade(loadName,stuYear);
        asseDetail.add(grade);
        
        return asseDetail;
    }
    
    public List<String> displayRecord(String name, String year, String grade, String skill, String knowledge){
        
        displayRecord.add(name);
        displayRecord.add(year);
        displayRecord.add(grade);
        displayRecord.add(skill);
        displayRecord.add(knowledge);
        
        return displayRecord;
    }
}
