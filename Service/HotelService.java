package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelReservationChallenge.HotelReservation.Hotel;
import com.hotelReservationChallenge.HotelReservation.HotelRepository;
import com.hotelReservationChallenge.HotelReservation.Reservation;
import com.hotelReservationChallenge.HotelReservation.ReservationRepository;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	//Método para buscar todos os hotéis
	public List<Hotel> getAllHotel(){
		return hotelRepository.findAll();
	}
	
	//Método para buscar hotel por ID
	public Hotel getHotel(Long id){
		return hotelRepository.findById(id).orElse(null);
	}
	
	//Método para salvar um novo hotel
	public Hotel createHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	
	//Método para atualizar um hotel existente
	public Hotel updateHotel(Long id, Hotel hotelDetails) {
		Hotel hotel = getHotel(id);
		
		if(hotel != null) {
			hotel.setName(hotelDetails.getName());
			hotel.setRoomTypes(hotelDetails.getRoomTypes());
			hotel.setStars(hotelDetails.getStars());
			hotel.setTotalRooms(hotelDetails.getTotalRooms());
			
			return hotelRepository.save(hotelDetails);
		}
		return null;
	}
	
	//Método para deletar um hotel existente
	public void deleteHotel(Long id) {
		hotelRepository.deleteById(id);
	}
	
	//Método para checar se existe reserva disponível
	  public boolean checkAvailability(Long hotelId, String roomType, int requestedRooms) {
	        Hotel hotel = getHotel(hotelId);
	        if (hotel != null && hotel.getRoomTypes().contains(roomType)) {
	            int reservedRooms = reservationRepository.findByHotelId(hotelId).stream()
	                    .filter(reservation -> reservation.getRoomType().equals(roomType))
	                    .mapToInt(Reservation::getNumberOfRooms)
	                    .sum();
	            return (hotel.getTotalRooms() - reservedRooms) >= requestedRooms;
	        }
	        return false;
	    }
}
