package com.github.chengcheng.record.service;

import com.github.chengcheng.record.bean.GateInfoListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GateInfoListServiceImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(List<GateInfoListBean> listBeans) {
        String sql = "insert into GateInfo(`id`,`CapSrc`,InPersonCnt,OutPersonCnt) values(?,?,?,?)";
        List<Object[]> arrayList=new ArrayList<>();
        for (GateInfoListBean item : listBeans) {
            Object[] values = new Object[]{
                    item.getId(), item.getCapSrc(), item.getInPersonCnt(), item.getOutPersonCnt()
            };
            arrayList.add(values);
        }
        if (arrayList.size()>0){
            int[] an=jdbcTemplate.batchUpdate(sql,arrayList);
        }
    }
}
