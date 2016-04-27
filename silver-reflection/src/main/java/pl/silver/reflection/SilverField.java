package pl.silver.reflection;

public interface SilverField {
	public String getFieldName();
	public <T> T getFieldValue(Object orginalObject, Class<T> returnClass);
	public void setFieldValue(Object orginalObject, Object setObject);
	public Object getFieldValue(Object orginalObject);
	public Class getFieldValueClass();
}
