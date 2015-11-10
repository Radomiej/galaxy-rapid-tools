package pl.silver.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanMethod {

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

	public Object getField(Object object) {
		if(getter == null || setter == null){
			System.err.println("niepelny obiekt");
		}
		try {
			return getter.invoke(object);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setField(Object orginal, Object newValue) {
		try {
			setter.invoke(orginal, newValue);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}	
}
