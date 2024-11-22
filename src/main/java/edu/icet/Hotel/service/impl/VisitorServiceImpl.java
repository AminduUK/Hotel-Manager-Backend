package edu.icet.Hotel.service.impl;

import edu.icet.Hotel.dto.Visitor;
import edu.icet.Hotel.entity.VisitorEntity;
import edu.icet.Hotel.repository.VisitorDao;
import edu.icet.Hotel.service.VisitorService;
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
public class VisitorServiceImpl implements VisitorService {

    final VisitorDao visitorDao;
    final ModelMapper modelMapper;

    @Override
    public void registerNewVisitor(Visitor visitor) {
        VisitorEntity visitorEntity = modelMapper.map(visitor, VisitorEntity.class);
        visitorDao.save(visitorEntity);
    }

    @Override
    public List<Visitor> getVisitors() {
        List<Visitor> visitors = new ArrayList<>();
        visitorDao.findAll().forEach(VisitorEntity->{
            visitors.add(modelMapper.map(VisitorEntity,Visitor.class));
        });
        return visitors;
    }

    @Override
    public Optional<Visitor> searchVisitor(String fullName) {
        VisitorEntity visitorEntity = visitorDao.findByFullName(fullName);
        if (visitorEntity == null) {
            return Optional.empty();
        }
        Visitor visitor = modelMapper.map(visitorEntity, Visitor.class);
        return Optional.of(visitor);
    }


}
