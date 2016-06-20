package com.andychen.facerecognization.intent;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Locale;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.params.CoreConnectionPNames;

import android.os.AsyncTask;
import android.os.Message;

/**
 * httpsclent ��������
 * 
 * @author paytend_liu
 * 
 */
public class HttpsClient {
	/**
	 * �����ķ��� 
	 * �����첽����
	 * 
	 * @param url
	 *            ����������
	 * @param listener
	 *            ������
	 * @param type�����ı�ʶ��
	 */
	public static void httpsGet(String url, HttpsListener listener, int type) {
		new HttpsAsyncTask(listener, type).execute(url);
	}

	/**
	 * 
	 * �����ķ���
	 * @param path
	 *            ������ַ
	 * @return ���շ��ص���Ϣ
	 * @throws Exception
	 */
	private static String sendHttpsClientPOSTRequest(String path)
			throws Exception {
		String encoding = "UTF-8";
		HttpPost httpPost = new HttpPost(path);
		String locale = Locale.getDefault().getLanguage();
		if (locale.equals("zh")) {
			locale = "zh";
		} else {
			locale = "en";
		}
		httpPost.addHeader("Cookie", "locale=" + locale);

		HttpClient client = HttpsUtil.getHttpClient();

		client.getParams().setParameter(
				CoreConnectionPNames.CONNECTION_TIMEOUT, 5 * 1000);
		HttpResponse response = client.execute(httpPost);

		return new String(readStream(response.getEntity().getContent()),
				encoding);
	}

	/**
	 * 
	 * ��������ת�����ַ���
	 * 
	 * @param inStream
	 *            ������
	 * @return �ַ���
	 * @throws Exception
	 */
	public static byte[] readStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len = inStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}
		outSteam.close();
		inStream.close();
		return outSteam.toByteArray();
	}

	/**
	 * �������첽����
	 * 
	 * @author paytend_liu
	 * 
	 */
	private static class HttpsAsyncTask extends AsyncTask<String, Void, String> {
		/**
		 * �����ı�ʶ��
		 */
		private int type;
		/**
		 * ������
		 */
		private HttpsListener listener;

		/**
		 * 
		 * @param listener
		 * @param type
		 */
		public HttpsAsyncTask(HttpsListener listener, int type) {
			this.listener = listener;
			this.type = type;
		}

		protected void onPostExecute(String HttpsStr) {
			if (listener != null) {
				Message message = new Message();
				message.what = type;
				if (HttpsStr != null) {
					message.obj = HttpsStr;
				}
				listener.onPostGet(message);
			}

		}

		@Override
		protected String doInBackground(String... url) {
			if (isEmpty(url[0])) {
				return null;
			}
			try {
				return sendHttpsClientPOSTRequest(url[0]);
			} catch (Exception e) {
				return null;
			}
		}
	}
/**
 * ������
 * @author paytend_liu
 *
 */
	public static interface HttpsListener {
		/**
		 * �����������ص���Ϣ
		 * @param message �������ص���Ϣ
		 */
		public void onPostGet(Message message);
	}
/**
 * �ж��ַ����Ƿ�Ϊ��
 * @param sourceArray ��Ҫ�жϵ��ַ���
 * @return ��Ϊtrue �ǿ�Ϊfalse
 */
	public static boolean isEmpty(String sourceArray) {
		return (sourceArray == null || sourceArray.isEmpty());
	}
}
