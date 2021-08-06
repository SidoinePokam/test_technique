package com.sidoinepokam.testtechnique.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sidoinepokam.testtechnique.Exception.PlaceNotFoundException;
import com.sidoinepokam.testtechnique.Model.Place;
import com.sidoinepokam.testtechnique.Repository.PlaceRepository;

@RestController
@RequestMapping("/api/v1")
public class PlaceController {

	@Autowired
	private PlaceRepository placeRepository;
	
	//get all places
	@GetMapping("/places")
	public List<Place> getAllPlaces() {
		return placeRepository.findAll();
	}
	
	//get place by id
	@GetMapping("/places/{id}")
	public ResponseEntity<Place> getPlaceById(@PathVariable(name = "id") long placeId) throws PlaceNotFoundException{
		Place place = placeRepository.findById(placeId).orElseThrow(() ->new PlaceNotFoundException("Place not found for this id : " + placeId));
		
		return ResponseEntity.ok().body(place);
	}
	
	//create place
	@PostMapping("/places")
	public Place createPlace(@Validated @RequestBody Place place) {
		place.setCreatedAt(new Date());
		return placeRepository.save(place);
	}
	
	
	//upadte place
	@PutMapping("/places/{id}")
	public ResponseEntity<Place> updatePlace(@PathVariable(name = "id") long placeId, @RequestBody Place placeDetails) throws PlaceNotFoundException{
		Place place = placeRepository.findById(placeId).orElseThrow(() ->new PlaceNotFoundException("Place not found for this id : " + placeId));
		
		place.setName(placeDetails.getName());
		place.setCity(placeDetails.getCity());
		place.setState(placeDetails.getState());
		place.setUpdatedAt(new Date());
		placeRepository.save(place);
		return ResponseEntity.ok().body(place);
	}
	
	
	//delete place
	@DeleteMapping("/places/{id}")
	public ResponseEntity<Place> deletePlace(@PathVariable(name = "id") long placeId) throws PlaceNotFoundException {
		placeRepository.findById(placeId).orElseThrow(() ->new PlaceNotFoundException("Place not found for this id : " + placeId));
		
		placeRepository.deleteById(placeId);
		return ResponseEntity.ok().build();
	}
	
}
