package id_new.demo1.controller;

import id_new.demo1.entity.Employee;
import id_new.demo1.repository.EmployeeJdbcRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private final EmployeeJdbcRepository employeeRepo;

    public EmployeeController(EmployeeJdbcRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // Show all employees + form
    @GetMapping("/")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeRepo.findAll());
        model.addAttribute("employee", new Employee());
        return "employees"; // loads employees.html
    }

    // Save new employee
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeRepo.save(employee);
        return "redirect:/";
    }

    // Update employee
    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee) {
        employeeRepo.update(employee);
        return "redirect:/";
    }

    // Delete employee
    @GetMapping("/delete/{empId}")
    public String deleteEmployee(@PathVariable String empId) {
        employeeRepo.deleteByEmpId(empId);
        return "redirect:/";
    }
}
