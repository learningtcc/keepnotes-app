package org.osanchezh.keepnotes.advices;


import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.osanchezh.keepnotes.commons.exception.KeepNotesDatabaseException;
import org.osanchezh.keepnotes.persistence.LoggingTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;

@Component
@Aspect
@Order(1)
public class KeepNotesServiceThrowsAdvice {
	private static final Logger LOGGER =  LoggerFactory.getLogger(KeepNotesServiceThrowsAdvice.class);
   

    @AfterThrowing(pointcut = "execution(* org.osanchezh.keepnotes..*.*(..))",
                   throwing = "dataAccessEx")
    public void doRecoveryActionDataAccess(DataAccessException dataAccessEx) throws KeepNotesDatabaseException {
        LOGGER.debug(dataAccessEx.getMessage());

        throw new KeepNotesDatabaseException("Error en Persistencia: " + dataAccessEx.getMessage(), dataAccessEx);
    }

    @AfterThrowing(pointcut = "execution(* org.osanchezh.keepnotes..*.*(..))",
                   throwing = "uncategorizedSQLException")
    public void doRecoveryUncategorized(UncategorizedSQLException uncategorizedSQLException) throws KeepNotesDatabaseException {
        LOGGER.debug(uncategorizedSQLException.getMessage());
        throw new KeepNotesDatabaseException("Error en SQL: " + uncategorizedSQLException.getMessage(),
                                     uncategorizedSQLException);
    }

    @AfterThrowing(pointcut = "execution(* org.osanchezh.keepnotes..*.*(..))",
                   throwing = "txException")
    public void doRecoveryCreateTransaction(CannotCreateTransactionException txException) throws KeepNotesDatabaseException {
        LOGGER.debug(txException.getMessage());
        throw new KeepNotesDatabaseException("Error en Persistencia: " + txException.getMessage(), txException);
    }
}
