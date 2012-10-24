package catstd.passbook.dao;

public class PersistanceException extends Exception {

	private static final long serialVersionUID = 1L;

	public PersistanceException() {
		super();
	}

	public PersistanceException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public PersistanceException(String detailMessage) {
		super(detailMessage);
	}

	public PersistanceException(Throwable throwable) {
		super(throwable);
	}
	
}
