package uk.ac.cam.cl.dtg.segue.git;

public class PushFailedException extends Exception {

	private static final long serialVersionUID = 1L;

	public PushFailedException() {
	}

	public PushFailedException(String message) {
		super(message);
	}

	public PushFailedException(Throwable cause) {
		super(cause);
	}

	public PushFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public PushFailedException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
