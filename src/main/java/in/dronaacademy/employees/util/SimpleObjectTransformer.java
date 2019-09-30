package in.dronaacademy.employees.util;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

@Component
public class SimpleObjectTransformer<A, B> implements ObjectTransformer<A, B> {
	@Override
	@SuppressWarnings("unchecked")
	public B transform(A ref, Class<B> clazz, Map<String, String> propertyMap) {
		try {
			B result = (B) Class.forName(clazz.getCanonicalName()).getConstructor().newInstance();
			for (Entry<String, String> entry : propertyMap.entrySet()) {
				Field f = ref.getClass().getDeclaredField(entry.getKey());
				f.setAccessible(true);
				Object value = f.get(ref);

				Field fx = result.getClass().getDeclaredField(entry.getValue());
				fx.setAccessible(true);
				fx.set(result, value);
			}
			return result;
		} catch (Exception ex) {
			throw new RuntimeException("Object conversion failed: " + ex.getMessage(), ex);
		}
	}

}
