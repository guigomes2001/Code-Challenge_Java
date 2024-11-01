package com.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.ReservationService;
import com.hotelReservationChallenge.HotelReservation.Reservation;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

	private ReservationService reservationService;
	
	@PostMapping
	public Reservation createReservation(@RequestBody Reservation reservation) {
		return reservationService.createReservation(reservation);
	}
	
	@GetMapping("/hotels/{hotelsId}") 
	public List<Reservation> getReservationsForHotel(Long hotelId){
		return reservationService.getReservationsForHotel(hotelId);
	}
}
