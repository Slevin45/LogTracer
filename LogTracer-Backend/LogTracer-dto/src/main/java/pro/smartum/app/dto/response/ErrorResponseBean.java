package pro.smartum.app.dto.response;

public class ErrorResponseBean extends BaseResponseBean {

    private static final long serialVersionUID = 1L;

    private int errorCode;
    private String errorMessage;


    public ErrorResponseBean() {
    }

    public ErrorResponseBean(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorResponseBean(int errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorResponseBean(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
