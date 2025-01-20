package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query("EXEC GetAllEmployees", 
            (rs, rowNum) -> new Employee(
                rs.getString("name"), 
                rs.getString("department")
            ));
    }
}
