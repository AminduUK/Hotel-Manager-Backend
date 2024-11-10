package edu.icet.Hotel.service;

import edu.icet.Hotel.dto.Visitor;

import java.util.List;
import java.util.Optional;

public interface VisitorService {

    void registerNewVisitor(Visitor visitor);

    List<Visitor> getVisitors();

    Optional<Visitor> searchVisitor(String fullName);
}
