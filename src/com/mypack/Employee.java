package com.mypack;

import org.jetbrains.annotations.Contract;
import org.junit.Before;
import org.junit.Test;

public class Employee {

    private int empid;
    private  String country;
    private String gender;
    private int income;


    public Employee(int empid, String country, String gender, int income)
    {
        super();
        this.empid=empid;
        this.country=country;
        this.gender=gender;
        this.income=income;

    }

    @Override

    public String toString() {

        return "empid: "+ this.empid +" | country: "+ this.country +" | gender: "+this.gender+"| income:"+this.income;
    }

    public  int getEmpid(){return empid;}
    public void setEmpid(int empid){this.empid=empid;}

    public  String getCountry(){return  country;}
    public void setCountryt(String country){this.country=country;}

    public  String getGender(){return gender;}
    public void setGender(String gender){this.gender=gender;}

    public  int getIncome(){return income;}
    public void setIncome(int income){this.income=income;}
}
