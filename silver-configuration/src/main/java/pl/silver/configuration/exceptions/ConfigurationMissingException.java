package pl.silver.configuration.exceptions;

public class ConfigurationMissingException extends Exception {
	private static final long serialVersionUID = 1944000600708049508L;

	public ConfigurationMissingException(String m) {
		super(m);
	}
}
