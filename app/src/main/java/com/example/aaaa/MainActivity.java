package com.example.aaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private static final String openCV = "OpenCV";
   private CameraBridgeViewBase cameraBridgeViewBase;
   private final BaseLoaderCallback mload = new BaseLoaderCallback(this) {
       @Override
       public void onManagerConnected(int status) {
           switch (status){
               case  LoaderCallbackInterface.SUCCESS:{
                   Log.d("cc" ,"cài đặt thành công");
                   cameraBridgeViewBase.enableView();
               }
               break;
               default: {
                   Log.d("cc", "onManagerConnected: ");
                   super.onManagerConnected(status);

               }
               break;
           }
       }
   };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraBridgeViewBase = (CameraBridgeViewBase) findViewById(R.id.show_suff);
        cameraBridgeViewBase.setVisibility(SurfaceView.VISIBLE);
        cameraBridgeViewBase.setCvCameraViewListener(cvCamView);
        Log.d("cd", "onCreate: " );
//        VideoCapture videoCapture = new VideoCapture();
    }

    private final CameraBridgeViewBase.CvCameraViewListener2 cvCamView = new CameraBridgeViewBase.CvCameraViewListener2() {
        @Override
        public void onCameraViewStarted(int width, int height) {

        }

        @Override
        public void onCameraViewStopped() {

        }

        @Override
        public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
            Log.d("xzs", "onCameraFrame: ");
            return inputFrame.rgba();
        }
    };
}