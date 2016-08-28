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
	 * ����ID
	 */
	private String modelId;
	
	/**
	 * ����ʱ��
	 */
	private Date gmtCreate;
	
	/**
	 * �����˺���
	 */
	private String numberCaller;
	
	/**
	 * �����˺���
	 */
	private String numberCallee;
	
	
	/**
	 * ¼���ļ�����
	 */
	private String fileName;
	
	
	/**
	 * �����ı���ַ
	 */
	private String textPath;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the gmtCreate
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}

	/**
	 * @param gmtCreate the startTime to set
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}


	/**
	 * @return the numberCaller
	 */
	public String getNumberCaller() {
		return numberCaller;
	}

	/**
	 * @param numberCaller the numberCaller to set
	 */
	public void setNumberCaller(String numberCaller) {
		this.numberCaller = numberCaller;
	}

	/**
	 * @return the numberCallee
	 */
	public String getNumberCallee() {
		return numberCallee;
	}

	/**
	 * @param numberCallee the numberCallee to set
	 */
	public void setNumberCallee(String numberCallee) {
		this.numberCallee = numberCallee;
	}
	
	
    public String getModelId() {
        return modelId;
    }

    
    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    
    public String getFileName() {
        return fileName;
    }

    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    

    /**
	 * @return the textPath
	 */
	public String getTextPath() {
		return textPath;
	}

	/**
	 * @param textPath the textPath to set
	 */
	public void setTextPath(String textPath) {
		this.textPath = textPath;
	}
}
