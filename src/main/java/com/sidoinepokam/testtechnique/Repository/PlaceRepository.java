package com.sidoinepokam.testtechnique.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sidoinepokam.testtechnique.Model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>{

}
