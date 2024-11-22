package edu.icet.Hotel.repository;

import edu.icet.Hotel.entity.OnlineBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnlineBookingDao extends JpaRepository<OnlineBookingEntity, Long> {
}
