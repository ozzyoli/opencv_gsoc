package org.opencv.samples.markerlessarforandroid.camera;

import java.util.List;

import org.opencv.android.JavaCameraView;
import android.content.Context;
import android.hardware.Camera.Size;
import android.util.AttributeSet;

/**
 * This View extends {@link JavaCameraView} and allows the resolution to be adjusted.
 * @author Oliver Wilkie
 *
 */
public class CameraView extends JavaCameraView {

	private static final String TAG = "MarkerlessAR::CameraView";

	public CameraView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public List<Size> getResolutionList() {
		return mCamera.getParameters().getSupportedPreviewSizes();
	}

	public void setResolution(Size resolution) {
		disconnectCamera();
		mMaxHeight = resolution.height;
		mMaxWidth = resolution.width;
		connectCamera(getWidth(), getHeight());
	}

	public Size getResolution() {
		return mCamera.getParameters().getPreviewSize();
	}

}
