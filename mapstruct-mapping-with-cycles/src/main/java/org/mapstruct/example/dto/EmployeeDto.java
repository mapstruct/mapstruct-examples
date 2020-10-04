/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.dto;

import java.util.List;

/**
 * @author Filip Hrisafov
 */
public class EmployeeDto {

    private String employeeName;
    private EmployeeDto reportsTo;
    private List<EmployeeDto> team;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public EmployeeDto getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(EmployeeDto reportsTo) {
        this.reportsTo = reportsTo;
    }

    public List<EmployeeDto> getTeam() {
        return team;
    }

    public void setTeam(List<EmployeeDto> team) {
        this.team = team;
    }
}
