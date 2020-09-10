package com.github.chengcheng.record.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


@Data
@NoArgsConstructor
public class PageView {

    private Integer pageNum;
    private Integer pageSize;
    private Integer total;
    private List<Map<String, Object>> list;

    public PageView(Integer pageNum, Integer pageSize, Integer total, List<Map<String, Object>> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageView{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
