package com.crio.xcompany.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Company{
    private String companyName;
    private Employee founder;
    private Map<String,Employee> employeeBook;
    

    private Company(String companyName, Employee founder) {
        this.companyName = companyName;
        this.founder = founder;
        employeeBook = new HashMap<String,Employee>();
        employeeBook.put(founder.getName(), founder);
    }
    

    public static Company create(String companyName, Employee founder){
        return new Company(companyName,founder);
    } 


    public String getCompanyName() {
        return companyName;
    }

    // TODO: CRIO_TASK_MODULE_XCOMPANY
    // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone for each functionality before implementing the logic.
    // This will ensure that the project can be compiled successfully.
    public List<List<Employee>> getEmployeeHierarchy(String managerName) {
        List<List<Employee>> hierarchy =  new ArrayList<List<Employee>>();
        Queue<Employee> qu = new LinkedList<Employee>();

        qu.add(this.employeeBook.get(managerName));

        while (!qu.isEmpty()) {
            List<Employee> temp = new ArrayList<Employee>();
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                Employee emp = qu.poll();
                temp.add(emp);
                for (Employee directReportEmp: emp.getDirectReports()) {
                    qu.add(directReportEmp);
                }
            }
            hierarchy.add(temp);
        }

        return hierarchy;
    }

    public void deleteEmployee(String employeeName) {
        if (this.employeeBook.containsKey(employeeName)) this.employeeBook.remove(employeeName);
    }

    public List<Employee> getTeamMates(String employeeName) {
        return this.employeeBook.get(employeeName).getManager().getTeamMates();
    }

    public List<Employee> getDirectReports(String managerName) {
        return this.employeeBook.get(managerName).getDirectReports();
    }

    public Employee getEmployee(String employeeName) {
        if (this.employeeBook.containsKey(employeeName)) return this.employeeBook.get(employeeName);
        return null;
    }

    public void assignManager(String employeeName, String managerName) {
        this.employeeBook.get(employeeName).assignManager(this.employeeBook.get(managerName));
        this.employeeBook.get(managerName).addDirectReport(this.employeeBook.get(employeeName));
    }

    public void registerEmployee(String employeeName, Gender gender) {
        this.employeeBook.put(employeeName, new Employee(employeeName, gender));
    }

}
