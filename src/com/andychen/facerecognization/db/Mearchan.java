package com.andychen.facerecognization.db;

import android.graphics.Bitmap;

public class Mearchan {
	public static final String KEY = "MEARCHAN";
	String Id;// user.mearchanId
	String loginName;// ����
	String mobile;// ��¼�ֻ���
	String[] bitMapStatus;
	String[] bitMapId;// ͼƬid
	// Bitmap[] bitMap;// ͼƬ
	String name;// ����
	String IdCard;// ���֤
	String business_name;// ��������
	String business_scope;// ��Ӫ��Χ
	String business_scopeId;// ��Ӫ��ΧID
	String business_address;// ��Ӫ��ַ
	String business_phone;// ����绰
	String mcc_name;// ������
	String mcc_crad;// ���п�
	String mcc_bank;// ֧��
	String mcc_bankCode;// ֧�д���
	static Mearchan mearchan;

	private Mearchan() {

	}

	public void setBitMapStatus(String[] bitMapStatus) {

		this.bitMapStatus = bitMapStatus;
	}

	public String[] getBitMapStatus() {
		if (bitMapStatus == null) {
			bitMapStatus = new String[6];
		}
		return bitMapStatus;
	}

	public static void clean() {
		mearchan = null;
	}


	public static Mearchan getMearchan() {
		if (mearchan == null) {
			mearchan = new Mearchan();
		}
		return mearchan;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBusiness_scopeId() {
		return business_scopeId;
	}

	public void setBusiness_scopeId(String business_scopeId) {
		this.business_scopeId = business_scopeId;
	}

	public String[] getBitMapId() {
		if (bitMapId == null) {
			bitMapId = new String[6];
		}
		return bitMapId;
	}

	public void setBitMapId(String[] bitMapId) {
		this.bitMapId = bitMapId;
	}

	// public Bitmap[] getBitMap() {
	// return bitMap;
	// }
	//
	// public void setBitMap(Bitmap[] bitMap) {
	// this.bitMap = bitMap;
	// }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return IdCard;
	}

	public void setIdCard(String idCard) {
		IdCard = idCard;
	}

	public String getBusiness_name() {
		return business_name;
	}

	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}

	public String getBusiness_scope() {
		return business_scope;
	}

	public void setBusiness_scope(String business_scope) {
		this.business_scope = business_scope;
	}

	public String getBusiness_address() {
		return business_address;
	}

	public void setBusiness_address(String business_address) {
		this.business_address = business_address;
	}

	public String getBusiness_phone() {
		return business_phone;
	}

	public void setBusiness_phone(String business_phone) {
		this.business_phone = business_phone;
	}


	public String getMcc_name() {
		return mcc_name;
	}

	public void setMcc_name(String mcc_name) {
		this.mcc_name = mcc_name;
	}

	public String getMcc_crad() {
		return mcc_crad;
	}

	public void setMcc_crad(String mcc_crad) {
		this.mcc_crad = mcc_crad;
	}

	public String getMcc_bank() {
		return mcc_bank;
	}

	public void setMcc_bank(String mcc_bank) {
		this.mcc_bank = mcc_bank;
	}

	public String getMcc_bankCode() {
		return mcc_bankCode;
	}

	public void setMcc_bankCode(String mcc_bankCode) {
		this.mcc_bankCode = mcc_bankCode;
	}


}
