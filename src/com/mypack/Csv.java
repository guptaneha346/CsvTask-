package com.mypack;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Csv {

    public static void main(String args[])
    {
        Pattern pattern = Pattern.compile(",");
        try (BufferedReader in = new BufferedReader(new FileReader("/home/neha.gupta/Desktop/file.csv"));){
            List<Employee> empList = in
                    .lines()
                    .skip(1)
                    .map(line -> {
                        String[] arr = pattern.split(line);
                        return new Employee(Integer.parseInt(arr[0]),
                                arr[1],
                                arr[2],

                                Integer.parseInt(arr[3]));
                    })
                    .collect(Collectors.toList());
            List<EmployeeOutput> response;
            response=null;
            Map<String,Map<String, Double>> result =empList .stream()
                    .collect(Collectors
                            .groupingBy(Employee::getCountry, Collectors
                                    .groupingBy(Employee::getGender, Collectors
                                            .averagingInt(Employee::getIncome))));

            response = result.entrySet().stream()
                    .flatMap(sport -> sport.getValue().entrySet().stream()
                            .map(gender -> new EmployeeOutput(sport.getKey(), gender.getKey(), gender.getValue())))
                    .collect(Collectors.toList());
            System.out.println("The output response: ");
            System.out.println(response);

                System.out.println();




            try {
                String headerRow = "counrty, gender, average income";
                String csvSplitBy = ",";
                String encoding = "UTF-8";
                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream("/home/neha.gupta/Desktop/output.csv"), encoding));
                try {
                    bw.write(headerRow);
                    bw.newLine();
                } catch (IOException e1) {
                    System.out.println("while writing header row and new line..." + e1);
                }
                for (EmployeeOutput employee : response) {
                    StringBuffer oneLine = new StringBuffer();
                    oneLine.append(employee.getCountry());
                    oneLine.append(csvSplitBy);
                    oneLine.append(employee.getGender());
                    oneLine.append(csvSplitBy);
                    oneLine.append(employee.getAverageIncome());
                    try {
                        bw.write(oneLine.toString());
                        bw.newLine();
                    } catch (IOException e) {
                        System.out.println("While writing line: " + oneLine);
                    }
                }
                try {
                    bw.flush();
                    bw.close();
                } catch (IOException e) {
                    System.out.println("While flushing and close operation..." + e);
                }
            } catch (UnsupportedEncodingException e) {
                System.out.println("UnsupportedencodingException occured: " + e);
            } catch (FileNotFoundException e1) {
                System.out.println("FileNotFoundException occured: " + e1);
            }

        }

        catch(Exception ee)
        {
            ee.printStackTrace();
        }



    }

}