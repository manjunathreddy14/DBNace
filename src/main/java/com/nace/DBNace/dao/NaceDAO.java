package com.nace.DBNace.dao;

import com.nace.DBNace.entity.NaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaceDAO extends JpaRepository<NaceEntity, Long> {
}
