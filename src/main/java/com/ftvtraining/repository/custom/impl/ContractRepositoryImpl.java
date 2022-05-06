package com.ftvtraining.repository.custom.impl;

import com.ftvtraining.builder.ContractSearchBuilder;
import com.ftvtraining.enity.ContractEntity;
import com.ftvtraining.repository.custom.ContractRepositoryCustom;


import org.apache.commons.lang.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.Field;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<ContractEntity> findByCondition(ContractSearchBuilder builder , Pageable pageable) {
      try{
          StringBuilder sql = new StringBuilder("SELECT * FROM dm_hopdong hd where 1 = 1 ");
          createWhereClausePart1(builder , sql);
          createWhereClausePart2(builder , sql);
          Query query = entityManager.createNativeQuery(sql.toString(),ContractEntity.class);
          System.out.println(" sql : "+sql.toString());

          if (pageable != null){
              query.setFirstResult((int) pageable.getOffset());
              query.setMaxResults(pageable.getPageSize());
          }
          return query.getResultList();
      }catch (Exception e){
          System.out.println(e);
      }
      return  new ArrayList<>();

    }

    @Override
    public Long count(ContractSearchBuilder builder) {
       try{
           StringBuilder sql = new StringBuilder("SELECT * FROM dm_hopdong hd where 1 = 1 ");
           createWhereClausePart1(builder , sql);
           createWhereClausePart2(builder , sql);
           Query query = entityManager.createNativeQuery(sql.toString());
           List<Integer> resultList = query.getResultList();
           if(resultList.size() != 0) {
               return Long.parseLong(String.valueOf(resultList.size()));
           } else {
               return 0L;
           }
       }catch (Exception e){
           System.out.println(e);
       }
        return null;
    }

    private void createWhereClausePart1(ContractSearchBuilder builder, StringBuilder sql) {

        try{
            Field[] fields = builder.getClass().getDeclaredFields();
            for (Field field : fields){
                field.setAccessible(true);
                String name = field.getName();
                Object objectValue = field.get(builder);
                if ( !name.equals("ngay_tao") && !name.equals("ngay_ky")){
                    if (field.getType().equals(String.class)){
                        String value = (String) objectValue;
                        if (StringUtils.isNotBlank(value)){
                            sql.append(" And hd."+name+ " LIKE '%" + objectValue + "%'");
                        }
                    }else if (field.getType().equals(Integer.class) || field.getType().equals(Double.class)) {
                        if (objectValue != null) {
                            sql.append(" AND hd." + name + " = " + objectValue + "");
                        }
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private void createWhereClausePart2(ContractSearchBuilder builder, StringBuilder sql) {

        if (StringUtils.isNotBlank(builder.getNgay_tao())){
            sql.append(" And hd.ngay_tao LIKE '%" + formatDate(builder.getNgay_tao()) + "%'");
        }
        if (StringUtils.isNotBlank(builder.getNgay_ky())){
            sql.append(" And hd.ngay_ky LIKE '%" + formatDate(builder.getNgay_ky()) + "%'");
        }

    }


    public  String formatDate(String oldDate)  {
        //2022-05-09T17:00:00.000Z
        String[] values = oldDate.split("T");
        String[] dates = values[0].split("-");
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(dates[0]), Integer.parseInt(dates[1])-1, Integer.parseInt(dates[2])+1);
        String formatted = new SimpleDateFormat("dd-MMM-yy").format(cal.getTime()).toUpperCase();
        return  formatted;
    }
}
