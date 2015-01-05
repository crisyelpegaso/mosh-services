package org.mosh.exception;

public class PersistenceException extends RuntimeException {
	
	/**
	 */
	private static final long serialVersionUID = -3879973086198091303L;

	public PersistenceException(String messsage){
		super(messsage);
	}
	
	public PersistenceException(Throwable cause){
		super(cause);
	}

}
