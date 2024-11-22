package edu.icet.Hotel.service.impl;

import edu.icet.Hotel.dto.OnlineVisitorLogin;
import edu.icet.Hotel.repository.OnlineVisitorDao;
import edu.icet.Hotel.response.LoginResult;
import edu.icet.Hotel.service.OnlineVisitorLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class OnlineVisitorLoginServiceImpl implements OnlineVisitorLoginService {

    final OnlineVisitorDao onlineVisitorDao;

    @Override
    public LoginResult validateCredentials(OnlineVisitorLogin onlineVisitorLogin) {
        boolean present = onlineVisitorDao.findByEmailAddressOnlAndIdNumberOnl(
                onlineVisitorLogin.getUsernameOnl(),
                onlineVisitorLogin.getPasswordOnl()).isPresent();

        Optional<Long> visitorIdOnl = Optional.empty();

        if (present) {
            visitorIdOnl = validateCredentialsForId(onlineVisitorLogin);
        }

        return new LoginResult(present, visitorIdOnl);
    }


    @Override
    public Optional<Long> validateCredentialsForId(OnlineVisitorLogin onlineVisitorLogin) {
        return onlineVisitorDao.findVisitorIdByEmailAndIdNumber(
                onlineVisitorLogin.getUsernameOnl(),
                onlineVisitorLogin.getPasswordOnl()
        );
    }

}
