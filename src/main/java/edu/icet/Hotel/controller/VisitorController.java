package edu.icet.Hotel.controller;

import edu.icet.Hotel.dto.Visitor;
import edu.icet.Hotel.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/visitor")
public class VisitorController {

    final VisitorService visitorService;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    @PostMapping("/register-new-visitor")
    public boolean registerNewVisitor(@RequestBody Visitor visitor) {
        if (visitor != null) {
            boolean state = true;
            if(!(visitor.getPhoneNumber().startsWith("07") && visitor.getPhoneNumber().length() == 10)) {
                state = false;
            }
            if(!(isValidEmail(visitor.getEmailAddress()))) {
                state = false;
            }
            if(state) {
                visitorService.registerNewVisitor(visitor);
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

    @GetMapping("/getAll-visitors")
    public List<Visitor> getAllVisitors() {
        return visitorService.getVisitors();
    }

    @GetMapping("/searchByName/{fullName}")
    public Optional<Visitor> searchVisitor(@PathVariable String fullName) {
        return visitorService.searchVisitor(fullName);
    }
}
