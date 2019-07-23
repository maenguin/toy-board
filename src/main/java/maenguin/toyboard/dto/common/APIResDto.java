package maenguin.toyboard.dto.common;

import lombok.Getter;
import maenguin.toyboard.enums.ErrorCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class APIResDto {

    private String code;
    private String message;
    private List result;

    public APIResDto(final ErrorCode errorCode) {
        this(errorCode,new ArrayList());
    }

    public APIResDto(final ErrorCode errorCode, final ResponseDto responseDto) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.result = new ArrayList(Arrays.asList(responseDto));
    }
    public APIResDto(final ErrorCode errorCode, final List body) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.result = body;
    }

    //GlobalException용
    public static APIResDto of(final ErrorCode errorCode) {
        return new APIResDto(errorCode);
    }

    //성공시
    public static APIResDto of(final ResponseDto responseDto) {
        return new APIResDto(ErrorCode.SUCCESS,responseDto);
    }
    public static APIResDto of(final List body) {
        return new APIResDto(ErrorCode.SUCCESS,body);
    }

}
