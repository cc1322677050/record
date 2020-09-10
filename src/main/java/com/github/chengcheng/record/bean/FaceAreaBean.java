package com.github.chengcheng.record.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FaceAreaBean   {
    /**
     * LeftTopX : 4194
     * LeftTopY : 6692
     * RightBottomX : 7694
     * RightBottomY : 8572
     */

    private int LeftTopX;
    private int LeftTopY;
    private int RightBottomX;
    private int RightBottomY;
}