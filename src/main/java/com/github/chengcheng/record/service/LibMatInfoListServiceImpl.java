package com.github.chengcheng.record.service;

import com.github.chengcheng.record.bean.LibMatInfoListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibMatInfoListServiceImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(List<LibMatInfoListBean> listBeans,Integer timestamp) {
        String sql = "insert into CtrlLibMatInfo(`id`,`LibID`,LibType,MatchStatus,MatchPersonID,MatchFaceID,PersonName,Gender,CardID,IdentityNo,`Timestamp`) values " +
                "(?,?,?,?,?,?,?,?,?,?,?)";
        List<Object[]> arrayList=new ArrayList<>();
        for (LibMatInfoListBean item : listBeans) {
            Object[] values = new Object[]{
                    item.getID(),item.getLibID(),item.getLibType(),item.getMatchStatus(),item.getMatchPersonID(), item.getMatchFaceID(),
                    item.getMatchPersonInfo().getPersonName(),item.getMatchPersonInfo().getGender(),
                    item.getMatchPersonInfo().getCardID(),item.getMatchPersonInfo().getIdentityNo(),timestamp
            };
            arrayList.add(values);
        }
        if (arrayList.size()>0){
            int[] an=jdbcTemplate.batchUpdate(sql,arrayList);
        }
    }
}
