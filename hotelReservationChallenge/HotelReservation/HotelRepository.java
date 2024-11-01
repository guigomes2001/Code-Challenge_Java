package com.hotelReservationChallenge.HotelReservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long>{
	List<Hotel> findByStars(int stars);
    List<Hotel> findByRoomTypesContaining(String roomType);
}


