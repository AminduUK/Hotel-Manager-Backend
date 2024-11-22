package edu.icet.Hotel.service;

import edu.icet.Hotel.dto.OnlineVisitor;

import java.util.List;
import java.util.Optional;

public interface OnlineVisitorService {

    void registerNewOnlineVisitor(OnlineVisitor onlineVisitor);

    List<OnlineVisitor> getOnlineVisitors();

    Optional<OnlineVisitor> searchOnlineVisitor(String fullName);
}
