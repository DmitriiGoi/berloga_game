package springboot.domain;


import lombok.Data;

@Data
public class Result<T> {
    private T data;
    private Error error;

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        return result;
    }

    public static Result error(ErrorCode errorCode, String errorMessage) {
        Result objectResult = new Result<>();
        objectResult.setError(new Error());
        objectResult.getError().setErrorMsg(errorMessage);
        objectResult.getError().setErrorCode(errorCode);
        return objectResult;
    }

}
