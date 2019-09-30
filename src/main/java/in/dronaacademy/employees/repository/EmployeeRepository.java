package in.dronaacademy.employees.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.dronaacademy.employees.entity.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer>{

}
