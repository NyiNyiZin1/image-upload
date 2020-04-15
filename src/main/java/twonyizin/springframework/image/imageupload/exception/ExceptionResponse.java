package twonyizin.springframework.image.imageupload.exception;

import java.util.Date;

/**
 * @author TheinZaw
 */
public class ExceptionResponse {
    private boolean result;
    private String message;
    private Date timestamp;

    public ExceptionResponse() {
    }

    public ExceptionResponse(boolean result, String message, Date timestamp) {
        this.result = result;
        this.message = message;
        this.timestamp = timestamp;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
