package com.sanjib.hcl.generator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepertmentRepository extends JpaRepository<DepertmentEntity, String> {

}
