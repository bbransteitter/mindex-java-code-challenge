package com.mindex.challenge.data;

public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;
 
    public ReportingStructure() {
    }

    /**
     * Returns the Employee for the ReportingStructure
     * @return Employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets the Employee for the ReportingStructure
     * @param employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Returns the numberOfReports for the ReportingStructure
     * @return Integer
     */
    public int getNumberOfReports() {
        return this.numberOfReports;
    }

    /**
     * Sets the numberOfReports for the ReportingStructure
     */
    public void setNumberOfReports(int reports) {
        this.numberOfReports = reports;
    }
}
