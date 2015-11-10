package pl.silver.reflection;

import java.awt.PageAttributes.OriginType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SilverReflectionUtills {
	public static void copyProperties(Object orginal, Object newData) {
		if(!orginal.getClass().equals(newData.getClass())){
			System.err.println("Cannot copy between difrent class.");
			throw new UnsupportedOperationException("Cannot copy between difrent class");
		}
		
		
		Class tClass = orginal.getClass();
		ReflectionBean bean = createReflectionBean(tClass);
		for(BeanMethod fieldMethod : bean.getFieldMethods()){
			fieldMethod.setField(orginal, fieldMethod.getField(newData));
		}
		
	}

	private static ReflectionBean createReflectionBean(Class tClass) {
		ReflectionBean bean = new ReflectionBean(tClass);
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
		return bean;
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
