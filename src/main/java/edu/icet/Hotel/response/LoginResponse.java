package edu.icet.Hotel.response;

public class LoginResponse {

    private boolean valid;
    private Long visitorId;

    public LoginResponse(boolean valid, Long visitorId) {
        this.valid = valid;
        this.visitorId = visitorId;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }
}
