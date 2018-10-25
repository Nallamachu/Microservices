package com.cf.firm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cf.firm.bean.Firm;

@Repository
public interface FirmDao extends JpaRepository<Firm, Long> {

	@Query(value="from Firm where year between :cicleYear and :currentYear")
	List<Firm> findByYearCicle(@Param("cicleYear") int cicleYear, @Param("currentYear") int currentYear);

}
