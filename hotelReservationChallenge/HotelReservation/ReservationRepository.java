package com.hotelReservationChallenge.HotelReservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	List<Reservation> findByHotelId(Long hotelId);
}
