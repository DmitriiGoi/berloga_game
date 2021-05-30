package springboot.domain;

import lombok.Data;

@Data
public class Error {
    private String errorMsg;
    private ErrorCode errorCode;
}
