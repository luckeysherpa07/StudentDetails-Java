/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Subject {
    
    private List<List<String>> assessment = new ArrayList<>();
    LinkedHashSet<String> subHash = new LinkedHashSet();
    LinkedHashSet<String> asseHash = new LinkedHashSet();
    

    public void create(ArrayList<String> allSub){
        
        LinkedHashSet subHash = new LinkedHashSet();
        LinkedHashSet asseHash = new LinkedHashSet();
        
        //Code for retriving data from DataFile
        
        String fileName = "data.csv";
        File file = new File(fileName);
        
        try {
            
            for(String sub: allSub){
                
                List<String> asseDetail = new ArrayList();
                Scanner inputStream = new Scanner(file);
                
                while(inputStream.hasNext()){
                    
                    String data = inputStream.nextLine();
                    String[] values = data.split(",");

                    if(sub.equals(values[0])){
                       
                        //Creating object of 'Assessment' to get assessment details
                        Assessment asseObj = new Assessment();
                        asseDetail = asseObj.asseAssign(values[0], values[1], values[2], values[3], values[4], values[5]);

                        assessment.add(asseDetail);

                        subHash.add(values[0]);
                        asseHash.add(values[1] + ";" + values[2] + ";" + values[3]);
                       
                    }
                }
                inputStream.close();
            }
            
                    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Subject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.subHash = subHash;
        this.asseHash = asseHash;
        
    }
    
    public List<List<String>> displayAsse(String stuName, String sub,int stuYear){
        
        List<List<String>> displayAsse = new ArrayList<>();
                
        LinkedHashSet subHash = new LinkedHashSet();
        LinkedHashSet asseHash = new LinkedHashSet();
        
        String fileName = "data.csv";
        File file = new File(fileName);
        
        try {
            
            List<String> asseDetail = new ArrayList();
            Scanner inputStream = new Scanner(file);
            while(inputStream.hasNext()){
                String data = inputStream.nextLine();
                String[] values = data.split(",");
        
                if(sub.equals(values[0])){

                   Assessment asseObj = new Assessment();
                   asseDetail = asseObj.displayAsse(stuName, stuYear, values[1], values[2], values[3], values[3], values[5]);
                   
                   displayAsse.add(asseDetail);
                }
            }
            inputStream.close(); 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Subject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return displayAsse;
        
    }
    
       
    public LinkedHashSet<String> getSubHash(){
        return subHash;
    }
    public LinkedHashSet<String> getAsseHash(){
        return asseHash;
    }
    
}
