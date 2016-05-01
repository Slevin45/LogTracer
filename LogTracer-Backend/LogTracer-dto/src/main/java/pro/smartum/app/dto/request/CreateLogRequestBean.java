package pro.smartum.app.dto.request;

/**
 * Created by eldar.s on 25.04.2016.
 */
public class CreateLogRequestBean {
    private String tag;
    private String message;
    private String exception;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getTag() {

        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
