package edu.icet.Hotel.service;

import edu.icet.Hotel.dto.OnlineVisitorLogin;
import edu.icet.Hotel.response.LoginResult;
import java.util.Optional;

public interface OnlineVisitorLoginService {

    LoginResult validateCredentials(OnlineVisitorLogin onlineVisitorLogin);

    Optional<Long> validateCredentialsForId(OnlineVisitorLogin onlineVisitorLogin);

}
