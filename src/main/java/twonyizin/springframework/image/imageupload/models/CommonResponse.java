package twonyizin.springframework.image.imageupload.models;

public class CommonResponse {
    private Boolean result;
    public CommonResponse() {
    }

    public CommonResponse(boolean result) {
        super();
        this.result = result;
    }
    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
