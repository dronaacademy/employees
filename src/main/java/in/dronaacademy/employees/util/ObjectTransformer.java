package in.dronaacademy.employees.util;

import java.util.Map;

public interface ObjectTransformer<A, B> {
	public B transform(A ref, Class<B> clazz, Map<String, String> propertyMap);
}
