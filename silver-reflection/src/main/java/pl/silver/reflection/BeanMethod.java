package pl.silver.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanMethod implements SilverField{

	private Method setter;
	private Method getter;
	private String name;

	public void putSetter(Method setter) {
		this.setter = setter;
	}

	public void putGetter(Method getter) {
		this.getter = getter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Method getSetter() {
		return setter;
	}
	
	public Method getGetter() {
		return getter;
	}

	public void setField(Object orginalObject, Object newValue) {
		try {
			setter.invoke(orginalObject, newValue);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public String getFieldName() {
		return name;
	}

	public Object getFieldValue(Object orginalObject) {
		if(getter == null || setter == null){
			System.err.println("niepelny obiekt");
		}
		try {
			return getter.invoke(orginalObject);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	public <T> T getFieldValue(Object orginalObject, Class<T> returnClass) {
		Object getObject = getFieldValue(orginalObject);
		return returnClass.cast(getObject);
	}

	public void setFieldValue(Object orginalObject, Object newValue) {
		setField(orginalObject, newValue);
	}

	public Class getFieldValueClass() {
		return getter.getReturnType();
	}	
}
