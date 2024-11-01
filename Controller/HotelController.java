package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Service.HotelService;
import com.hotelReservationChallenge.HotelReservation.Hotel;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@GetMapping
	public List<Hotel> getAllHotels(){
		return hotelService.getAllHotel();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable Long id){
		Hotel hotel = hotelService.getHotel(id);
		return hotel != null ? ResponseEntity.ok(hotel) : ResponseEntity.notFound().build(); 
	}
	
	@PostMapping
	public Hotel createHotel(@RequestBody Hotel hotel) {
		return hotelService.createHotel(hotel);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody Hotel hotelDetails) {
		Hotel updateHotel = hotelService.updateHotel(id, hotelDetails);
		return updateHotel != null ? ResponseEntity.ok(updateHotel) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteHotel(@PathVariable Long id){
		hotelService.deleteHotel(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/{hotelId}/checkAvailability")
	public ResponseEntity<Boolean> checkAvailability(@PathVariable Long hotelId, @RequestParam String roomType, @RequestParam int requestedRooms){
		boolean avaible = hotelService.checkAvailability(hotelId, roomType, requestedRooms);
		return ResponseEntity.ok(avaible);
	}
	
}
