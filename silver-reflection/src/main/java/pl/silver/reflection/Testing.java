package pl.silver.reflection;

public class Testing {

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	private String string;
	private boolean b;

	public Testing(String string, boolean b) {
		this.string = string;
		this.b = b;
	}

}
