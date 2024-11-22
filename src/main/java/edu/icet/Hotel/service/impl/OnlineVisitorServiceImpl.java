package edu.icet.Hotel.service.impl;

import edu.icet.Hotel.dto.OnlineVisitor;
import edu.icet.Hotel.entity.OnlineVisitorEntity;
import edu.icet.Hotel.repository.OnlineVisitorDao;
import edu.icet.Hotel.service.OnlineVisitorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class OnlineVisitorServiceImpl implements OnlineVisitorService {

    final OnlineVisitorDao onlineVisitorDao;
    final ModelMapper modelMapper;

    @Override
    public void registerNewOnlineVisitor(OnlineVisitor onlineVisitor) {
        OnlineVisitorEntity onlineVisitorEntity = modelMapper.map(onlineVisitor, OnlineVisitorEntity.class);
        onlineVisitorDao.save(onlineVisitorEntity);
    }

    @Override
    public List<OnlineVisitor> getOnlineVisitors() {
        List<OnlineVisitor> onlineVisitors = new ArrayList<>();
        onlineVisitorDao.findAll().forEach(OnlineVisitorEntity->{
            onlineVisitors.add(modelMapper.map(OnlineVisitorEntity, OnlineVisitor.class));
        });
        return onlineVisitors;
    }

    @Override
    public Optional<OnlineVisitor> searchOnlineVisitor(String fullName) {
        OnlineVisitorEntity onlineVisitorEntity = onlineVisitorDao.findByFullNameOnl(fullName);
        if (onlineVisitorEntity == null) {
            return Optional.empty();
        }
        OnlineVisitor onlineVisitor = modelMapper.map(onlineVisitorEntity, OnlineVisitor.class);
        return Optional.of(onlineVisitor);
    }
}
