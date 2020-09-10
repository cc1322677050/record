package com.github.chengcheng.record.service;

import com.github.chengcheng.record.bean.RecordBean;
import com.github.chengcheng.record.bo.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class RecordServiceImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(RecordBean recordBean) {
        String sql = "insert into record(Reference,Seq,DeviceCode,`Timestamp`,NotificationType) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, recordBean.getReference(), recordBean.getSeq(), recordBean.getDeviceCode(), recordBean.getTimestamp(), recordBean.getNotificationType());
    }


    public PageView getRecordList(String name, Long startTime, Long endTime, Integer pageNum, Integer pageSize) {
        StringBuilder sql = new StringBuilder();
        StringBuilder count = new StringBuilder();
        count.append("SELECT COUNT(cpi.t_id) FROM `CtrlLibMatInfo` cpi where 1=1 ");
        sql.append("SELECT * FROM CtrlLibMatInfo cpi where 1=1 ");
        if (!StringUtils.isEmpty(name)) {
            sql.append(" and  cpi.PersonName= \"" + name+"\"");
            count.append(" and  cpi.PersonName= \"" + name+"\"");
        }
        if (!StringUtils.isEmpty(startTime)) {
            sql.append("  and cpi.`Timestamp` > " + startTime);
            count.append(" and cpi.`Timestamp`>  " + startTime);
        }
        if (!StringUtils.isEmpty(endTime)) {
            sql.append("  and cpi.`Timestamp` < " + endTime);
            count.append("  and cpi.`Timestamp` < " + endTime);
        }
        if (pageNum<=1){
            sql.append(" LIMIT " + new Integer(0) + " , " + pageSize);
        }else {
            sql.append(" LIMIT " + new Integer((pageNum-1)*pageSize) + " , " + pageSize);
        }
        Integer total=jdbcTemplate.queryForObject(count.toString(),Integer.class);
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql.toString());
        PageView pageView=new PageView(pageNum,pageSize,total,maps);
        return pageView;
    }
}
