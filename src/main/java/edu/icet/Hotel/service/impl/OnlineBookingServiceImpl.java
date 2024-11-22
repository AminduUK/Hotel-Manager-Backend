package edu.icet.Hotel.service.impl;

import edu.icet.Hotel.dto.OnlineBooking;
import edu.icet.Hotel.entity.OnlineBookingEntity;
import edu.icet.Hotel.repository.OnlineBookingDao;
import edu.icet.Hotel.service.OnlineBookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class OnlineBookingServiceImpl implements OnlineBookingService {

    final OnlineBookingDao onlineBookingDao;
    final ModelMapper modelMapper;

    @Override
    public List<OnlineBooking> getOnlineBookings() {
        List<OnlineBooking> bookings = new ArrayList<>();
        onlineBookingDao.findAll().forEach(OnlineBookingEntity->{
            bookings.add(modelMapper.map(OnlineBookingEntity, OnlineBooking.class));
        });
        return bookings;
    }

    @Override
    public void addNewOnlineBooking(OnlineBooking onlineBooking) {
        OnlineBookingEntity onlineBookingEntity = modelMapper.map(onlineBooking, OnlineBookingEntity.class);
        onlineBookingDao.save(onlineBookingEntity);
    }
}
