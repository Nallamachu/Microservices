package com.cf.aum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cf.aum.bean.Asset;

@Repository
public interface AssetsDao extends JpaRepository<Asset, Long> {

	List<Asset> findByDiscretionary(Long type);

	@Query(value="from Asset where year between :cicleYear and :currentYear")
	List<Asset> findByYearCicle(@Param("cicleYear") Long cicleYear, @Param("currentYear") Long currentYear);

}
