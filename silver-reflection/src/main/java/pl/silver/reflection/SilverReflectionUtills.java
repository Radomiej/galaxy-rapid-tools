package pl.silver.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class SilverReflectionUtills {
	
	@SuppressWarnings("rawtypes")
	public static Object create(Class factoryClass){
		try {
			return factoryClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void copy(Object orginal, Object newData){
		copyProperties(orginal, newData);
	}
	
	@SuppressWarnings("rawtypes")
	public static void copyProperties(Object orginal, Object newData) {
		if(orginal == null || newData == null){
			System.err.println("One or all object is null. Abort copy.");
			return;
		}
		if(!orginal.getClass().equals(newData.getClass())){
			System.err.println("Cannot copy between difrent class.");
			throw new UnsupportedOperationException("Cannot copy between difrent class");
		}
		
		
		Class tClass = orginal.getClass();
		ReflectionBean bean = createReflectionBean(tClass);
		for(BeanMethod fieldMethod : bean.getFieldMethods()){
			fieldMethod.setField(orginal, fieldMethod.getFieldValue(newData));
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public static ReflectionBean createReflectionBean(Class tClass) {
		ReflectionBean bean = new ReflectionBean(tClass);
		createBeanMethods(tClass, bean);
		createPublicMethods(tClass, bean);
		return bean;
	}

	@SuppressWarnings("rawtypes")
	private static void createPublicMethods(Class tClass, ReflectionBean bean) {
		Field[] fields = tClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			if(!Modifier.isPublic(field.getModifiers())) continue;
			PublicField publicField = new PublicField(field);
			bean.addPublicField(publicField);
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	private static void createBeanMethods(Class tClass, ReflectionBean bean) {
		Method[] methods = tClass.getMethods();
		for (int i = 0; i < methods.length; i++) {
			if(methods[i].getName().startsWith("set") && methods[i].getName().length() >= 4){
				Method setter = methods[i];
				BeanMethod beanMethod = new BeanMethod();
				beanMethod.putSetter(setter);
				
				String varName = setter.getName().replace("set", "");
				Method getter = getGetterMethodFor(varName, methods);
				if(getter == null){
					continue;
				}
				
				beanMethod.putGetter(getter);
				
				char c[] = varName.toCharArray();
				c[0] = Character.toLowerCase(c[0]);
				varName = new String(c);
				beanMethod.setName(varName);
				
				
				bean.addFieldBeanMethod(beanMethod);
			}			
		}
	}

	private static Method getGetterMethodFor(String name, Method[] methods) {
		for (int i = 0; i < methods.length; i++) {
			if(methods[i].getName().startsWith("get") || methods[i].getName().startsWith("is")){
				Method getter = methods[i];
				String methodName = getter.getName();
				methodName = methodName.replace("get", "");
				methodName = methodName.replace("is", "");
				if(methodName.equals(name)){
					return getter;
				}
			}
		}
		return null;
	}
}
