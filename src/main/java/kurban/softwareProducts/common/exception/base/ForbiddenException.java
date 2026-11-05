package kurban.softwareProducts.common.exception.base;

import lombok.experimental.StandardException;

@StandardException
public class ForbiddenException extends RuntimeException {
    public ForbiddenException(String message) {
        super(message);
    }
}