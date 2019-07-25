package maenguin.toyboard.exception;


import maenguin.toyboard.dto.common.APIResDto;
import maenguin.toyboard.enums.ErrorCode;
import maenguin.toyboard.exception.business.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<APIResDto> handleBusinessException(final BusinessException e) {
        final APIResDto apiResDto = APIResDto.of(e.getErrorCode());
        return ResponseEntity.ok().body(apiResDto);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<APIResDto> handleException(Exception e) {
        final APIResDto apiResDto = APIResDto.of(e.getMessage());
        return ResponseEntity.ok().body(apiResDto);
    }
}
