package org.osanchezh.keepnotes.commons.exception;

public class KeepNotesDatabaseException  extends Exception {

    private static final long serialVersionUID = 4356630206011251573L;


    public KeepNotesDatabaseException() {
        super();

    }


    public KeepNotesDatabaseException(String message) {
        super(message);

    }


    public KeepNotesDatabaseException(String message, Throwable cause) {
        super(message, cause);

    }


    public KeepNotesDatabaseException(Throwable cause) {
        super(cause);

    }
}
