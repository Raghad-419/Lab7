package com.example.lms.Service;

import com.example.lms.Model.Administrator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

@Service
public class AdministratorService {
    ArrayList<Administrator> administrators = new ArrayList<>();

    public ArrayList<Administrator> getAdministrators() {
        return administrators;
    }

    public void addAdministrator(Administrator administrator) {
        administrators.add(administrator);
    }

    public boolean updateAdministrator(String id, Administrator administrator) {
        for (Administrator admin : administrators) {
            if (admin.getID().equals(id)) {
                administrators.set(administrators.indexOf(admin), administrator);
                return true;
            }
        }
        return false;
    }

    public boolean deleteAdministrator(String id) {
        for (Administrator admin : administrators) {
            if (admin.getID().equals(id)) {
                administrators.remove(administrators.indexOf(admin));
                return true;
            }
        }
        return false;
    }

    //Deactivate an Administrator
    public boolean Deactivate(String id) {
        for (Administrator admin : administrators) {
            if (admin.getID().equals(id)) {
                admin.setActive(false);
                return true;
            }
        }
        return false;
    }


    //Get Administrators Hired After a Specific Date

    public ArrayList<Administrator> hiredAfter(LocalDate localDate){
        ArrayList<Administrator> hiredAfterArray =new ArrayList<>();
        for (Administrator admin: administrators) {
            if(admin.getHireDate().isAfter(localDate)){
                hiredAfterArray.add(admin);
            }
        }
        if(hiredAfterArray.isEmpty())
        return null;
        else return hiredAfterArray;
    }


    //Calculate Years of Service
    public int yearsOfService(String id){
        for(Administrator admin: administrators){
            if(admin.getID().equals(id)){
              return   Period.between(admin.getHireDate(),LocalDate.now()).getYears();
            }
        }
        return 0;
    }



}