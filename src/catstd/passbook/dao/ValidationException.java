package catstd.passbook.dao;

public class ValidationException extends PersistanceException {

	private static final long serialVersionUID = 1L;

	public ValidationException() {
		super();
	}

	public ValidationException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public ValidationException(String detailMessage) {
		super(detailMessage);
	}

	public ValidationException(Throwable throwable) {
		super(throwable);
	}

}
