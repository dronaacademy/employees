package in.dronaacademy.employees.service;

import org.springframework.data.domain.Page;

import in.dronaacademy.employees.entity.Employee;

public interface EmployeeService {
	Employee getEmployeeById(Integer id);

	Page<Employee> getAllEmployees(int recordCount, int pageNumber);

	void save(Employee employee);

	void delete(Integer id);
}
