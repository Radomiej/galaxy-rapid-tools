package pl.silver.reflection;

import java.lang.reflect.Field;

public class PublicField implements SilverField {

	private Field field;
	
	public PublicField(Field field) {
		this.field = field;
	}
	
	public String getFieldName() {
		return field.getName();
	}

	public <T> T getFieldValue(Object orginalObject, Class<T> returnClass) {
		try {
			Object value = field.get(orginalObject);
			return returnClass.cast(value);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setFieldValue(Object orginalObject, Object setObject) {
		try {
			field.set(orginalObject, setObject);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public Object getFieldValue(Object orginalObject) {
		try {
			return field.get(orginalObject);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Class getFieldValueClass() {
		return field.getType();
	}

}
