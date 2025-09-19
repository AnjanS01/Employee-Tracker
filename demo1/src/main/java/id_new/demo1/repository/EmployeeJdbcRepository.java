package id_new.demo1.repository;

import id_new.demo1.entity.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Insert
    public int save(Employee employee) {
        String sql = "INSERT INTO employees (emp_id, name, phnumber, email, working_tpe) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, employee.getEmpId(), employee.getName(), employee.getPhnumber(), employee.getEmail(), employee.getWorkingType());
    }

    // Read
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Employee emp = new Employee();
            emp.setId(rs.getLong("id"));
            emp.setEmpId(rs.getString("emp_id"));
            emp.setName(rs.getString("name"));
            emp.setPhnumber(rs.getLong("phnumber"));
            emp.setEmail(rs.getString("email"));
            emp.setWorkingType(rs.getString("working_tpe"));
            return emp;
        });
    }

    // Update
    public int update(Employee employee) {
        String sql = "UPDATE employees SET name=?, phnumber=?, email=?, working_tpe=? WHERE emp_id=?";
        return jdbcTemplate.update(sql, employee.getName(), employee.getPhnumber(), employee.getEmail(), employee.getWorkingType(), employee.getEmpId());
    }

    // Delete
    public int deleteByEmpId(String empId) {
        String sql = "DELETE FROM employees WHERE emp_id=?";
        return jdbcTemplate.update(sql, empId);
    }
}
