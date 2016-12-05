/**
 *  Copyright 2012-2016 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mapstruct.example.dto.Employee;
import org.mapstruct.example.dto.EmployeeDto;
import org.mapstruct.example.mapper.EmployeeMapper;

/**
 *
 * @author Filip Hrisafov
 */
public class EmployeeMapperTest {

    @Test
    public void testMapDtoToEntity() {

        EmployeeDto teamLeader = employeeDto( "Group Leader", null );

        EmployeeDto member1 = employeeDto( "Member2", teamLeader );
        EmployeeDto member2 = employeeDto( "Member2", teamLeader );
        teamLeader.setTeam( Arrays.asList( member1, member2 ) );

        Employee teamLead = EmployeeMapper.MAPPER.toEmployee( teamLeader );

        assertThat( teamLead ).isNotNull();
        assertThat( teamLead.getReportsTo() ).isNull();
        List<Employee> team = teamLead.getTeam();
        assertThat( team ).hasSize( 2 );
        assertThat( team ).extracting( "reportsTo" ).containsExactly( teamLead, teamLead );
    }

    private EmployeeDto employeeDto(String name, EmployeeDto reportsTo) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeName( name );
        employeeDto.setReportsTo( reportsTo );
        return employeeDto;
    }

    @Test
    public void testMapEntityToDto() {

        Employee teamLeader = employee( "Group Leader", null );

        Employee member1 = employee( "Member2", teamLeader );
        Employee member2 = employee( "Member2", teamLeader );
        teamLeader.setTeam( Arrays.asList( member1, member2 ) );

        EmployeeDto teamLead = EmployeeMapper.MAPPER.fromEmployee( teamLeader );

        assertThat( teamLead ).isNotNull();
        assertThat( teamLead.getReportsTo() ).isNull();
        List<EmployeeDto> team = teamLead.getTeam();
        assertThat( team ).hasSize( 2 );
        assertThat( team ).extracting( "reportsTo" ).containsExactly( teamLead, teamLead );
    }

    private Employee employee(String name, Employee reportsTo) {
        Employee employee = new Employee();
        employee.setName( name );
        employee.setReportsTo( reportsTo );
        return employee;
    }
}
