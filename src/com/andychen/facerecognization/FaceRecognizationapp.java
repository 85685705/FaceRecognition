package com.andychen.facerecognization;

import android.app.Application;
import android.util.Log;

import com.iflytek.cloud.SpeechUtility;

public class FaceRecognizationapp extends Application{

	@Override
	public void onCreate() {
		
		//���ÿƴ�Ѷ�ɵ�sdk,ע��appid
		SpeechUtility.createUtility(this, "appid=" + getString(R.string.app_id));
		super.onCreate();
	};
}
