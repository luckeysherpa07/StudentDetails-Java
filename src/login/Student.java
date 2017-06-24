package login;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucke
 */
public class Student {
    private String stuName;
    private int stuYear;
//    private ArrayList stuName = new ArrayList();
//    private ArrayList stuYear = new ArrayList();
    private ArrayList<String> subject = new ArrayList<String>();
    private String allSub = new String();
    
    
        
    public Student( String name, int year)
    {
//        stuName.add(name);
//        stuYear.add(year);
        stuName = name;
        stuYear = year;
        subject.add("English");
        subject.add("Maths B");
        subject.add("Religion and Ethics");
        subject.add("Biology");
        subject.add("Business and Communication Technologies");
        
    }
        
    public String getName(){
       return this.stuName;
    }
    
    public int getYear(){
        return this.stuYear;
    }
    
    public ArrayList<String> getSub(){
//           for(String sub: subject){
//               allSub = allSub +", " + sub;
//           }
//        return allSub;
        return subject;
    }
    
    public void createStudent(){
        DatabaseUtility stuData = new DatabaseUtility();
        stuData.createData(this.stuName,this.stuYear);
        //System.out.println(stuData.getData());
        
        
    }
}
