package com.sampleproject.sampleproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sampleproject.sampleproject.entity.BikeEntity;

@Repository
public interface BikeRepository extends JpaRepository<BikeEntity,Long>{

}
