package in.dronaacademy.employees.transformers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransformerConfig {
	@Bean
	@Qualifier("employeeResponseTransformationMap")
	public Map<String, String> employeeResponseTransformationMap() {
		Map<String, String> propertyMap = new HashMap<>();
		propertyMap.put("id", "id");
		propertyMap.put("dateOfBirth", "dateOfBirth");
		propertyMap.put("hireDate", "dateOfHiring");
		propertyMap.put("gender", "gender");
		propertyMap.put("firstName", "firstName");
		propertyMap.put("lastName", "lastName");
		return propertyMap;
	}
}
