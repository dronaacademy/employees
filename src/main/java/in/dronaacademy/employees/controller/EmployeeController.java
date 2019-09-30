package in.dronaacademy.employees.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.dronaacademy.employees.entity.Employee;
import in.dronaacademy.employees.model.GetEmployeeResponse;
import in.dronaacademy.employees.service.EmployeeService;
import in.dronaacademy.employees.util.SimpleObjectTransformer;

@RestController
@RequestMapping(path = "/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	@Qualifier("employeeResponseTransformationMap")
	private Map<String, String> transformationMap;

	@Autowired
	private SimpleObjectTransformer<Employee, GetEmployeeResponse> getEmployeeTransformer;

	@RequestMapping(method = RequestMethod.GET)
	public GetEmployeeResponse getEmployeeById(@RequestParam(name = "id") Integer id) {
		Employee employee = employeeService.getEmployeeById(id);
		return employee != null
				? getEmployeeTransformer.transform(employee, GetEmployeeResponse.class, transformationMap)
				: null;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/all")
	public Page<GetEmployeeResponse> getEmployees(@RequestParam(name = "page") int page,
			@RequestParam(name = "count") int count) {
		Page<Employee> employees = employeeService.getAllEmployees(count, page);
		List<GetEmployeeResponse> employeeList = new ArrayList<>();
		for (Employee e : employees) {
			employeeList.add(getEmployeeTransformer.transform(e, GetEmployeeResponse.class, transformationMap));
		}
		Page<GetEmployeeResponse> result = new PageImpl<GetEmployeeResponse>(employeeList);
		return result;
	}
}
