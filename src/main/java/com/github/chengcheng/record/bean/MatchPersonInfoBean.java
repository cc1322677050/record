package com.github.chengcheng.record.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MatchPersonInfoBean {
    private String PersonCode;
    private String PersonName;
    private int Gender;
    private String CardID;
    private String IdentityNo;
}