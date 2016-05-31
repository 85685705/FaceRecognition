package com.paytend.jcd.internet;



/**
 * @author Administrator
 * 
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class StringUtil {
	
	static final String HEX_FORMAT = "%02x";

	public static String bytesToHexStr(byte b[]) {
		return bytesToHexStr(b, 0, b.length);
	}

	public static String bytesToHexStr(byte b[], int start, int len) {
		StringBuffer str = new StringBuffer();
		for (int i = start; i < start + len; i++) {
			str.append(String.format(HEX_FORMAT, b[i]));
		}
		return str.toString();
	}


	/**
	 * ��ʮ�������ַ���ת��Ϊ�ֽ�����
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] hexStrToBytes(String str) {
		if (str.length() % 2 != 0) {
			str = "0" + str;
		}
		byte[] temp = new byte[str.length() / 2];
		for (int i = 0; i < str.length(); i = i + 2) {
			temp[i / 2] = (byte) (Byte.parseByte(str.substring(i, i + 1), 16) * 16 + Byte
					.parseByte(str.substring(i + 1, i + 2), 16));
		}
		return temp;
	}

	public static void hexStrToBytes(String str, byte[] b, int from) {
		if (str.length() % 2 != 0) {
			str = "0" + str;
		}
		hexStrToBytes(str, b, from, str.length() / 2);
	}

	/**
	 * ��ʮ�������ַ���ת��Ϊ�ֽ�����
	 * 
	 * @param str
	 * @return
	 */
	public static void hexStrToBytes(String str, byte[] b, int from, int length) {
		if (str.length() % 2 != 0) {
			str = "0" + str;
		}
		for (int i = 0; i < Math.min(str.length(),length * 2) && (from+i/2)<b.length; i = i + 2) {
			b[from + i / 2] = (byte) (Byte.parseByte(str.substring(i, i + 1),
					16) * 16 + Byte.parseByte(str.substring(i + 1, i + 2), 16));
		}
	}

	/**
	 * ��hexStrת���������byte����,�ص�Ϊ�Ͽ�ϵͳʹ��
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] hexStrToInverseBytes(String str) {
		if (str.length() % 2 != 0) {
			str = "0" + str;
		}
		byte[] temp = new byte[str.length() / 2];
		for (int i = 0; i < str.length(); i = i + 2) {
			temp[temp.length - 1 - i / 2] = (byte) (Byte.parseByte(str
					.substring(i, i + 1), 16) * 16 + Byte.parseByte(str
					.substring(i + 1, i + 2), 16));
		}
		return temp;
	}

	/**
	 * �������byte����ת����hexStr,�ص�Ϊ�Ͽ�ϵͳʹ��
	 * 
	 * @param str
	 * @return
	 */
	public static String inverseBytesToHexStr(byte b[], int start, int len) {
		StringBuffer str = new StringBuffer();
		for (int i = start + len - 1; i >= start; i--) {
			str.append(String.format(HEX_FORMAT, b[i]));
		}
		return str.toString();
	}

	/**
	 * ���������޼�String
	 * 
	 * @param text
	 *            ԭʼ����
	 * @param length
	 *            ��Ҫ�ĳ���
	 * @param ch
	 *            ��ӵ��ַ�
	 * @param end
	 *            true��ĩβ��false��ͷ��
	 * @return ����Ҫ���String
	 * 
	 * 20050301 update by guty ������������Ϊ2
	 */
	public static String lengthFix(String text, int length, char ch, boolean end) {
		if (text == null)
			text = "";
		int tempLength = text.getBytes().length;
		if (length == tempLength)
			return text;

		if (length > tempLength) {
			char[] fix = new char[length - tempLength];
			for (int i = 0; i < fix.length; i++) {
				fix[i] = ch;
			}
			StringBuffer buffer = new StringBuffer(text);
			if (end) {
				buffer = buffer.append(fix);
			} else {
				buffer = buffer.insert(0, fix);
			}
			return buffer.toString();
		} else {
			if (end)
				return new String(text.getBytes(), 0, length);
			else
				return new String(text.getBytes(), tempLength - length, length);
		}
	}
	
	// for dyna language call
	public static String lengthFix(String text, int length, String ch,
			boolean end) {
		return lengthFix(text, length, ch.charAt(0), end);
	}

}