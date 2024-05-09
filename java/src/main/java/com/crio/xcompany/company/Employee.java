package com.crio.xcompany.company;

import java.util.ArrayList;
import java.util.List;



public class Employee {
    private String name;
    private Gender gender;
    private Employee manager;
    private List<Employee> directReports = new ArrayList<Employee>();

    public Employee(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    // TODO: CRIO_TASK_MODULE_XCOMPANY
    // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone before implementing the logic.
    // This will ensure that the project can be compiled successfully.
    public void assignManager(Employee manager) {
        this.manager = manager;
    }

    public void addDirectReport(Employee employee) {
        this.directReports.add(employee);
    }

    public List<Employee> getDirectReports() {
        return this.directReports;
    }

    public Employee getManager() {
        return this.manager;
    }

    public List<Employee> getTeamMates() {
        ArrayList<Employee> teamMates = new ArrayList<Employee>();
        teamMates.add(this);
        for (Employee emp : this.directReports) teamMates.add(emp);
        return teamMates;
    }


    @Override
    public String toString() {
        return "Employee [name=" + name + ", gender=" + gender + "]";
    }   
}
