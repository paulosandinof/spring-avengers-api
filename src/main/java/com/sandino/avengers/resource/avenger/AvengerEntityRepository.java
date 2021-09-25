package com.sandino.avengers.resource.avenger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvengerEntityRepository extends JpaRepository<AvengerEntity, Long> {
}
