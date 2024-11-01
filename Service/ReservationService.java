package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelReservationChallenge.HotelReservation.Reservation;
import com.hotelReservationChallenge.HotelReservation.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	public Reservation createReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
	public List<Reservation> getReservationsForHotel(Long hotelId){
		return reservationRepository.findByHotelId(hotelId);
	}
}
