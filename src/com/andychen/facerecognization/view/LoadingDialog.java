package com.andychen.facerecognization.view;


import com.andychen.facerecognization.R;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;


/**
 * �ȴ��Ի���
 * 
 * @author paytend_liu
 * 
 */
public class LoadingDialog {
	static Dialog mProgressDialog;

	/**
	 * չʾ�Ի���
	 * 
	 * @param context
	 * @param stringId
	 * @param flag
	 */
	public static void showDialog(Context context, int stringId, boolean flag) {
		if (mProgressDialog != null) {
			try {
				if (mProgressDialog.isShowing()) {
					mProgressDialog.dismiss();
				}
			} catch (Exception e) {

			}
		}
		mProgressDialog = null;
		mProgressDialog = onCreatDialog(context);
		TextView tv_message = (TextView) mProgressDialog
				.findViewById(R.id.tv_dialog_message);
		tv_message.setText(stringId);
		mProgressDialog.setCancelable(flag);
		mProgressDialog.setOnCancelListener(new OnCancelListener() {

			@Override
			public void onCancel(DialogInterface dialog) {
				mProgressDialog.dismiss();
				mProgressDialog = null;

			}
		});
		try {
			mProgressDialog.show();
		} catch (Exception e) {

		}

	}

	/**
	 * չʾ�Ի���
	 * 
	 * @param context
	 * @param str
	 * @param flag
	 */
	public static void showDialog(Context context, String str, boolean flag) {
		if (str == null || str.length() < 1) {
			return;
		}
		if (mProgressDialog != null) {
			try {
				if (mProgressDialog.isShowing()) {
					mProgressDialog.dismiss();
				}
			} catch (Exception e) {

			}
		}
		mProgressDialog = null;
		mProgressDialog = onCreatDialog(context);
		TextView tv_message = (TextView) mProgressDialog
				.findViewById(R.id.tv_dialog_message);
		tv_message.setText(str);
		mProgressDialog.setCancelable(flag);
		mProgressDialog.setOnCancelListener(new OnCancelListener() {

			@Override
			public void onCancel(DialogInterface dialog) {
				mProgressDialog.dismiss();
				mProgressDialog = null;

			}
		});
		try {
			mProgressDialog.show();
		} catch (Exception e) {

		}

	}

	/**
	 * ���ɶԻ���
	 * 
	 * @param context
	 * @return
	 */
	private static Dialog onCreatDialog(Context context) {
		Dialog dialog = new Dialog(context, R.style.new_circle_progress);
		dialog.setContentView(R.layout.dialog_loading);

		return dialog;
	}

	/**
	 * �رյȴ��Ի���
	 */
	public static void closeDialog() {
		if (mProgressDialog == null)
			return;
		if (mProgressDialog.isShowing()) {
			try {

				mProgressDialog.dismiss();

			} catch (Exception e) {

			}
			mProgressDialog = null;
		}
	}

	/**
	 * ���õȴ��Ի�������ʾ����Ϣ
	 * 
	 * 
	 * @param stringId
	 *            ��ʾ��Ϣ��Id
	 */
	public static void setMessage(int stringId) {
		if (mProgressDialog == null)
			return;
		if (mProgressDialog.isShowing()) {

			TextView tv_message = (TextView) mProgressDialog
					.findViewById(R.id.tv_dialog_message);
			tv_message.setText(stringId);
		}
	}

	/**
	 * ���õȴ��Ի�������ʾ����Ϣ
	 * 
	 * @param Str
	 *            ��ʾ����Ϣ
	 */
	public static void setMessage(String Str) {
		if (mProgressDialog == null)
			return;
		if (mProgressDialog.isShowing()) {

			TextView tv_message = (TextView) mProgressDialog
					.findViewById(R.id.tv_dialog_message);
			tv_message.setText(Str);
		}
	}
}
