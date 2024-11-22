package edu.icet.Hotel.controller;

import edu.icet.Hotel.dto.OnlineVisitor;
import edu.icet.Hotel.service.OnlineVisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/online-visitor")
public class OnlineVisitorController {

    final OnlineVisitorService onlineVisitorService;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    @PostMapping("/register-new-online-visitor")
    public boolean registerNewOnlineVisitor(@RequestBody OnlineVisitor onlineVisitor) {
        if (onlineVisitor != null) {
            boolean state = true;
            if(!(onlineVisitor.getPhoneNumberOnl().startsWith("07") && onlineVisitor.getPhoneNumberOnl().length() == 10)) {
                state = false;
            }
            if(!(isValidEmail(onlineVisitor.getEmailAddressOnl()))) {
                state = false;
            }
            if(state) {
                onlineVisitorService.registerNewOnlineVisitor(onlineVisitor);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    @GetMapping("/getAll-online-visitors")
    public List<OnlineVisitor> getAllOnlineVisitors() {
        return onlineVisitorService.getOnlineVisitors();
    }

    @GetMapping("/searchByName-online/{fullNameOnl}")
    public Optional<OnlineVisitor> searchOnlineVisitor(@PathVariable String fullNameOnl) {
        return onlineVisitorService.searchOnlineVisitor(fullNameOnl);
    }
    
}
