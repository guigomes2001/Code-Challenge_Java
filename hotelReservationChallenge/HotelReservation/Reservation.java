package com.hotelReservationChallenge.HotelReservation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long hotelId;
	private String roomType;
	private int numberOfRooms;
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id=id;}
	
	public Long getHotelId() {return hotelId;}
	public void setHotelId(Long hotelId) {this.hotelId=hotelId;}
	
	public String getRoomType() {return roomType;}
	public void setRoomType(String roomType) {this.roomType=roomType;}
	
	public int getNumberOfRooms() {return numberOfRooms;}
	public void setNumberOfRooms(int numberOfRooms) {this.numberOfRooms=numberOfRooms;}
	
}
