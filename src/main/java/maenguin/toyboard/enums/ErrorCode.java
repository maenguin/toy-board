package maenguin.toyboard.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {


    SUCCESS("0","success"),
    ENTITY_NOT_FOUND("C001", "Entity Not Found"),
    INVALID_TYPE_VALUE("C002", "Invalid Type Value"),
    INVALID_INPUT_VALUE("C003", "Invalid Input Value");


    private final String code;
    private final String message;

    ErrorCode(final String code, final String message){
        this.code = code;
        this.message = message;
    }


}
