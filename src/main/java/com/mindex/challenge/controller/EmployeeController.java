package com.mindex.challenge.controller;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee) {
        LOG.debug("Received employee create request for [{}]", employee);

        return employeeService.create(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee read(@PathVariable String id) {
        LOG.debug("Received employee read request for id [{}]", id);

        return employeeService.read(id);
    }

    @GetMapping("/employee/{id}/reportingStructure")
    public ReportingStructure getReportingStructure(@PathVariable String id) {
        LOG.debug("Received reportingStructure read request for id [{}]", id);

        Employee employee = employeeService.read(id);

        HashSet<String> visited = new HashSet<>(); // to store visited employees
        visited.add(employee.getEmployeeId()); //add root employee to the visited list to avoid data loops
        ReportingStructure reportingStructure = new ReportingStructure();
        reportingStructure.setEmployee(employee);
        int numberOfReports = countUniqueReports(employee, visited);
        reportingStructure.setNumberOfReports(numberOfReports);
        return reportingStructure;
    }

    @PutMapping("/employee/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        LOG.debug("Received employee update request for id [{}] and employee [{}]", id, employee);

        employee.setEmployeeId(id);
        return employeeService.update(employee);
    }

    private int countUniqueReports(Employee employee, HashSet<String>visited) {
        int count = 0;
        //Get the current employee reports and count and walk unique employees
        LOG.debug("Evaluating employee id [{}]", employee.getEmployeeId());
        List<Employee> directReports = employee.getDirectReports();
        LOG.debug("Employee Reports [{}]", directReports);
        if (directReports != null) {
            for (Employee report : directReports) {
                String reportEmployeeId = report.getEmployeeId();
                //If we have not visited this employee count it and its direct reports
                if (!visited.contains(reportEmployeeId)) {
                    visited.add(reportEmployeeId);
                    count++;
                    count += countUniqueReports(employeeService.read(report.getEmployeeId()), visited);
                }
            }
        }
        return count;
    }
}
