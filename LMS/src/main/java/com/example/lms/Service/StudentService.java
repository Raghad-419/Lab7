package com.example.lms.Service;

import com.example.lms.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students =new ArrayList<>();

    public ArrayList<Student> getStudents(){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public boolean updateStudent(String id, Student student){
        for(Student s : students){
            if(s.getID().equals(id)){
                students.set(students.indexOf(s),student);
                return true;
            }
        }
        return false;
    }


    public boolean deleteStudent(String id){
        for (Student s: students){
            if(s.getID().equals(id)){
                students.remove(students.indexOf(s));
                return true;
            }
        }
        return false;
    }

    //Get All Students with a GPA higher than or equal 4.50
    public ArrayList<Student> getGpa(){
        ArrayList<Student> goodStudent =new ArrayList<>();
        for(Student s:students){
            if(s.getGPA()>=4.50){
            goodStudent.add(s);
            }
        }
        return goodStudent;
    }

    //Calculate avg GPA
    public Double calculateAvg(){
        double sum =0;
        for (Student s:students){
            sum=sum+s.getGPA();
        }
        double avg = sum / students.size();
        return Math.round(avg * 100.0) / 100.0;
    }

//A method to check if a student is eligible for a scholarship based on their GPA.
    public boolean isEligible(String id){
        for(Student s:students){
            if(s.getID().equals(id)){
                if(s.getGPA()>4.75){
                    s.setEligible(true);
                    return true;}
            }
        }
        return false;
    }


}
