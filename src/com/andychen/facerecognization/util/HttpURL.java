package com.andychen.facerecognization.util;

/**
 * ���ʵĵ�ַ�ͽӿ�
 * 
 * @author paytend_liu
 * 
 */
public class HttpURL {
	/**
	 * ��¼���صĵ�ַ���������׽ӿڶ����ʴ˵�ַ
	 */
	private static String httpStr;

	/**
	 * ��¼���صĵ�ַ���������׽ӿڶ����ʴ˵�ַ
	 */
	public static void setHttp(String mhttp) {
		httpStr = mhttp;
	}

	/**
	 * ��¼���صĵ�ַ���������׽ӿڶ����ʴ˵�ַ
	 */
	public static String getHttp() {
		if (httpStr == null || httpStr.length() == 0) {
			return baseURLStr;
		}
		// return baseURLStr;
		return httpStr;
	}

	/**
	 * �⿨ ���ӵ�ַ
	 */
	public static String waikaHttp;

	/**
	 * ��¼���صĵ�ַ���������׽ӿڶ����ʴ˵�ַ
	 */
	public static void setWaikaHttp(String mhttp) {
		waikaHttp = mhttp;
	}

	/**
	 * ��¼���صĵ�ַ���������׽ӿڶ����ʴ˵�ַ
	 */
	public static String getWaikaHttp() {
		return waikaHttp;
	}

	/**
	 * ��¼��Կ
	 */
	public static final String MK = "2356174821BDCCAE49572909876BCBCBC";
	/**
	 * ע����Կ
	 */
	public static final String CK = "0C86F818D3D65C6E272C88C6564A9467F7945A4C5FA33267F3C7C0B7CEB9096E";
	/**
	 * ���ʵ�ip
	 */
	public final static String baseURLStr = "http://posp.paytend.com:9067";
	// ����
	// public final static String baseURLStr = "http://59.151.3.43:8078";
	// public final static String baseURLStr = "http://218.97.161.244:9062";

	// public final static String baseURLStr = "http://192.168.1.149:9001";
	/**
	 * �û���Ϣ��ط��ʵ�ip
	 */
	public final static String regbaseStr = "http://a.paytend.com";
	// ����
	// public final static String regbaseStr = "http://59.151.3.43";
	// public final static String regbaseStr = "http://192.168.1.149";
	/**
	 * ����̨ ��ӡ��ά������
	 */
	public final static String CashierStr = "https://pay.paytend.com/d/printQR";
	// ����
	//public final static String CashierStr = "http://test.paytend.com:8088/d/printQR";
	/**
	 * p2pЭ��
	 */
	public static final String p2pAgreementStr = "http://101.200.238.151:8080/m/m_register_protocol.shtml";
	// public static final String p2pAgreementStr = HttpURL.baseURLStr
	// + "/m/m_register_protocol.shtml";

	/**
	 * p2p��¼
	 */
	public static final String p2pLoginStr = HttpURL.baseURLStr
			+ "/service2/p2p/p2plogin.htm";
	// HttpURL.baseURLStr

	/**
	 * p2p��ͨ
	 */
	public final static String p2pOpen = HttpURL.baseURLStr
			+ "/service2/p2p/p2preg.htm";
	// HttpURL.baseURLStr
	/**
	 * ���ͽ���ƾ֤
	 */
	public static String sendMessageOrEmail = "/service2/sendmsg.htm";
	/**
	 * �ϴ�����ƾ֤
	 */
	public static String updateInvokePhoto = "/service2/upload_proof.htm";
	/**
	 * ��ȡ�ɳ����Ľ���
	 */
	public static String getRevokeTradeList = "/service2/gettradelist4cancel.htm";
	/**
	 * ��ʱ����
	 */
	public static final String timelySettle = "/service2/settle/authWithdraw.htm";
	/**
	 * t+0�����б�
	 */
	public static String getTzeroList = "/service2/settle/getwithdrawtradelist.htm";
	/**
	 * t+0����
	 */
	public static String getTzerocash = "/service2/settle/withdraw.htm";
	/**
	 * t+0���Ľ���ģʽ
	 */
	public static String changTzeroModel = "/service2/settle/settlemode.htm";
	/**
	 * ���T+0�Ƿ�ͨ
	 */
	public static String tzerocheck = "/service2/settle/checkorg.htm";
	/**
	 * ������ÿ��Ƿ���ȷ
	 */
	public static String checkcreditStr = "/service2/checkcreditcard.htm";
	/**
	 * ��ȡ���ջ����¼
	 */
	public static String getRepaymentToday = "/service2/getbmtradelist.htm";
	/**
	 * ��ȡ��ʷ�����¼
	 */
	public static String getRepamentHistory = "/service2/getbmhistorytradelist.htm";
	public static String getBannerImage = regbaseStr
			+ "/api/jupos/regist/getAdPhoto.html";
	/**
	 * ��ȡͷ����Ϣ
	 */
	public static String getHeader = regbaseStr
			+ "/api/jupos/regist/getUserHead.html";
	/**
	 * ת�˲�ѯ������
	 */
	public static String poundageStr = "/service2/getc2cfee.htm";
	/**
	 * ����ͼƬ
	 */
	public static String getphoto = regbaseStr + "/d/photo/";
	/**
	 * ��ȡ�̳��б�
	 */
	public static String getPosList = regbaseStr
			+ "/api/jupos/regist/getposlist.html";
	/**
	 * ��ȡ�̳��б�
	 */
	public static String getVouchersList = regbaseStr
			+ "/api/jupos/regist/get_voucher_list.html";
	/***
	 * ����pos�����¶���
	 */
	public final static String buyposStr = regbaseStr
			+ "/api/jupos/regist/order.html";
	/**
	 * ��ȡ������Ϣ
	 */
	public final static String getShareUrl = regbaseStr
			+ "/api/jupos/regist/getShareContent.html";
	/**
	 * �������ַ
	 */
	public final static String saveAddressUrl = regbaseStr
			+ "/api/jupos/regist/saveOrderAddr.html";
	/**
	 * �����֧������������
	 */
	public static String quickCheck = "/service2/qpay/getcheckdata.htm";
	/**
	 * ��ȡ��֤��
	 */
	public static String quickphone = "/service2/qpay/getmobilecheckvalue.htm";
	/**
	 * �ϴ��û���Ϣ
	 */
	public final static String updataUserstr = regbaseStr
			+ "/api/jupos/regist/updateUser.html";
	/**
	 * ��ȡ��Ϣ�б�
	 */
	public final static String getNewsList = regbaseStr
			+ "/api/jupos/regist/getNewsList.html";
	/**
	 * ��ȡ�û���Ϣ
	 */
	public final static String getUserstr = regbaseStr
			+ "/api/jupos/regist/getUser.html";
	/***
	 * ��ȡ�����б�
	 */
	public static final String getBankList = regbaseStr
			+ "/api/jupos/regist/getBankList.html";
	/**
	 * ��Ƴ�ֵ
	 */
	public static String payP2p = "/service2/p2p/p2ptopup.htm";
	/**
	 * �ϴ���Ƭ
	 */
	public final static String uploadInfo = regbaseStr
			+ "/api/jupos/regist/uploadInfo.html";
	/**
	 * ��ȡ��Ƭ
	 */
	public static final String getUserPhoto = regbaseStr
			+ "/api/jupos/regist/getUserPhoto.html";
	/**
	 * ��ѯ���
	 */
	public static String Search_balance = "/service2/getbalance.htm";
	/***
	 * ��д
	 */
	public static String writeback = "/service2/uploadicdata.htm";
	/**
	 * ��ȡ�����б�
	 */
	public static String getInvokeList = "/service2/gettradeinvokelist.htm";
	/**
	 * ������������
	 */
	public static String getInvokeDetial = "/service2/gettradeinvokedetial.htm";
	/**
	 * ��ȡ�����б�
	 */
	public static String GET_WORKFORM_RECORDS = regbaseStr
			+ "/api/jupos/workorder/query_workorder_list.html";
	/**
	 * ΢��֧��
	 */
	public static String weChatPayStr = "/service2/wx/wxpay.htm";

	/**
	 * ����
	 */
	public static String revoke = "/service2/cancel.htm";
	/**
	 * ���֧��
	 */
	public static String quickpay = "/service2/qpay/pay.htm";
	/**
	 * ˢ������
	 */
	public static String pay = "/service2/mpay.htm";
	/**
	 * ���汾����
	 */
	public static String check_version = baseURLStr
			+ "/service2/getappversion.htm";
	/**
	 * ��ȡ�󶨵�pos���б�
	 */
	public static String getDevicesList = "/service2/getdevices.htm";
	/**
	 * �޸�����
	 */
	public final static String modifypassword = baseURLStr
			+ "/service2/modifypassword.htm";
	/**
	 * ��¼�ĵ�ַ
	 */
	public final static String loginStr = baseURLStr + "/service2/login.htm";
	/**
	 * ��ȡ��������Ϣ
	 */
	public static String lastSettleStr = "/service2/getlastsettleinfo.htm";
	/**
	 * pos����¼
	 */
	public static String poslogin = "/service2/poslogin.htm";

	/**
	 * ��ȡ���ս��׼�¼
	 */
	public static String getTodayTradList = "/service2/gettradelistnew.htm";
	/**
	 * ��ȡ��������
	 */
	public static String getCancelTradeDetial = "/service2/gettradedetail.htm";
	/**
	 * �ϴ�ǩ��
	 */
	public static String uploadPhoto = "/d/upload/mobile";
	/**
	 * ��ȡ��ʷ���׼�¼
	 */
	public static String getHistoryTradList = "/service2/gethistorytradelistnew.htm";
	/**
	 * ��ȡ������Ϣ
	 */
	public final static String getBDpush = regbaseStr
			+ "/api/baidupush/getBDMsgList.html";
	/**
	 * ע���̻���ȡ��֤��
	 */
	public static String regCheckcode = regbaseStr
			+ "/api/jupos/regist/getcheckcode.html";
	/**
	 * ע���̻�
	 */
	public static String registStr = regbaseStr
			+ "/api/jupos/regist/regist.html";
	/**
	 * ���POS��
	 */
	public static final String UnbindPos = baseURLStr + "/service2/unbind.htm";
	/**
	 * ��ȡ���������б�
	 */
	public static final String GET_WORKFORM_QUESTION_TYPE = regbaseStr
			+ "/api/jupos/workorder/query_categories_list.html";
	/**
	 * ��ȡ������Ϣ
	 */
	public static String Get_Settle = "/service2/settleinfo.htm";
	/***
	 * ת��
	 */
	public static String Transfer = "/service2/c2ctransfer.htm";
	/**
	 * ����
	 */
	public static String Repaymet = "/service2/creditcardrepayment.htm";
	/***
	 * �ֻ���ֵ
	 */
	public static String Recharge = "/service2/charge.htm";
	/***
	 * ����
	 */
	public static String BDpush = regbaseStr
			+ "/api/baidupush/bindChannel.html";
	/**
	 * �������
	 */
	public static String DayOneStr = regbaseStr + "/d1open/d1.html";
	/**
	 * ��ȡ����
	 */
	public static String NewsStr = regbaseStr
			+ "/api/jupos/regist/getNews.html";
	/**
	 * ���ķ���
	 */
	public static String ChangeFee = baseURLStr
			+ "/service2/settle/setcurrentrate.htm";
	/**
	 * �󶨶�ά��
	 */
	public static String BundingCode = baseURLStr + "/service2/wx/bindqr.htm";
	/**
	 * ����ת��
	 */
	public static String Convert = "http://test.paytend.com:8088/rmb2eur.htm";
	public static String waikaPay = "/service2/appqpay.htm";
	public static String waikaRevoike = "/service2/appqpaycancel.htm";
	public static String timelyCheck = "/service2/settle/authentication.htm";
	/**
	 * ��ȡ΢��֧������
	 */
	public static String getWechatBuy = regbaseStr
			+ "/api/jupos/regist/payOrder2Wxpay.html";
	/**
	 * ��ȡǮ����Ϣ
	 */
	public static String getWalletInfo = getHttp()
			+ "/service2/wallet/getaccountstat.htm";
	/**
	 * Ǯ���Ƿ��Զ�����
	 */
	public static String isWalletSettleAuto = getHttp()
			+ "/service2/wallet/tranferinaccount.htm";
	/**
	 * ��ȡ���������б��url
	 * 
	 */
	public final static String GET_WORKFORM_QUSETION_LIST = regbaseStr
			+ "/api/jupos/workorder/query_subcategories_list.html";
	/**
	 * ��������
	 */
	public static final String WORKFORM_QUESTION_USE = regbaseStr
			+ "/api/jupos/workorder/click_categories_userful.html";
	/**
	 * �ύ����
	 */
	public static final String WORKFORM_UPDATE_QUESTION = regbaseStr
			+ "/api/jupos/workorder/add_workorder.html";
	/**
	 * ��ȡ��������
	 */
	public static final String WORKFORM_GET_DETAIL = regbaseStr
			+ "/api/jupos/workorder/query_workorder_detail.html";
	/**
	 * ���۹���
	 */
	public static final String WORKFORM_EVALUATE = regbaseStr
			+ "/api/jupos/workorder/evaluate_workorder.html";
	/**
	 * �رչ���
	 */
	public static final String WORKFORM_CLOSE = regbaseStr
			+ "/api/jupos/workorder/close_workorder.html";
	/**
	 * ȷ�Ϲ���
	 */
	public static final String WORKFORM_SOLUTION = regbaseStr
			+ "/api/jupos/workorder/sure_workorder.html";
	/**
	 * �ύ����
	 */
	public static final String WORKFORM_SUBMIT = regbaseStr
			+ "/api/jupos/workorder/re_workorder.html";
}
