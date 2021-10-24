package org.mapstruct.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mapstruct.example.dto.Department;
import org.mapstruct.example.dto.Employee;
import org.mapstruct.example.mapper.MapToBeanMapper;

/**
 * @author Filip Hrisafov
 */
public class MapToBeanMapperTest {

    @Test
    public void shouldMapMapToBean() {
        Map<String, String> map = new HashMap<>();
        map.put("id", "1234");
        map.put("name", "Tester");
        map.put("did", "4321"); //Department Id
        map.put("dname", "Test");// Depart name

        Employee employee = MapToBeanMapper.INSTANCE.fromMap(map);

        assertNotNull(employee);
        assertEquals(employee.getId(), "1234");
        assertEquals(employee.getName(), "Tester");

        Department department = employee.getDepartment();
        assertNotNull(department);
        assertEquals(department.getId(), "4321");
        assertEquals(department.getName(), "Test");
    }
}
