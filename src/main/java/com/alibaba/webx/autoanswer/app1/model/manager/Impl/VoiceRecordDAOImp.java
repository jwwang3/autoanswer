package com.alibaba.webx.autoanswer.app1.model.manager.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.opensearch.CloudsearchClient;
import com.aliyun.opensearch.CloudsearchSearch;
import com.aliyun.opensearch.object.KeyTypeEnum;
import com.google.common.collect.Lists;

public class VoiceRecordDAOImp implements VoiceRecordOpenSeDAO {
	
	private static final String OPENSEARCH_APP_NAME = "AutoAnswer_OpenSE";
	private static final String ALIYUN_ACCESS_KEY = "02tHrZPmtBEzEWqY";
	private static final String ALIYUN_SECRET = "eXmNTOctyDlprsGTYy0gXQgexWZNI0";
	private static final String OPENSEARCH_HOST = "http://opensearch-cn-hangzhou.aliyuncs.com";
	
	@Override
	public List<String> queryModelIdByText(String voiceTextFrag) {
		Map<String,Object> opts = new HashMap<String,Object>();
		List<String> modelIds = Lists.newArrayList();
		CloudsearchClient client;
		try {
			client = new CloudsearchClient(ALIYUN_ACCESS_KEY, ALIYUN_SECRET, OPENSEARCH_HOST, opts, KeyTypeEnum.ALIYUN);
			CloudsearchSearch search = new CloudsearchSearch(client);
			search.setFormat("json");
			search.addIndex(OPENSEARCH_APP_NAME);
			search.setQueryString("voice_text:'" + voiceTextFrag + "'");
			
			JSONObject queryResult = (JSONObject) JSON.parse(search.search());
			JSONArray voiceRecordArray = JSON.parseArray(((JSONObject)JSON.parse(queryResult.getString("result"))).getString("items"));
			//System.out.println("### queryDO = " + voiceRecordArray);
			if(voiceRecordArray != null) {
				for(Object voiceRecord : voiceRecordArray) {
					modelIds.add(((JSONObject)voiceRecord).getString("model_id"));
				}
			} 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return modelIds;
	}

}
