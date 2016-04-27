package pl.silver.reflection.tools;

public class StringCastHelper {

	@SuppressWarnings("rawtypes")
	public static Object castStringToValue(String newVal, Class class1) {
		if(class1.equals(Integer.class)){
			return Integer.parseInt(newVal);
		}else if(class1.equals(Float.class)){
			return Float.parseFloat(newVal);
		}else if(class1.equals(Double.class)){
			return Double.parseDouble(newVal);
		}else if(class1.equals(Long.class)){
			return Long.parseLong(newVal);
		}
		return null;
	}

}
