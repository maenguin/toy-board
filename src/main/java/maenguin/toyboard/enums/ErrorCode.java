package maenguin.toyboard.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {


    SUCCESS("0","success"),
    UNHANDLED_ERROR("-1","확인되지 않을 에러"),

    ENTITY_NOT_FOUND("C001", "Entity Not Found"),
    INVALID_TYPE_VALUE("C002", "Invalid Type Value"),
    INVALID_INPUT_VALUE("C003", "Invalid Input Value"),

    EMAIL_OR_PASS_NOT_MATCHED("A001","이메일이나 비밀번호가 일치하지 않습니다."),
    EMAIL_DUPLICATION("A002","중복된 이메일이 존재합니다."),
    EMAIL_NOT_FOUND("A003","해당 이메일을 찾을 수 없습니다."),
    ACCOUNT_NOT_FOUND("A003","등록된 계정이 존재하지 않습니다."),

    POST_NOT_FOUND("P001","등록된 글이 없습니다."),
    POST_DELETED("P002","삭제된 글입니다.");

    private final String code;
    private final String message;

    ErrorCode(final String code, final String message){
        this.code = code;
        this.message = message;
    }


}
