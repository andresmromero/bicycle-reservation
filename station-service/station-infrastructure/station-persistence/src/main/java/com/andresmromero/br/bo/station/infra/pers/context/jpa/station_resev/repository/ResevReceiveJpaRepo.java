package com.andresmromero.br.bo.station.infra.pers.context.jpa.station_resev.repository;

import com.andresmromero.br.bo.station.infra.pers.context.jpa.station_resev.entity.ResevReceiveJpaEnt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResevReceiveJpaRepo extends JpaRepository<ResevReceiveJpaEnt, UUID> {


}
