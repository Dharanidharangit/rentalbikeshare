package com.sampleproject.sampleproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sampleproject.sampleproject.entity.RentalEntity;
@Repository
public interface RentalRepository extends JpaRepository<RentalEntity,Long>{
	List<RentalEntity> findByUserUserid(Long userid);
	//findBy[EntityField][SubField]...
	//long deleteByUserUserId(Long userId);
	long deleteByUserUserid(Long userid);

}
