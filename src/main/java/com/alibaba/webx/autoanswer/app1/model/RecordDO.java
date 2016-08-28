package com.alibaba.webx.autoanswer.app1.model;

import java.util.Date;


/**
 * ¼����¼
 * @author xuzhen.qxz
 *
 */
public class RecordDO {
	
	/**
	 * ����
	 */
	private Long id;
	/**
	 * ����ʱ��
	 */
	private Date gmtCreate;
	
	/**
	 * �޸�ʱ��
	 */
	private Date gmtModified;
	
	/**
	 * ����ʱ��
	 */
	private Date callTime;
	

	/**
	 * �����˺���
	 */
	private String callingNumber;
	
	/**
	 * �����˺���
	 */
	private String calledNumber;
	
	/**
	 * �ı�����
	 */
	private String voiceText;
	
	/**
	 * ¼���ļ���ַ
	 */
	private String voiceFileUrl;
	
	/**
	 * ����ID
	 */
	private String modelId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Date getCallTime() {
		return callTime;
	}

	public void setCallTime(Date callTime) {
		this.callTime = callTime;
	}

	public String getCallingNumber() {
		return callingNumber;
	}

	public void setCallingNumber(String callingNumber) {
		this.callingNumber = callingNumber;
	}

	public String getCalledNumber() {
		return calledNumber;
	}

	public void setCalledNumber(String calledNumber) {
		this.calledNumber = calledNumber;
	}

	public String getVoiceText() {
		return voiceText;
	}

	public void setVoiceText(String voiceText) {
		this.voiceText = voiceText;
	}

	public String getVoiceFileUrl() {
		return voiceFileUrl;
	}

	public void setVoiceFileUrl(String voiceFileUrl) {
		this.voiceFileUrl = voiceFileUrl;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	
	
}
