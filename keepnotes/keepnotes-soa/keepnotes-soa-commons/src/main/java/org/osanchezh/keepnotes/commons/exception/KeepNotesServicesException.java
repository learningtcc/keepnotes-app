package org.osanchezh.keepnotes.commons.exception;

public class KeepNotesServicesException  extends Exception {

	private static final long serialVersionUID = -278729312055876370L;

 
	public KeepNotesServicesException() {
         super();

    }


    public KeepNotesServicesException(String message) {
        super(message);

    }


    public KeepNotesServicesException(String message, Throwable cause) {
        super(message, cause);

    }


    public KeepNotesServicesException(Throwable cause) {
        super(cause);

    }
}