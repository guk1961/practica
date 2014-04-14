package ru.adedit.cron.exeption;

/**
 * 
 * @author Yuriy
 */
public class DmirException extends Exception {

	private static final long serialVersionUID = 1L;

	public DmirException() {
		super();
	}

	public DmirException(String message, Throwable cause) {
		super(message, cause);
	}

	public DmirException(String message) {
		super(message);
	}

	public DmirException(Throwable cause) {
		super(cause);
	}

}
