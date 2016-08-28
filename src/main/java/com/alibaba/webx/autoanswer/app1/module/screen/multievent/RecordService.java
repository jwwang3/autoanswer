/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.webx.autoanswer.app1.module.screen.multievent;

import com.alibaba.webx.autoanswer.app1.common.PaginationResult;
import com.alibaba.webx.autoanswer.app1.model.RecordDO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ��RecordService.java��ʵ��������TODO ��ʵ������ 
 * @author xuzhen.qxz 2016��7��24�� ����10:17:15
 */
public class RecordService {

    public PaginationResult<List<RecordDO>> doGetRecordList(){
        PaginationResult<List<RecordDO>> result = new PaginationResult<List<RecordDO>>();
        List<RecordDO> list = new ArrayList<RecordDO>();
        for(int i = 0; i < 10; i++){
            RecordDO recordDO = new RecordDO();
            recordDO.setId(Long.valueOf(i));
            recordDO.setGmtCreate(new Date());
            recordDO.setModelId("modelId");
            recordDO.setNumberCaller("1770651991"+ i);
            recordDO.setNumberCallee("1709804010"+ i);
            recordDO.setFileName("http://autoanswer.oss-cn-shanghai.aliyuncs.com/Freeswitch_RU_7e515b72-94db-4869-8fae-e75c9ecda2fa_record.wav");
            recordDO.setTextPath("http://www.test.com");
            list.add(recordDO);
        }
        result.setData(list);
        result.setSuccess(true);
        result.setTotal(10);
        return result;
    }
    
    public String doGetFullText(){
        return "���ã������ǲ������磬������ʲô���԰�����\n"
                + "�����һ���ҵĿ�ݣ��ܶ����˶�û�и����͵�\n"
                + "�鷳���ṩһ���˵���\n"
                + "9823123412340\n"
                + "�õģ�����߰�����һ��\n";
    }
    
    public String doGetVoicePath(){
        return "http://autoanswer.oss-cn-shanghai.aliyuncs.com/Freeswitch_RU_7e515b72-94db-4869-8fae-e75c9ecda2fa_record.wav";
    }
}
