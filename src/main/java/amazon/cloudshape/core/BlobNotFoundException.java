package amazon.cloudshape.core;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Signals that a blob does not exist in the storage.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such blob")
public class BlobNotFoundException extends RuntimeException {
}
