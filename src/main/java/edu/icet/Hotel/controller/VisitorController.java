package edu.icet.Hotel.controller;

import edu.icet.Hotel.dto.Visitor;
import edu.icet.Hotel.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/visitor")
public class VisitorController {

    final VisitorService visitorService;

    @PostMapping("/registerNewVisitor")
    public boolean registerNewVisitor(@RequestBody Visitor visitor) {
        if (visitor != null) {
            visitorService.registerNewVisitor(visitor);
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/getAll")
    public List<Visitor> getAllVisitors() {
        return visitorService.getVisitors();
    }

    @GetMapping("/searchByName/{fullName}")
    public Optional<Visitor> searchVisitor(@PathVariable String fullName) {
        return visitorService.searchVisitor(fullName);
    }
}
