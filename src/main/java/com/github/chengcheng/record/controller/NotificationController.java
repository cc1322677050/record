package com.github.chengcheng.record.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.chengcheng.record.bean.RecordBean;
import com.github.chengcheng.record.server.WebSocketServer;
import com.github.chengcheng.record.service.CardInfoListServiceImpl;
import com.github.chengcheng.record.service.FaceInfoListServiceImpl;
import com.github.chengcheng.record.service.GateInfoListServiceImpl;
import com.github.chengcheng.record.service.LibMatInfoListServiceImpl;
import com.github.chengcheng.record.service.RecordServiceImpl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    @Autowired
    private WebSocketServer webSocketServer;
    @Autowired
    private FaceInfoListServiceImpl faceInfoListService;
    @Autowired
    private CardInfoListServiceImpl cardInfoListService;
    @Autowired
    private GateInfoListServiceImpl gateInfoListService;
    @Autowired
    private LibMatInfoListServiceImpl libMatInfoListService;
    @Autowired
    private RecordServiceImpl recordService;

    public NotificationController() {
    }

    @PostMapping({"/LAPI/V1.0/System/Event/Notification/PersonVerification"})
    public JSON getNotification(@RequestBody String params) throws IOException {
        JSONObject jsonObject = JSONObject.parseObject(params);
        RecordBean bean = (RecordBean) JSONObject.toJavaObject(jsonObject, RecordBean.class);
//        this.faceInfoListService.insert(bean.getFaceInfoList());
//        this.cardInfoListService.insert(bean.getCardInfoList());
//        this.gateInfoListService.insert(bean.getGateInfoList());
//        this.recordService.insert(bean);
        this.libMatInfoListService.insert(bean.getLibMatInfoList(), bean.getTimestamp());
        this.webSocketServer.sendAll(params);
        DateFormat formatUpperCase = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = formatUpperCase.format(new java.util.Date());
        return JSONUtil.parse("{\n" +
                "  \"Response\": {\n" +
                "    \"ResponseURL\": \"/LAPI/V1.0/PACS/Controller/Event/Notifications\",\n" +
                "    \"StatusCode\": 0,\n" +
                "    \"StatusString\": \"Succeed\",\n" +
                "    \"Data\": {\n" +
                "      \"RecordID\": " + bean.getSeq() + ",\n" +
                "      \"Time\": \"" + dateTime + "\"\n" +
                "    }\n" +
                "  }\n" +
                "}");
    }
}
