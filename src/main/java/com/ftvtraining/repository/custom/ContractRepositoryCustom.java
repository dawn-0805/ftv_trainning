package com.ftvtraining.repository.custom;

import com.ftvtraining.builder.ContractSearchBuilder;
import com.ftvtraining.enity.ContractEntity;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ContractRepositoryCustom {
    List<ContractEntity> findByCondition(ContractSearchBuilder builder, Pageable pageable);
    Long count(ContractSearchBuilder builder);
}
