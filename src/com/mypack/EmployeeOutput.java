package com.mypack;

public class EmployeeOutput {
    private String country;
    private String gender;
    private double averageIncome;

    public EmployeeOutput(String country, String gender, double averageIncome) {
        super();
        this.country = country;
        this.gender = gender;
        this.averageIncome = averageIncome;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getAverageIncome() {
        return averageIncome;
    }

    public void setAverageIncome(double averageIncome) {
        this.averageIncome = averageIncome;
    }

    @Override
    public String toString() {
        return "EmployeeOutput [country=" + country + ", gender=" + gender + ", averageIncome=" + averageIncome + "]";
    }

}
