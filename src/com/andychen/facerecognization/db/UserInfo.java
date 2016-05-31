package com.andychen.facerecognization.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * �û���Ϣ
 * 
 * @author paytend_liu
 * 
 */
public class UserInfo {
	/**
	 * �����û���Ϣ
	 */
	private static UserInfo mInfo;
	/**
	 * ��ʱ����
	 */
	private boolean authSettlement;
	/**
	 * ��ʱ������֤�ֻ�
	 */
	private boolean authMobile;
	/**
	 * �ķ���key
	 */
	private List<String> mFeeKeyList;
	/**
	 * �ķ���value
	 */
	private List<String> mFeeValueList;
	/**
	 * �Ƿ�֧���ķ���
	 */
	boolean support4rate = false;
	/**
	 * ��ǰ����
	 */
	int currentRate;
	/**
	 * �̻��ֻ���
	 */
	private String telNo = "";
	/**
	 * ˢ������
	 */
	private String posFee;
	/**
	 * ˢ���ⶥ
	 */
	private String posTopFee;
	/**
	 * ΢�ŷ���
	 */
	private String wxFee;
	/**
	 * ���֧������
	 */
	private String qpayFee;

	/**
	 * �Ƿ���Ҫ������Ϣ
	 */
	private boolean needUpdate;
	/**
	 * t0У������
	 */
	private String t0Name;
	/**
	 * t0У��ʡ��֤��
	 */
	private String t0CardId;
	/**
	 * t0У����
	 */
	private String t0CheckAmount;
	/**
	 * ÿ��t0���
	 */
	private String t0Amount;
	/**
	 * ÿ��t0���������
	 */
	private String t0MagenticAmount;
	/**
	 * ����ʱ��
	 */
	private int realTime;
	/**
	 * ������Կ
	 */
	private String macKey;
	/**
	 * ǩ��������
	 */
	private String merchantName;
	/**
	 * �̻��ı��
	 */
	private String merchantId;
	/**
	 * ���ÿ�ÿ�����ѽ��
	 */
	private String maxAmount;
	/**
	 * ���ÿ�ÿ�����ѽ��
	 */
	private String dayAmount;
	/**
	 * ��ǿ�ÿ�����ѽ��
	 */
	private String monthAmount;
	/**
	 * ��������
	 */
	private String bankName;
	/**
	 * �ֿ�������
	 */
	private String bankAccName;
	/**
	 * ����
	 */
	private String bankAcc;
	/**
	 * �������id
	 */
	private String lastSettle_id;
	/**
	 * ��������
	 */
	private String lastSettle_amount;
	/**
	 * ����״̬
	 */
	private String lastSettle_status;
	/**
	 * ����ʱ��
	 */
	private String lastSettle_recordTime;
	/**
	 * ԭ��
	 */
	private String lastSettle_remark;

	/**
	 * ����������
	 */
	private String agentName;
	/**
	 * �����̵�ַ
	 */
	private String agentAddress;
	/**
	 * �����̵绰
	 */
	private String agentTelNo;
	/**
	 * ��������ַ
	 */
	private String agentWebsite;
	/**
	 * ������QQ
	 */
	private String agentQQ;
	/**
	 * ҵ��Ա����
	 */
	private String oper;
	/**
	 * ҵ��Ա���
	 */
	private String operId;
	/**
	 * ҵ��Ա�绰
	 */
	private String operMobile;

	/**
	 * �ֻ���ֵʵ�ʽ��
	 */
	private String t30, t50, t100, t200, t300, t500;

	/**
	 * ˽�й��캯��
	 */
	private UserInfo() {

	}

	/**
	 * ��ȡ�û���Ϣ
	 * 
	 * @return �����û���Ϣ
	 */
	public static UserInfo getInfo() {
		if (mInfo == null) {
			mInfo = new UserInfo();
		}
		return mInfo;
	}

	/**
	 * ����û���Ϣ
	 * 
	 * @return �����û���Ϣ
	 */
	public static void ClearInfo() {

		mInfo = null;

	}

	/**
	 * ��ʱ����У���ֻ�
	 * 
	 * @return
	 */
	public boolean isAuthMobile() {
		return authMobile;
	}

	/**
	 * ��ʱ����
	 * 
	 * @return
	 */
	public boolean isAuthSettlement() {
		return authSettlement;
	}

	/**
	 * ��ʱ��������ֻ�
	 * 
	 * @param authMobile
	 */
	public void setAuthMobile(boolean authMobile) {
		this.authMobile = authMobile;
	}

	/**
	 * ��ʱ����
	 * 
	 * @param authSettlement
	 */
	public void setAuthSettlement(boolean authSettlement) {
		this.authSettlement = authSettlement;
	}

	/**
	 * ��ǰ����
	 * 
	 * @return
	 */
	public int getCurrentRate() {
		if (currentRate == 0) {
			currentRate = 1;
		}
		return currentRate;
	}

	/**
	 * ��ǰ����
	 * 
	 * @param currentRate
	 */
	public void setCurrentRate(int currentRate) {
		this.currentRate = currentRate;
	}

	/**
	 * �ķ���key
	 * 
	 * @return
	 */
	public List<String> getFeeKeyList() {
		if (mFeeKeyList == null) {
			mFeeKeyList = new ArrayList<String>();
		}
		return mFeeKeyList;
	}

	/**
	 * �ķ���key
	 * 
	 * @param mFeeKeyList
	 */
	public void setFeeKeyList(List<String> mFeeKeyList) {
		this.mFeeKeyList = mFeeKeyList;
	}

	/**
	 * �ķ���value
	 * 
	 * @return
	 */
	public List<String> getFeeValueList() {
		if (mFeeValueList == null) {
			mFeeValueList = new ArrayList<String>();
		}
		return mFeeValueList;
	}

	/**
	 * �ķ���value
	 * 
	 * @param mFeeValueList
	 */
	public void setFeeValueList(List<String> mFeeValueList) {
		this.mFeeValueList = mFeeValueList;
	}

	/**
	 * �Ƿ�֧��4����
	 * 
	 * @param support4rate
	 */
	public void setSupport4rate(boolean support4rate) {
		this.support4rate = support4rate;
	}

	/**
	 * �Ƿ�֧���ķ���
	 * 
	 * @return
	 */
	public boolean isSupport4rate() {
		return support4rate;
	}

	/**
	 * �̻��ֻ���
	 */
	public String getTelNo() {
		return telNo;
	}

	/**
	 * �̻��ֻ���
	 * 
	 * @param telNo
	 */
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	/**
	 * ˢ������
	 * 
	 * @return
	 */
	public String getPosFee() {
		return posFee;
	}

	/**
	 * ˢ������
	 * 
	 * @param posFee
	 */
	public void setPosFee(String posFee) {
		this.posFee = posFee;
	}

	/**
	 * ˢ���ⶥ
	 * 
	 * @return
	 */
	public String getPosTopFee() {
		return posTopFee;
	}

	/**
	 * ˢ���ⶥ
	 * 
	 * @param posTopFee
	 */
	public void setPosTopFee(String posTopFee) {
		this.posTopFee = posTopFee;
	}

	/**
	 * ΢��֧������
	 * 
	 * @return
	 */
	public String getWxFee() {
		return wxFee;
	}

	/**
	 * ΢��֧������
	 * 
	 * @param wxFee
	 */
	public void setWxFee(String wxFee) {
		this.wxFee = wxFee;
	}

	/**
	 * ���֧������
	 * 
	 * @return
	 */
	public String getQpayFee() {
		return qpayFee;
	}

	/**
	 * ���֧������
	 * 
	 * @param qpayFee
	 */
	public void setQpayFee(String qpayFee) {
		this.qpayFee = qpayFee;
	}

	/**
	 * �Ƿ���Ҫ������Ϣ
	 * 
	 * @return
	 */
	public boolean isNeedUpdate() {
		return needUpdate;
	}

	/**
	 * �Ƿ���Ҫ������Ϣ
	 * 
	 * @param needUpdate
	 */
	public void setNeedUpdate(boolean needUpdate) {
		this.needUpdate = needUpdate;
	}

	/**
	 * t0У����
	 * 
	 * @return
	 */
	public String getT0CheckAmount() {
		return t0CheckAmount;
	}

	/**
	 * t0У����
	 * 
	 * @param t0CheckAmount
	 */
	public void setT0CheckAmount(String t0CheckAmount) {
		this.t0CheckAmount = t0CheckAmount;
	}

	/**
	 * t0У������
	 * 
	 * @return
	 */
	public String getT0Name() {
		return t0Name;
	}

	/**
	 * t0У������
	 * 
	 * @param t0Name
	 */
	public void setT0Name(String t0Name) {
		this.t0Name = t0Name;
	}

	/**
	 * t0У�����֤��
	 * 
	 * @return
	 */
	public String getT0CardId() {
		return t0CardId;
	}

	/**
	 * t0У�����֤��
	 * 
	 * @param t0CardId
	 */
	public void setT0CardId(String t0CardId) {
		this.t0CardId = t0CardId;
	}

	/**
	 * ÿ��t0���
	 * 
	 * @return
	 */
	public String getT0Amount() {
		return t0Amount;
	}

	/**
	 * ÿ��t0���
	 * 
	 * @param t0Amount
	 */
	public void setT0Amount(String t0Amount) {
		this.t0Amount = t0Amount;
	}

	/**
	 * ÿ��t0�������
	 * 
	 * @return
	 */
	public String getT0MangenticAmount() {
		return t0MagenticAmount;
	}

	/**
	 * ÿ��t0�������
	 * 
	 * @param t0Amount
	 */
	public void setT0MangenticAmount(String t0Amount) {
		this.t0MagenticAmount = t0Amount;
	}

	/**
	 * ����ʱ��
	 * 
	 * @return
	 */
	public int getRealTime() {
		return realTime;
	}

	/**
	 * ����ʱ��
	 * 
	 * @param realTime
	 */
	public void setRealTime(int realTime) {
		this.realTime = realTime;
	}

	/**
	 * ������Կ
	 * 
	 * @return
	 */
	public String getMacKey() {
		return macKey;
	}

	/**
	 * ������Կ
	 * 
	 * @param macKey
	 */
	public void setMacKey(String macKey) {
		this.macKey = macKey;
	}

	/**
	 * ǩ��������
	 * 
	 * @return
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * ǩ��������
	 * 
	 * @param merchantName
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
	 * �û�ID
	 * 
	 * @return
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * �û�ID
	 * 
	 * @param merchantId
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * ���ÿ�ÿ�����ѽ��
	 * 
	 * @return
	 */
	public String getMaxAmount() {
		return maxAmount;
	}

	/**
	 * ���ÿ�ÿ�����ѽ��
	 * 
	 * @param maxAmount
	 */

	public void setMaxAmount(String maxAmount) {
		this.maxAmount = maxAmount;
	}

	/**
	 * ���ÿ�ÿ�����ѽ��
	 * 
	 * @return
	 */
	public String getDayAmount() {
		return dayAmount;
	}

	/**
	 * ���ÿ�ÿ�����ѽ��
	 * 
	 * @param dayAmount
	 */
	public void setDayAmount(String dayAmount) {
		this.dayAmount = dayAmount;
	}

	/**
	 * ��ǿ�ÿ�����ѽ��
	 * 
	 * @return
	 */
	public String getMonthAmount() {
		return monthAmount;
	}

	/**
	 * ��ǿ�ÿ�����ѽ��
	 * 
	 * @param monthAmount
	 */
	public void setMonthAmount(String monthAmount) {
		this.monthAmount = monthAmount;
	}

	/**
	 * ��������
	 * 
	 * @return
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * ��������
	 * 
	 * @param bankName
	 */

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * �ֿ�������
	 * 
	 * @return
	 */
	public String getBankAccName() {
		return bankAccName;
	}

	/**
	 * �ֿ�������
	 * 
	 * @param bankAccName
	 */
	public void setBankAccName(String bankAccName) {
		this.bankAccName = bankAccName;
	}

	/**
	 * ���п���
	 * 
	 * @return
	 */
	public String getBankAcc() {
		return bankAcc;
	}

	/**
	 * ���п���
	 * 
	 * @param bankAcc
	 */
	public void setBankAcc(String bankAcc) {
		this.bankAcc = bankAcc;
	}

	/**
	 * ������ID
	 * 
	 * @return
	 */
	public String getLastSettle_id() {
		return lastSettle_id;
	}

	/**
	 * ������ID
	 * 
	 * @param lastSettle_id
	 */
	public void setLastSettle_id(String lastSettle_id) {
		this.lastSettle_id = lastSettle_id;
	}

	/**
	 * ��������
	 * 
	 * @return
	 */
	public String getLastSettle_amount() {
		return lastSettle_amount;
	}

	/**
	 * ��������
	 * 
	 * @param lastSettle_amount
	 */
	public void setLastSettle_amount(String lastSettle_amount) {
		this.lastSettle_amount = lastSettle_amount;
	}

	/**
	 * ������״̬
	 * 
	 * @return
	 */
	public String getLastSettle_status() {
		return lastSettle_status;
	}

	/**
	 * ������״̬
	 * 
	 * @param lastSettle_status
	 */
	public void setLastSettle_status(String lastSettle_status) {
		this.lastSettle_status = lastSettle_status;
	}

	/**
	 * ������ʱ��
	 */
	public String getLastSettle_recordTime() {
		return lastSettle_recordTime;
	}

	/**
	 * ������ʱ��
	 * 
	 * @param lastSettle_recordTime
	 */
	public void setLastSettle_recordTime(String lastSettle_recordTime) {
		this.lastSettle_recordTime = lastSettle_recordTime;
	}

	/**
	 * ������ԭ��
	 * 
	 * @return
	 */
	public String getLastSettle_remark() {
		return lastSettle_remark;
	}

	/**
	 * ������ԭ��
	 * 
	 * @param lastSettle_remark
	 */
	public void setLastSettle_remark(String lastSettle_remark) {
		this.lastSettle_remark = lastSettle_remark;
	}

	/**
	 * �����������
	 * 
	 * @return
	 */
	public String getAgentName() {
		return agentName;
	}

	/**
	 * �����������
	 * 
	 * @param agentName
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	/**
	 * ���������ַ
	 * 
	 * @return
	 */
	public String getAgentAddress() {
		return agentAddress;
	}

	/**
	 * ���������ַ
	 * 
	 * @param agentAddress
	 */

	public void setAgentAddress(String agentAddress) {
		this.agentAddress = agentAddress;
	}

	/**
	 * ��������绰
	 * 
	 * @return
	 */
	public String getAgentTelNo() {
		return agentTelNo;
	}

	/**
	 * ��������绰
	 * 
	 * @param agentTelNo
	 */

	public void setAgentTelNo(String agentTelNo) {
		this.agentTelNo = agentTelNo;
	}

	/**
	 * ���������ַ
	 * 
	 * @return
	 */
	public String getAgentWebsite() {
		return agentWebsite;
	}

	/**
	 * ���������ַ
	 * 
	 * @param agentWebsite
	 */
	public void setAgentWebsite(String agentWebsite) {
		this.agentWebsite = agentWebsite;
	}

	/**
	 * �������QQ
	 * 
	 * @return
	 */
	public String getAgentQQ() {
		return agentQQ;
	}

	/**
	 * �������QQ
	 * 
	 * @param agentQQ
	 */
	public void setAgentQQ(String agentQQ) {
		this.agentQQ = agentQQ;
	}

	/**
	 * ҵ��Ա����
	 * 
	 * @return
	 */
	public String getOper() {
		return oper;
	}

	/**
	 * ҵ��Ա����
	 * 
	 * @param oper
	 */
	public void setOper(String oper) {
		this.oper = oper;
	}

	/**
	 * ҵ��Ա���
	 * 
	 * @return
	 */
	public String getOperId() {
		return operId;
	}

	/**
	 * ҵ��Ա���
	 * 
	 * @param operId
	 */
	public void setOperId(String operId) {
		this.operId = operId;
	}

	/**
	 * ҵ��Ա�绰
	 * 
	 * @return
	 */
	public String getOperMobile() {
		return operMobile;
	}

	/**
	 * ҵ��Ա�绰
	 * 
	 * @param operMobile
	 */
	public void setOperMobile(String operMobile) {
		this.operMobile = operMobile;
	}

	/**
	 * ʵ�ʳ�ֵ���
	 * 
	 * @return
	 */
	public String getT30() {
		return t30;
	}

	/**
	 * ʵ�ʳ�ֵ���
	 * 
	 * @param t30
	 */
	public void setT30(String t30) {
		this.t30 = t30;
	}

	/**
	 * ʵ�ʳ�ֵ���
	 * 
	 * @return
	 */
	public String getT50() {
		return t50;
	}

	/**
	 * ʵ�ʳ�ֵ���
	 * 
	 * @param t50
	 */
	public void setT50(String t50) {
		this.t50 = t50;
	}

	/**
	 * ʵ�ʳ�ֵ���
	 * 
	 * @return
	 */
	public String getT100() {
		return t100;
	}

	/**
	 * ʵ�ʳ�ֵ���
	 * 
	 * @param t100
	 */
	public void setT100(String t100) {
		this.t100 = t100;
	}

	/**
	 * ʵ�ʳ�ֵ���
	 * 
	 * @return
	 */
	public String getT200() {
		return t200;
	}

	/**
	 * ʵ�ʳ�ֵ���
	 * 
	 * @param t200
	 */
	public void setT200(String t200) {
		this.t200 = t200;
	}

	/**
	 * ʵ�ʳ�ֵ���
	 * 
	 * @return
	 */
	public String getT300() {
		return t300;
	}

	/**
	 * ʵ�ʳ�ֵ���
	 * 
	 * @param t300
	 */
	public void setT300(String t300) {
		this.t300 = t300;
	}

	/**
	 * ʵ�ʳ�ֵ���
	 * 
	 * @return
	 */
	public String getT500() {
		return t500;
	}

	/**
	 * ʵ�ʳ�ֵ���
	 * 
	 * @param t500
	 */
	public void setT500(String t500) {
		this.t500 = t500;
	}

}
