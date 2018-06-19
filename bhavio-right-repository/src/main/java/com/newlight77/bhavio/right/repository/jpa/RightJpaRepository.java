package com.newlight77.bhavio.right.repository.jpa;

import com.newlight77.bhavio.right.entity.mongo.RightMongoEntity;
import org.springframework.data.repository.CrudRepository;

public interface RightJpaRepository extends CrudRepository<RightMongoEntity, String> {

  Iterable<RightMongoEntity> findByPrimaryAndSecondary(String primary, String secondary);
}
