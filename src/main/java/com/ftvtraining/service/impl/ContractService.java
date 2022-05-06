package com.ftvtraining.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.ftvtraining.builder.ContractSearchBuilder;
import com.ftvtraining.converter.ContractConverter;
import com.ftvtraining.dto.ContractDto;
import com.ftvtraining.dto.ContractSearchDto;
import com.ftvtraining.enity.ContractEntity;

import com.ftvtraining.repository.ContractRepository;
import com.ftvtraining.service.IContractService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ContractService implements IContractService {
    private final ContractRepository repository;
    private final ContractConverter converter;


    @Autowired
    public ContractService(ContractRepository repository, ContractConverter converter) {
        this.repository = repository;
        this.converter = converter;

    }

    @Override
    public Page<ContractEntity> listByPage(int pageNumber ,int pageSize, String sortField, String sortDir, String keyword) {
        Pageable pageable;
        if ( sortDir != null && sortField != null){
            Sort sort = Sort.by(sortField);
            sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
            pageable = PageRequest.of(pageNumber-1,pageSize,sort);
        }
        pageable = PageRequest.of(pageNumber-1,pageSize);
        if (keyword != null){
            return repository.findAll(keyword,pageable);
        }
        return repository.findAll(pageable);
    }

    @Override
    public List<ContractDto> findAll() {
        List<ContractEntity> contactEntities = repository.findAll();
        List<ContractDto> contractDtos = new ArrayList<>();
        contactEntities.forEach( contact ->{
            ContractDto contractDto = converter.convertToDto(contact);
            contractDtos.add(contractDto);
        });

        return contractDtos;
    }

    @Override
    public List<ContractDto> findByCondition(ContractSearchDto contractDto,Pageable pageable ) {

        ContractSearchBuilder builder = initContractBuilder(contractDto);
        List<ContractEntity> contractEntities = repository.findByCondition(builder,pageable);
        List<ContractDto > contractDtos = new ArrayList<>();
        contractEntities.forEach(contractEntity -> {
            ContractDto dto = converter.convertToDto( contractEntity);
            contractDtos.add(dto);
        });
        return contractDtos;

    }

    @Override
    public int count(ContractSearchDto contractSearchDto) {
        ContractSearchBuilder builder = initContractBuilder(contractSearchDto);
        return repository.count(builder).intValue();
    }

    @Override
    public Object findAllByProc(ContractSearchDto contractDto) throws JsonProcessingException {

        return  repository.findAllByProc(contractDto);
    }

    @Override
    @Transactional
    public ContractEntity save(ContractEntity entity)  {
        return repository.save(entity);
    }

    @Override

    public ContractDto findById(Integer id) throws NotFoundException {
        ContractEntity contractEntity = Optional.ofNullable(repository.findById(id).get())
                .orElseThrow(() -> new NotFoundException("Customer not found !"));
        ContractDto contractDto = converter.convertToDto(contractEntity);
        return contractDto;
    }

    @Override
    @Transactional
    public void deleteContract(List<Integer> ids) throws NotFoundException {
        long count = repository.countByMaHDIn(ids);
        if (ids.size() != count) {
            throw new NotFoundException("Building not found !");
        }
        repository.deleteByMaHDIn(ids);
    }

    @Override
    public void delete(Integer id)  {
        repository.deleteById(id);
    }


    private ContractSearchBuilder initContractBuilder(ContractSearchDto contractDto){
        ContractSearchBuilder builder = new ContractSearchBuilder.Builder()
                .setMa_dot_chien_khai(contractDto.getMaDotTrienKhai())
                .setMa_ncc(contractDto.getMaNcc())
                .setNguoi_tao(contractDto.getNguoiTao())
                .setNgay_tao(contractDto.getNgayTao())
                .setNgay_ky(contractDto.getNgayKy())
                .setSo_hop_dong(contractDto.getSoHopDong())
                .setThoi_han(contractDto.getThoiHan())
                .setLoai_hop_dong(contractDto.getLoaiHD())
                .setMa_chu_truong(contractDto.getMaChuTruong())
                .setMa_kenh_truyen(contractDto.getMaKenhTruyen())
                .setSize(contractDto.getSize())
                .setPage(contractDto.getPage())
                .build();
        return  builder;

    }


}
