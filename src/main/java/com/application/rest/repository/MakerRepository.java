package com.application.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.application.rest.entities.Maker;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends CrudRepository<Maker, Long> {

}
