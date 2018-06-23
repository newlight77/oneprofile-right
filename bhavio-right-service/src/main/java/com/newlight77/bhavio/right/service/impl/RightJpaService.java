package com.newlight77.bhavio.right.service.impl;


import com.newlight77.bhavio.right.entity.mongo.RightMongoEntity;
import com.newlight77.bhavio.right.model.Right;
import com.newlight77.bhavio.right.model.TemporaryRight;
import com.newlight77.bhavio.right.repository.jpa.RightJpaRepository;
import com.newlight77.bhavio.right.service.RightFilter;
import com.newlight77.bhavio.right.service.RightService;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class RightJpaService implements RightService {

  private RightJpaRepository rightRepository;

  public RightJpaService(RightJpaRepository authorizationRepository) {
    this.rightRepository = authorizationRepository;
  }

  public void addRight(String primary, String secondary, Set<Right> rights, Set<TemporaryRight> tempRights) {
    RightMongoEntity entity = RightMongoEntity.builder()
        .modificationDate(Instant.now())
        .primary(primary)
        .secondary(secondary)
        .rights(rights)
        .tempRights(tempRights)
        .build();
    rightRepository.save(entity);
  }

  public boolean hasRight(RightFilter filter) {
    Set<Right> rights = new HashSet<>();
    Iterable<RightMongoEntity> entities = rightRepository.findByPrimaryAndSecondary(filter.getPrimary(), filter.getSecondary());
    entities.forEach(entity -> {
      rights.addAll(entity.getRights());
    });
    rights.removeAll(filter.getRights());
    return !rights.isEmpty();
  }
}