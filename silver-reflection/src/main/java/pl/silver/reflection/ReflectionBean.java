package pl.silver.reflection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.utils.reflect.Method;

public class ReflectionBean {
	private Class reflectClass;
	private Map<String, BeanMethod> fieldMethods;
	private Map<String, PublicField> fields;
	
	ReflectionBean(Class tClass) {
		reflectClass = tClass;
		fieldMethods = new HashMap<String, BeanMethod>();
		fields = new HashMap<String, PublicField>();
	}

	public Class getReflectClass() {
		return reflectClass;
	}

	void setReflectClass(Class reflectClass) {
		this.reflectClass = reflectClass;
	}

	void addFieldBeanMethod(BeanMethod beanMethod) {
		fieldMethods.put(beanMethod.getName(), beanMethod);
	}

	void addPublicField(PublicField publicField) {
		fields.put(publicField.getFieldName(), publicField);
	}

	public Collection<BeanMethod> getFieldMethods() {
		return fieldMethods.values();
	}
	
	public Collection<PublicField> getPublicFields() {
		return fields.values();
	}
	
	public Collection<SilverField> getPublicAccesFields() {
		ArrayList<SilverField> fieldsAccesor = new ArrayList<SilverField>();
		fieldsAccesor.addAll(getFieldMethods());
		fieldsAccesor.addAll(getPublicFields());
		return fieldsAccesor;
	}

}
