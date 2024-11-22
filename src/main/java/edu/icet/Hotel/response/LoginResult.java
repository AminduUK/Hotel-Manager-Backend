package edu.icet.Hotel.response;

import java.util.Optional;

public class LoginResult {

    private boolean valid;
    private Optional<Long> visitorIdOnl;

    public LoginResult(boolean valid, Optional<Long> visitorId) {
        this.valid = valid;
        this.visitorIdOnl = visitorId;
    }

    public boolean isValid() {
        return valid;
    }

    public Optional<Long> getVisitorId() {
        return visitorIdOnl;
    }
}
