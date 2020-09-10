package com.github.chengcheng.record.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class RecordBean{
    private String Reference;
    private int Seq;
    private String DeviceCode;
    private int Timestamp;
    private int NotificationType;
    private int FaceInfoNum;
    private int CardInfoNum;
    private int GateInfoNum;
    private int LibMatInfoNum;
    private List<FaceInfoListBean> FaceInfoList;
    private List<CardInfoListBean> CardInfoList;
    private List<GateInfoListBean> GateInfoList;
    private List<LibMatInfoListBean> LibMatInfoList;
}
