package com.github.chengcheng.record.service;

import com.github.chengcheng.record.bean.CardInfoListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardInfoListServiceImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(List<CardInfoListBean> listBeans) {
        String sql = "insert into CardInfo(`id`,`Timestamp`,CardType,CardID,CardStatus,`Name`,Gender,Ethnicity,Birthday,ResidentialAddress,IdentityNo,IssuingAuthority,IssuingDate,ValidDateStart,ValidDateEnd,IDImage) values " +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        List<Object[]> arrayList=new ArrayList<>();
        for (CardInfoListBean item : listBeans) {
            Object[] values = new Object[]{
                    item.getId(), item.getTimestamp(), item.getCardType(), item.getCardID(),
                    item.getCardStatus(),item.getName(),item.getGender(),item.getEthnicity(),item.getBirthday(),item.getResidentialAddress(),
                    item.getIdentityNo(),item.getIssuingAuthority(),item.getIssuingDate(),item.getValidDateStart(),item.getValidDateEnd(),item.getIDImage()
            };
            arrayList.add(values);
        }
        if (arrayList.size()>0){
            int[] an=jdbcTemplate.batchUpdate(sql,arrayList);
        }
    }
}
