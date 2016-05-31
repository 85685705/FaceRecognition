package com.andychen.facerecognization.fragmnet;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Decoder.BASE64Encoder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.andychen.facerecognization.R;
import com.andychen.facerecognization.db.Mearchan;
import com.andychen.facerecognization.db.StaticArguments;
import com.andychen.facerecognization.db.UploadResult;
import com.andychen.facerecognization.db.UserInfo;
import com.andychen.facerecognization.face.CameraInterface;
import com.andychen.facerecognization.face.CameraSurfaceView;
import com.andychen.facerecognization.face.FaceEyebrow;
import com.andychen.facerecognization.face.FaceMouth;
import com.andychen.facerecognization.face.FacePosition;
import com.andychen.facerecognization.face.FaceRect;
import com.andychen.facerecognization.face.FaceUtil;
import com.andychen.facerecognization.face.ParseResult;
import com.andychen.facerecognization.listener.TakePictureListener;
import com.andychen.facerecognization.util.ImageUtils;
import com.andychen.facerecognization.view.LoadingDialog;
import com.andychen.facerecognization.view.ShowToast;
import com.iflytek.cloud.FaceDetector;
import com.iflytek.cloud.util.Accelerometer;
import com.paytend.jcd.internet.HttpUtils.HttpListener;
import com.paytend.jcd.internet.StringUtils;

public class FaceFragment extends Fragment implements HttpListener {

	// Camera nv21��ʽԤ��֡�ĳߴ磬Ĭ������640*480
	private int PREVIEW_WIDTH = 640;
	private int PREVIEW_HEIGHT = 480;
	// Ԥ��֡���ݴ洢����ͻ�������
	private byte[] nv21;
	private byte[] buffer;

	// FaceDetector���󣬼�������������ʶ��������⡢��Ƶ����⹦��
	private FaceDetector mFaceDetector;
	private Canvas mCanvas;

	// ���ٶȸ�Ӧ�������ڻ�ȡ�ֻ��ĳ���
	private Accelerometer mAcceler;

	private boolean mStopTrack;
	// �Ƿ���ʾ�۽��� 0����ʾ 1��ʾ
	private int isAlign = 1;
	protected int mCameraId = CameraInfo.CAMERA_FACING_FRONT;

	private boolean isOpenMouth = false;
	private boolean isShakeHead = false;
	private TextView tv_notice;
	private ImageView img_animation;
	private CameraSurfaceView mPreviewSurface = null;
	private SurfaceView mFaceSurface;
	private boolean isFace = false;
	// ����������⼰����������߳�
	private Thread mThread;
	View mFaceView;
	/**
	 * ҡͷ����
	 */
	int iFlag = 0;
	/**
	 * ��������
	 */
	int oFlag = 0;
	int countHead = 0;// ��������ҡͷ����
	/**
	 * ���յĴ���
	 */
	int takePictureFlag = 0;
	BASE64Encoder mBASE64Encoder;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (mFaceView == null) {
			mFaceView = inflater.inflate(R.layout.fragment_face, null);
			mPreviewSurface = (CameraSurfaceView) mFaceView
					.findViewById(R.id.surface_fragment_face_preview);

			mFaceSurface = (SurfaceView) mFaceView
					.findViewById(R.id.surface_fragment_face_face);
			mFaceSurface.setZOrderOnTop(true);
			mFaceSurface.getHolder().setFormat(PixelFormat.TRANSLUCENT);
			setSurfaceSize();
			tv_notice = (TextView) mFaceView
					.findViewById(R.id.tv_fragment_face_notice);

			img_animation = (ImageView) mFaceView
					.findViewById(R.id.img_fragment_face_anim);
			img_animation.setImageResource(R.drawable.img_face_open_mouth);
			AnimationDrawable animationDrawable = (AnimationDrawable) img_animation
					.getDrawable();
			animationDrawable.start();
		}
		ViewGroup parent = (ViewGroup) mFaceView.getParent();
		if (parent != null) {
			parent.removeView(mFaceView);
		}
		return mFaceView;
	}

	private void setSurfaceSize() {
		DisplayMetrics metrics = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay()
				.getMetrics(metrics);

		int width = metrics.widthPixels;
		int height = (int) (width * PREVIEW_WIDTH / (float) PREVIEW_HEIGHT);
		RelativeLayout.LayoutParams params = new LayoutParams(width, height);
		params.addRule(RelativeLayout.ALIGN_PARENT_TOP);

		mPreviewSurface.setLayoutParams(params);
		mFaceSurface.setLayoutParams(params);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// List<Object> previewDate = CameraInterface.getInstance()
		// .getPreviewDate();
		// buffer = (byte[]) previewDate.get(0);
		// nv21 = (byte[]) previewDate.get(1);

		mAcceler = new Accelerometer(getActivity());
		mFaceDetector = FaceDetector.createDetector(getActivity(), null);
		mBASE64Encoder = new BASE64Encoder();
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onResume() {
		super.onResume();

		if (null != mAcceler) {
			mAcceler.start();
		}
		mStopTrack = false;
		setFaceDetection();
		CameraInterface.getInstance().setOnTakePictureListener(
				new TakePictureListener() {

					@Override
					public void onTakePictuerResult(Bitmap mBitmap) {
						String bitMapStr = getImage(mBitmap);
						Message msg = new Message();
						msg.what = StaticArguments.FACE_HAS_TAKE_PPICTURE;
						msg.obj = bitMapStr;
						mHandler.sendMessage(msg);
					}
				});
	}

	@Override
	public void onPause() {
		super.onPause();
		CameraInterface.getInstance().doDestroyCamera();
		if (null != mAcceler) {
			mAcceler.stop();
		}
		mStopTrack = true;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		CameraInterface.getInstance().doDestroyCamera();
		mStopTrack = true;
		// ���ٶ���
		mFaceDetector.destroy();

	}

	/**
	 * �������
	 */
	private void setFaceDetection() {
		mThread = new Thread(new Runnable() {
			@Override
			public void run() {
				List<Object> previewDate = CameraInterface.getInstance()
						.getPreviewDate();
				buffer = (byte[]) previewDate.get(0);
				nv21 = (byte[]) previewDate.get(1);
				while (!mStopTrack) {
					if (null == nv21) {
						continue;
					}

					synchronized (nv21) {
						System.arraycopy(nv21, 0, buffer, 0, nv21.length);
					}

					// ��ȡ�ֻ����򣬷���ֵ0,1,2,3�ֱ��ʾ0,90,180��270��
					int direction = Accelerometer.getDirection();
					boolean frontCamera = (Camera.CameraInfo.CAMERA_FACING_FRONT == mCameraId);
					// ǰ������ͷԤ����ʾ���Ǿ�����Ҫ���ֻ������������ͷ�ӽ��µĳ���
					// ת����ʽ��a' = (360 - a)%360��aΪ�����ӽ��µĳ��򣨵�λ���Ƕȣ�
					if (frontCamera) {
						// SDK��ʹ��0,1,2,3,4�ֱ��ʾ0,90,180,270��360��
						direction = (4 - direction) % 4;
					}
					if (mFaceDetector == null) {
						/**
						 * ������Ƶ����⹦����Ҫ��������֧������������SDK �뿪����ǰ�������ƹ������ض�ӦSDK
						 */
						ShowToast.showToast(getActivity(), "��SDK��֧��������Ƶ�����");
						break;
					}

					String result = mFaceDetector.trackNV21(buffer,
							PREVIEW_WIDTH, PREVIEW_HEIGHT, isAlign, direction);

					FaceRect[] faces = ParseResult.parseResult(result);

					drawRect(frontCamera, faces);

				}
			}

			/**
			 * ���������򣬲����л�����
			 * 
			 * @param frontCamera
			 * @param faces
			 */
			private void drawRect(boolean frontCamera, FaceRect[] faces) {
				mCanvas = mFaceSurface.getHolder().lockCanvas();
				if (null == mCanvas) {
					return;
				}
				Point mouth_lower_lip_bottom = FaceMouth.getInstance()
						.getMouth_lower_lip_bottom();
				Point mouth_upper_lip_top = FaceMouth.getInstance()
						.getMouth_upper_lip_top();

				Point left_eyebrow_middle = FaceEyebrow.getInstance()
						.getLeft_eyebrow_middle();
				Point right_eyebrow_middle = FaceEyebrow.getInstance()
						.getRight_eyebrow_middle();

				mCanvas.drawColor(0, PorterDuff.Mode.CLEAR);

				mCanvas.setMatrix(mPreviewSurface.getMatrixInstance());

				if (faces == null || faces.length <= 0) {
					mFaceSurface.getHolder().unlockCanvasAndPost(mCanvas);
					isOpenMouth = false;
					isFace = false;
					return;
				}

				if (null != faces
						&& frontCamera == (Camera.CameraInfo.CAMERA_FACING_FRONT == mCameraId)) {
					for (FaceRect face : faces) {
						face.bound = FaceUtil.RotateDeg90(face.bound,
								PREVIEW_WIDTH, PREVIEW_HEIGHT);
						if (face.point != null) {
							for (int i = 0; i < face.point.length; i++) {
								face.point[i] = FaceUtil.RotateDeg90(
										face.point[i], PREVIEW_WIDTH,
										PREVIEW_HEIGHT);
							}
						}
						FaceUtil.drawFaceRect(mCanvas, face, PREVIEW_WIDTH,
								PREVIEW_HEIGHT, frontCamera, false);
					}
					isFace = true;
				} else {
					// Log.d(TAG, "faces:0");
				}

				if (mouth_lower_lip_bottom != null
						&& mouth_upper_lip_top != null
						&& left_eyebrow_middle != null
						&& right_eyebrow_middle != null) {

					int mouth_top_x = mouth_upper_lip_top.x;
					int mouth_bottom_x = mouth_lower_lip_bottom.x;

					int left_eyebrow_middle_y = left_eyebrow_middle.y;
					int right_eyebrow_middle_y = right_eyebrow_middle.y;

					int eyebrow_mlr_y = right_eyebrow_middle_y
							- left_eyebrow_middle_y;

					// ��ȡ���ž��ο��position
					int bottom = FacePosition.getInstance().getBottom();
					int top = FacePosition.getInstance().getTop();
					// ���������εĳ���
					int rectLength = bottom - top;

					int mouth_bt = mouth_top_x - mouth_bottom_x;

					if (isFace) {
						// ���л�����
						if (rectLength >= 160 && rectLength < 180) {
							// �ж�������������
							if (mouth_bt >= 40 && !isOpenMouth) {
								isOpenMouth = true;
								isShakeHead = true;
								mHandler.sendEmptyMessageDelayed(
										StaticArguments.FACE_OPEN_MOUTH, 1000);
							}
							// ����ҡͷ�ж�
							if (eyebrow_mlr_y < 79 && eyebrow_mlr_y >= 0
									&& isShakeHead) {
								isOpenMouth = true;

								countHead++;
								if (countHead % 2 == 0) {
									mHandler.sendEmptyMessageDelayed(
											StaticArguments.FACE_SHAKE_HEAD,
											3000);
								}
							}

						} else if (rectLength >= 180 && rectLength < 200) {
							// �ж�������������
							if (mouth_bt >= 45 && !isOpenMouth) {
								isShakeHead = true;
								isOpenMouth = true;
								mHandler.sendEmptyMessageDelayed(
										StaticArguments.FACE_OPEN_MOUTH, 1000);
							}
							// ����ҡͷ�ж�
							if (eyebrow_mlr_y < 89 && eyebrow_mlr_y >= 0
									&& isShakeHead) {
								isOpenMouth = true;

								countHead++;
								if (countHead % 2 == 0) {
									mHandler.sendEmptyMessageDelayed(
											StaticArguments.FACE_SHAKE_HEAD,
											1000);
								}
							}
						} else if (rectLength >= 200 && rectLength < 340) {
							// �ж�������������
							if (mouth_bt >= 50 && !isOpenMouth) {
								isShakeHead = true;
								isOpenMouth = true;
								mHandler.sendEmptyMessageDelayed(
										StaticArguments.FACE_OPEN_MOUTH, 500);
							}
							// ����ҡͷ�ж�
							if (eyebrow_mlr_y < 95 && eyebrow_mlr_y >= 0
									&& isShakeHead) {
								isOpenMouth = true;

								countHead++;
								if (countHead % 2 == 0) {
									mHandler.sendEmptyMessageDelayed(
											StaticArguments.FACE_SHAKE_HEAD,
											1000);
								}
							}
						} else if (rectLength < 160) {// ����������ֻ�̫Զ
							mHandler.sendEmptyMessage(StaticArguments.FACE_LENGTH_LONG);
						} else if (rectLength >= 340 && rectLength >= 0) {// ����������ֻ�̫��
							mHandler.sendEmptyMessage(StaticArguments.FACE_LENGTH_NEAR);
						}
					}
				}
				mFaceSurface.getHolder().unlockCanvasAndPost(mCanvas);
			}
		});
		mThread.start();
	}

	Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case StaticArguments.FACE_HAS_TAKE_PPICTURE:
				if (takePictureFlag == 0) {
					takePictureFlag++;

					upLoadFace((String) msg.obj, 21);
				} else if (takePictureFlag == 1) {

					upLoadFace((String) msg.obj, 22);
				}
				break;

			case StaticArguments.FACE_OPEN_MOUTH:
				if (oFlag == 0) {
					takePicture();
					oFlag++;
					img_animation.setImageResource(R.drawable.img_face_head);
					AnimationDrawable animationDrawable = (AnimationDrawable) img_animation
							.getDrawable();
					animationDrawable.start();
					tv_notice.setText("����������תͷ...");
				}
				break;

			case StaticArguments.FACE_LENGTH_NEAR:
				ShowToast.showToast(getActivity(), "�����������ֻ�̫��");
				break;

			case StaticArguments.FACE_SHAKE_HEAD:
				if (iFlag == 0) {
					iFlag++;
					mStopTrack = true;// ���ճɹ�����������к���������ʧ��
					takePicture();
				}
				break;
			case StaticArguments.FACE_LENGTH_LONG:
				ShowToast.showToast(getActivity(), "�������̫Զ��");
				break;
			default:
				break;
			}
		}
	};

	/**
	 * ����
	 */
	private void takePicture() {
		// isOpenMouth = true;
		CameraInterface.getInstance().doTakePicture();
	}

	public void upLoadFace(String file_image_String, int flag) {
		if (flag == 22) {
//			LoadingDialog
//					.showDialog(getActivity(), R.string.txt_loading, false);
			Toast.makeText(getActivity(), "��⵽����ҡͷ,�������ʶ��", 0).show();
		}
//		String mearchantId = UserInfo.getInfo().getMerchantId();
//		String signature = "";
//		String type = flag + "";
//		Map<String, String> mMap = new HashMap<String, String>();
//		try {
//			signature = Util.calcMD5(mearchantId + type + file_image_String
//					+ HttpURL.CK);
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		mMap.put("URL", HttpURL.uploadInfo);
//		mMap.put("userId", mearchantId);
//		mMap.put("type", type);
//		mMap.put("imageData", file_image_String);
//		mMap.put("signature", signature);
//		HttpUtils.httpPost(mMap, this, flag);

	}

	private String getImage(Bitmap bitmap) {

		byte[] file_image_bytes = ImageUtils.bitmapToByte(bitmap);
		String bitMapStr = mBASE64Encoder.encodeBuffer(file_image_bytes);
		return bitMapStr;
	}

	@Override
	public void onPreGet() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPostGet(Message message) {
		switch (message.what) {
//		case 22:
//			LoadingDialog.closeDialog();
//			String myHttpResponse = (String) message.obj;
//			if (myHttpResponse == null || StringUtils.isEmpty(myHttpResponse)) {
//
//			} else {
//				UploadResult mUploadResult = HttpUtil
//						.getUploadResult(myHttpResponse);
//				if (mUploadResult != null && mUploadResult.isFlag()) {
//					Mearchan.getMearchan().getBitMapId()[5] = mUploadResult
//							.getId();
//					Mearchan.getMearchan().getBitMapStatus()[5] = "0";
//					// mMearchan.getBitMapId()[0] = mUploadResult.getId();
//				} else {
//
//				}
//			}
//			getActivity().setResult(StaticArguments.REG_FACE);
//			getActivity().finish();
//			break;
		case 21:

//			String mHttpResponse = (String) message.obj;
//			if (mHttpResponse == null || StringUtils.isEmpty(mHttpResponse)) {
//
//			} else {
//				UploadResult mUploadResult = HttpUtil
//						.getUploadResult(mHttpResponse);
//				if (mUploadResult != null && mUploadResult.isFlag()) {
//					Mearchan.getMearchan().getBitMapId()[4] = mUploadResult
//							.getId();
//					Mearchan.getMearchan().getBitMapStatus()[4] = "0";
//				} else {
//
//				}
//			}
			break;

		default:
			break;
		}

	}
}
