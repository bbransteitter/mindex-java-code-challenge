package com.mindex.challenge.data;

import java.util.Date;

public class Compensation {
    private Employee employee;
    private double salary;
    private Date effectiveDate;
 
    public Compensation() {
    }

    /**
     * Returns the EmployeeId for the ReportingStructure
     * @return String
     */
    public Employee getEmployee() {
        return this.employee;
    }

    /**
     * Sets the EmployeeId for the Compensation
     * @param String employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Returns the salary for the Compensation
     * @return double
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * Sets the amount of the salary
     * @param double amount
     */
    public void setSalary(double amount) {
        this.salary = amount;
    }

    /**
     * Returns the effectiveDate for the Compensation
     * @return Date
     */
    public Date getEffectiveDate() {
        return this.effectiveDate;
    }

    /**
     * Sets the effectiveDate of the salary for the Compensation
     * @param Date effectiveDate
     */
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}