package com.github.chengcheng.record.service;

import com.github.chengcheng.record.bean.FaceInfoListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FaceInfoListServiceImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(List<FaceInfoListBean> listBeans) {
        String sql = "insert into faceInfo(`id`,`Timestamp`,CapSrc,Temperature,MaskFlag,PanoImage_Name,PanoImage_Size,PanoImage_Data,FaceImage_Name,FaceImage_Size,FaceImage_Data,FaceArea_LeftTopX,FaceArea_LeftTopY,FaceArea_RightBottomX,FaceArea_RightBottomY) values " +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        List<Object[]> arrayList=new ArrayList<>();
        for (FaceInfoListBean item : listBeans) {
            Object[] values = new Object[]{
                    item.getID(), item.getTimestamp(), item.getCapSrc(), item.getTemperature(),
                    item.getMaskFlag(),
                    item.getPanoImage().getName(), item.getPanoImage().getSize(), item.getPanoImage().getData(),
                    item.getFaceImage().getName(), item.getFaceImage().getSize(), item.getFaceImage().getData(),
                    item.getFaceArea().getLeftTopX(), item.getFaceArea().getLeftTopY(),item.getFaceArea().getRightBottomX(),item.getFaceArea().getRightBottomY()
            };
            arrayList.add(values);
        }
        if (arrayList.size()>0){
            int[] an=jdbcTemplate.batchUpdate(sql,arrayList);
        }
    }
}
