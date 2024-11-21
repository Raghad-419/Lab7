package com.example.lms.Service;

import com.example.lms.Model.Faculty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FacultyService {

    ArrayList<Faculty> faculties=new ArrayList<>();

    public ArrayList<Faculty> getFaculties(){
        return faculties;
    }

    public void addFaculty(Faculty faculty){
        faculties.add(faculty);
    }

    public boolean updateFaculty(String id,Faculty faculty){
        for(Faculty f: faculties){
            if(f.getID().equals(id)){
                faculties.set(faculties.indexOf(f),faculty);
                return true;
            }
        }
        return false;
    }

    public boolean deleteFaculty(String id){
        for (Faculty f: faculties){
            if(f.getID().equals(id)){
                faculties.remove(faculties.indexOf(f));
                return true;
            }
        }
        return false;
    }

   public boolean promotion(String id_super ,String id_sub){

       for(Faculty professor: faculties){
           if(professor.getID().equals(id_super)){
               if(professor.getPosition().equals("Professor")){

               for(Faculty f: faculties){
                 if(f.getID().equals(id_sub)){
                     if(f.getPosition().equals("Assistant")){
                         f.setPosition("Lecturer");
                          f.setSalary(f.getSalary()+2000);
                          return true;}
                   else if (f.getPosition().equals("Lecturer")){
                       f.setPosition("Professor");
                       f.setSalary(f.getSalary()+2000);
                       return true;
               }
           }
           }
               }
           }
       }
       return false;
   }


   //Calculates the average salary of all faculty members.
    public Double getAvgSalary(){
        double sum =0;
        for(Faculty f: faculties){
            sum=sum+f.getSalary();
        }
        double avg = sum / faculties.size();
        return Math.round(avg * 100.0) / 100.0;
    }

    //Update Faculty Salary by Percentage
    public boolean updateSalary(String id,double percent){
        for(Faculty f:faculties){
            if(f.getID().equals(id)){
                double currentSalary =f.getSalary();
                double newSalary=currentSalary+(currentSalary * (percent / 100));
                f.setSalary(newSalary);
                return true;
            }
        }
        return false;
    }

}
