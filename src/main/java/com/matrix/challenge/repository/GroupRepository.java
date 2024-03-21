package com.matrix.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.matrix.challenge.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer>{

}
