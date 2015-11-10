package pl.silver.reflection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectionBean {
	private Class reflectClass;
	private Map<String, BeanMethod> fieldMethods;
	
	public ReflectionBean(Class tClass) {
		reflectClass = tClass;
		fieldMethods = new HashMap<String, BeanMethod>();
	}

	public Class getReflectClass() {
		return reflectClass;
	}

	public void setReflectClass(Class reflectClass) {
		this.reflectClass = reflectClass;
	}

	public void addFieldBeanMethod(BeanMethod beanMethod) {
		fieldMethods.put(beanMethod.getName(), beanMethod);
	}

	public Collection<BeanMethod> getFieldMethods() {
		return fieldMethods.values();
	}

}
