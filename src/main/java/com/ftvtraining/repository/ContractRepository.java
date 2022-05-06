package com.ftvtraining.repository;


import com.ftvtraining.enity.ContractEntity;
import com.ftvtraining.repository.custom.ContractRepositoryCustom;
import com.ftvtraining.repository.custom.ProcContractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContractRepository extends ContractRepositoryCustom, ProcContractRepository, JpaRepository<ContractEntity,Integer> {
        long countByMaHDIn(List<Integer> ids);
        void deleteByMaHDIn(List<Integer> ids);
        @Query("SELECT c FROM ContractEntity c where concat(c.maHD ,' ',c.loaiHD,' ',c.maChuTruong ,' ',c.maDotChienKhai) like %?1% ")
        Page<ContractEntity> findAll(String keyword, Pageable pageable);
}
