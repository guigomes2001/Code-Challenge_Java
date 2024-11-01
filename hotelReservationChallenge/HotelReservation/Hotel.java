package com.hotelReservationChallenge.HotelReservation;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int stars;
	private int totalRooms;
	
	@ElementCollection
	private List<String> roomTypes;
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id=id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	
	public int getStars() {return stars;}
	public void setStars(int stars) {this.stars=stars;}
	
	public int getTotalRooms() {return totalRooms;}
	public void setTotalRooms(int totalRooms) {this.totalRooms=totalRooms;}
	
	public List<String> getRoomTypes() {return roomTypes;}
	public void setRoomTypes(List<String> roomTypes) {this.roomTypes=roomTypes;}
}
