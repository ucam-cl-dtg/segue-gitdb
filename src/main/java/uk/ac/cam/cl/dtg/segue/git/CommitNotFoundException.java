package uk.ac.cam.cl.dtg.segue.git;

public class CommitNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public CommitNotFoundException() {
	}

	public CommitNotFoundException(String message) {
		super(message);
	}

	public CommitNotFoundException(Throwable cause) {
		super(cause);
	}

	public CommitNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommitNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
