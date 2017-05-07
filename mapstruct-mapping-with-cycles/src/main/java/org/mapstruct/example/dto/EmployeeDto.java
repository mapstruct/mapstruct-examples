/**
 * Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
 * and/or other contributors as indicated by the @authors tag. See the
 * copyright.txt file in the distribution for a full listing of all
 * contributors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
