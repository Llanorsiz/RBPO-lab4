package kurban.softwareProducts.common.exception.handler;

import kurban.softwareProducts.common.exception.base.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ProblemDetail> handle(NotFoundException e) {
        return error(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ProblemDetail> handle(ConflictException e) {
        return error(HttpStatus.CONFLICT, e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ProblemDetail> handle(BadRequestException e) {
        return error(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ProblemDetail> handle(ForbiddenException e) {
        return error(HttpStatus.FORBIDDEN, e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ProblemDetail> handle(UnauthorizedException e) {
        return error(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    private static ResponseEntity<ProblemDetail> error(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(ProblemDetail.forStatusAndDetail(status, message));
    }
}
