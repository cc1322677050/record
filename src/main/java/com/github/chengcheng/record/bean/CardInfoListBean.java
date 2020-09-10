package com.github.chengcheng.record.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CardInfoListBean {
    private Long Id;
    private Long Timestamp;
    private Long CapSrc;
    private Long CardType;
    private String CardID;
    private Long CardStatus;
    private String Name;
    private Long Gender;
    private Long Ethnicity;
    private String Birthday;
    private String ResidentialAddress;
    private String IdentityNo;
    private String IssuingAuthority;
    private String IssuingDate;
    private String ValidDateStart;
    private String ValidDateEnd;
    private String IDImage;
}
