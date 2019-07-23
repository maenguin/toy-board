package maenguin.toyboard.exception;


import maenguin.toyboard.dto.common.APIResDto;
import maenguin.toyboard.exception.business.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<APIResDto> handleBusinessException(final BusinessException e) {
        final APIResDto apiResDto = APIResDto.of(e.getErrorCode());
        return ResponseEntity.ok().body(apiResDto);
    }
}
