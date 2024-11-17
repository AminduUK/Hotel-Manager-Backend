package edu.icet.Hotel.service.impl;

import edu.icet.Hotel.dto.Booking;
import edu.icet.Hotel.entity.BookingEntity;
import edu.icet.Hotel.repository.BookingDao;
import edu.icet.Hotel.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    final BookingDao bookingDao;
    final ModelMapper modelMapper;

    @Override
    public List<Booking> getBookings() {
        List<Booking> bookings = new ArrayList<>();
        bookingDao.findAll().forEach(BookingEntity->{
            bookings.add(modelMapper.map(BookingEntity, Booking.class));
        });
        return bookings;
    }

    @Override
    public void addNewBooking(Booking booking) {
        BookingEntity bookingEntity = modelMapper.map(booking, BookingEntity.class);
        bookingDao.save(bookingEntity);
    }
}
