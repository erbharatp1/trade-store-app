package com.dsa.trade.app.exception;

import java.util.Optional;

import org.springframework.hateoas.mediatype.vnderrors.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * 
 * @author Bharat Patel
 *
 */
@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class TradeControllerAdvice extends ResponseEntityExceptionHandler{
    @SuppressWarnings("deprecation")
	@ExceptionHandler(InvalidTradeException.class)
    public ResponseEntity<VndErrors> notFoundException(final InvalidTradeException e) {
        return error(e, HttpStatus.NOT_ACCEPTABLE, e.getId());
    }

    @SuppressWarnings("deprecation")
	private ResponseEntity<VndErrors> error(
            final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message =
                Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
    }

    @SuppressWarnings("deprecation")
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<VndErrors> assertionException(final IllegalArgumentException e) {
        return error(e, HttpStatus.NOT_ACCEPTABLE, e.getLocalizedMessage());
    }



}
