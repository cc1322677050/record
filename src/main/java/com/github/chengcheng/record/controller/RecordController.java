package com.github.chengcheng.record.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.github.chengcheng.record.api.CommonResult;
import com.github.chengcheng.record.bo.PageView;
import com.github.chengcheng.record.service.RecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordServiceImpl recordService;

    @GetMapping
    public CommonResult<PageView> getRecordInfo(@RequestParam(value = "name",required =false) String name,
                                                @RequestParam(value = "startTime",required = false) Long startTime,
                                                @RequestParam(value = "endTime",required = false) Long endTime,
                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {

        return CommonResult.success(recordService.getRecordList(name,startTime,endTime,pageNum,pageSize));
    }


}
