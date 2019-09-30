package in.dronaacademy.employees.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import in.dronaacademy.employees.entity.Employee;
import in.dronaacademy.employees.repository.EmployeeRepository;
import in.dronaacademy.employees.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployeeById(Integer id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}

	@Override
	public Page<Employee> getAllEmployees(int recordCount, int pageNumber) {
		return employeeRepository.findAll(PageRequest.of(pageNumber, recordCount));
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void delete(Integer id) {
		employeeRepository.deleteById(id);
	}

}
