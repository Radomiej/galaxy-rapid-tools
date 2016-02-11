package pl.silver.configuration.exceptions;

public class ConfigurationReadException extends Exception {
	private static final long serialVersionUID = 2790473482837298926L;

	public ConfigurationReadException(Exception e) {
		super(e);
	}
}
