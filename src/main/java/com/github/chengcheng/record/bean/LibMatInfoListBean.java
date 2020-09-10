package com.github.chengcheng.record.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LibMatInfoListBean   {
    /**
     * ID : 109
     * LibID : 3
     * LibType : 3
     * MatchStatus : 1
     * MatchPersonID : 4027285429
     * MatchFaceID : 4027285429
     * MatchPersonInfo : {"PersonCode":"4027285429","PersonName":"cc","Gender":0,"CardID":"","IdentityNo":""}
     */
    private int ID;
    private int LibID;
    private int LibType;
    private int MatchStatus;
    private long MatchPersonID;
    private long MatchFaceID;
    private MatchPersonInfoBean MatchPersonInfo;
}