package com.github.chengcheng.record.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GateInfoListBean {
    private Long Id;
    private Long Timestamp;
    private Long CapSrc;
    private Long InPersonCnt;
    private Long OutPersonCnt;
}
