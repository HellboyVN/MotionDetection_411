package com.hhbgk.webservice.discovery.ui.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.hhbgk.webservice.discovery.R;
import com.hhbgk.webservice.discovery.data.model.PtzNode;
import com.hhbgk.webservice.discovery.onvif.OnvifService;
import com.hhbgk.webservice.discovery.util.Dbug;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.video.Video;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;

//import io.vov.vitamio.LibsChecker;
;

/**
 * Author: bob
 * Date: 16-6-28 16:48
 * Version: V1
 * Description:
 */
public class PtzFragment extends Fragment implements View.OnClickListener, SurfaceHolder.Callback, MediaPlayer.OnPreparedListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private String tag = getClass().getSimpleName();
    private static List<PtzNode> mPtzNodeList;
    private Button ptzUp, ptzDown, ptzLeft, ptzRight, ptzHome, btnSetPreset, btnGoToPreset, btnSend, btnAbsMove, detect,btn_motion;
    private OnvifService mOnvifService;
    private String serviceUrl, uri_rtsp;
    private io.vov.vitamio.widget.VideoView videoView;
    private int mVideoWidth=480;
    private int mVideoHeight=360;
    private MediaPlayer mMediaPlayer;
    private SurfaceView mPreview;
    private SurfaceHolder holder;
    private String videoPath = "rtsp://192.168.0.112:554/onvif1";
    //private String videoPath = "http://192.168.0.199:8080/video2.mjpg";

    private boolean mIsVideoSizeKnown = false;
    private boolean mIsVideoReadyToBePlayed = false;
    //opencv init
    //optical flow
    private enum STATUS {
        STATIC, TRACKING, DYNAMIC
    };

    STATUS status;
    private MatOfPoint2f mMOP2fptsPrev, mMOP2fptsSafe, mMOP2fptsThis;
    private Mat matOpFlowThis, matOpFlowPrev, hsvImage, bgrImage, maskImage;
    private MatOfPoint MOPcorners;
    private MatOfFloat mMOFerr;
    private int maxCorners = 300;
    double qualityLevel = 0.01;
    double minDistance = 10;
    private List<org.opencv.core.Point> cornersPrev;
    private List<org.opencv.core.Point> cornersThis;
    private MatOfByte mMOBStatus;
    private List<Byte> byteStatus;
    private int x, y,count=0;
    private org.opencv.core.Point pt, pt2;
    private Scalar colorRed = new Scalar(255, 0, 0);
    android.media.MediaPlayer player1;
    //ofticalflow
    InputStream is;
    File cascadeDir;
    File mCascadeFile;
    InputStream is1;
    File cascadeDir1;
    File mCascadeFile1;
    FileOutputStream os;
    public static final int JAVA_DETECTOR = 0;
    private float mRelativeFaceSize = 0.2f;
    private int mAbsoluteFaceSize = 0;
    private int mLikely = 999;
    private Mat mRgba;
    private Mat mGray;
    CascadeClassifier mJavaDetector;
    CascadeClassifier mJavaDetector1;
    private int mDetectorType = JAVA_DETECTOR;
    public TextureView tview;
    Bitmap mBitmap;
    private Mat mRgb;

    boolean detectf, detect_motion;
    int check=0;
    static Surface sss;



    private static final Scalar FACE_RECT_COLOR = new Scalar(0, 255, 0, 255);

    static {
        if (OpenCVLoader.initDebug()) {
            Log.i("OPenCV", "------LOAD OK----- ");
        } else {
            Log.i("OPenCV", "------LOAD Fail----- ");
        }
    }

private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(getActivity()) {
    @Override
    public void onManagerConnected(int status) {
        switch (status) {
            case LoaderCallbackInterface.SUCCESS: {
                Log.i("", "OpenCV loaded successfully");

                try {
                    is = getResources().openRawResource(
                            R.raw.hogcascade_pedestrians);
                    cascadeDir = getActivity().getDir("cascade", Context.MODE_PRIVATE);
                    mCascadeFile = new File(cascadeDir, "hogcascade_pedestrians.xml");

                    FileOutputStream os = new FileOutputStream(mCascadeFile);

                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = is.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }

                    is.close();
                    os.close();

                    mJavaDetector = new CascadeClassifier(
                            mCascadeFile.getAbsolutePath());
                    if (mJavaDetector.empty()) {
                        Log.e("Levan", "Failed to load cascade classifier");
                        mJavaDetector = null;
                    } else
                        Log.i("Levan", "Loaded cascade classifier from "
                                + mCascadeFile.getAbsolutePath());

                    cascadeDir.delete();

                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("Levan", "Failed to load cascade. Exception thrown: " + e);
                }
                //flame detector
                try {
                    is1 = getResources().openRawResource(
                            R.raw.fire);
                    cascadeDir1 = getActivity().getDir("cascade", Context.MODE_PRIVATE);
                    mCascadeFile1 = new File(cascadeDir1, "fire.xml");

                    FileOutputStream os = new FileOutputStream(mCascadeFile1);

                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = is1.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }

                    is1.close();
                    os.close();

                    mJavaDetector1 = new CascadeClassifier(
                            mCascadeFile1.getAbsolutePath());
                    if (mJavaDetector1.empty()) {
                        Log.e("Levan", "Failed to load cascade classifier");
                        mJavaDetector1 = null;
                    } else
                        Log.i("Levan", "Loaded cascade classifier from "
                                + mCascadeFile1.getAbsolutePath());

                    cascadeDir1.delete();

                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("Levan", "Failed to load cascade. Exception thrown: " + e);
                }

            }
            break;
            default: {
                super.onManagerConnected(status);
            }
            break;

        }
    }
};
    public String responseString;

    public static PtzFragment newInstance(String serviceUrl) {
        Dbug.e("PtzFragment", "service url=" + serviceUrl);
        PtzFragment fragment = new PtzFragment();
        Bundle bundle = new Bundle();
        bundle.putString("service_url", serviceUrl);
        fragment.setArguments(bundle);
        return fragment;
    }



    @Override
    public void onResume() {
        super.onResume();

       OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_9, getActivity(),
               mLoaderCallback);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ptz_layout, container, false);
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getActivity().getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        Vitamio.isInitialized(getActivity());

        view.setKeepScreenOn(true);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

        }

        player1 = new android.media.MediaPlayer();
        ptzUp = (Button) view.findViewById(R.id.ptz_up);
        ptzUp.setOnClickListener(this);
        ptzDown = (Button) view.findViewById(R.id.ptz_down);
        ptzDown.setOnClickListener(this);
        ptzHome = (Button) view.findViewById(R.id.ptz_home);
        ptzHome.setOnClickListener(this);
        ptzLeft = (Button) view.findViewById(R.id.ptz_left);
        ptzLeft.setOnClickListener(this);
        ptzRight = (Button) view.findViewById(R.id.ptz_right);
        ptzRight.setOnClickListener(this);
//        btn_preset= (Button) view.findViewById(R.id.btn_preset);
//        btn_preset.setOnClickListener(this);
//        btn_getPreset= (Button) view.findViewById(R.id.btn_getPreset);
//        btn_getPreset.setOnClickListener(this);
//        videoView=(io.vov.vitamio.widget.VideoView) view.findViewById(R.id.vitamio_videoView);
//        MediaController mc = new MediaController(getActivity());
//        videoView.setMediaController(mc);
//        videoView.setVideoPath("rtsp://hellboy1994.ddns.net:554/onvif1");
//        videoView.requestFocus();
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                mediaPlayer.setPlaybackSpeed(1.0f);
//            }
//        });
        detect = (Button) view.findViewById(R.id.btn_detect);
        detect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                detectf = true;
                detect_motion = false;
                Log.e("Van","da nhan nut");


            }
        });
        btn_motion = (Button) view.findViewById(R.id.btn_motion);
        btn_motion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                detectf = false;
                detect_motion = true;
                Log.e("Van","da nhan nut");


            }
        });
        btnAbsMove = (Button) view.findViewById(R.id.btnAbsMove);
        btnAbsMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnvifService.requestPtzAbsoluteMove(serviceUrl, null);

            }
        });
        btnSetPreset = (Button) view.findViewById(R.id.btnSetPreset);
        btnSetPreset.setOnClickListener(this);

        btnGoToPreset = (Button) view.findViewById(R.id.btnGoToPreset);
        btnGoToPreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnvifService.requestPtzGetPreset(serviceUrl, null);

            }
        });


        // final String res = null;

        btnSend = (Button) view.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = null;
                try {
                    response = httpclient.execute(new HttpGet("http://lab411s.esy.es/sg/rx.php?data=SN:00000107"));
                    StatusLine statusLine = response.getStatusLine();
                    if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        response.getEntity().writeTo(out);
                        responseString = out.toString();

                        Toast.makeText(getActivity(), responseString, Toast.LENGTH_SHORT).show();
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        mPreview = (SurfaceView) view.findViewById(R.id.surfaceView);
        holder = mPreview.getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        holder.setFormat(PixelFormat.RGBA_8888);
        /////////////////OPENCV-PEDESTRIAN DETECTTION//////////////////////////////////////////////
        // --------------------------------- load left eye classificator -----------------------------------
        tview = (TextureView) view.findViewById(R.id.surface);
        tview.setSurfaceTextureListener(this);


//--------------------------------END---------------------------------------------------------------------
        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);

//        ptzHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View v1=getView().getRootView();
//                v1.setDrawingCacheEnabled(true);
//                bitmap=v1.getDrawingCache();
//                String root = Environment.getExternalStorageDirectory().toString();
//                File myDir = new File(root + "/saved_images");
//                myDir.mkdirs();
//                Random generator = new Random();
//                int n = 10000;
//                n = generator.nextInt(n);
//                String fname = "Image-"+ n +".jpg";
//                File file = new File (myDir, fname);
//                if (file.exists ()) file.delete ();
//                try {
//                    FileOutputStream out = new FileOutputStream(file);
//                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
//                    out.flush();
//                    out.close();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });

//        Thread myThread = new Thread(new MyThread());
//        myThread.start();
//        handler = new Handler(){
//            @Override
//            public void handleMessage(Message msg) {
//                String res = msg.obj.toString();
//                Log.d("LOI", res.toString());
//                if(res=="van"){
//                    mOnvifService.requestPtzContinuousMoveUp(serviceUrl, null);
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            mOnvifService.requestStopPtzContinuousMove(serviceUrl, null);
//                        }
//                    }, 1000);
//                }else{
//                    mOnvifService.requestPtzContinuousMoveDown(serviceUrl, null);
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            mOnvifService.requestStopPtzContinuousMove(serviceUrl, null);
//                        }
//                    }, 1000);
//                }
//            }
//        };
//        Thread timer = new Thread() {
//            @Override
//            public void run() {
//
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        int g= 0;
//
//                        while (g<5) {
//                            HttpClient httpclient = new DefaultHttpClient();
//                            HttpResponse response = null;
//                            try {
//                                response = httpclient.execute(new HttpGet("http://lab411s.esy.es/sg/autosendhwsn.php"));
//                                StatusLine statusLine = response.getStatusLine();
//
//                                if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
//                                    ByteArrayOutputStream out = new ByteArrayOutputStream();
//                                    response.getEntity().writeTo(out);
//                                    String responseString = out.toString();
//                                    Log.d("A", responseString);
//                                    if(responseString=="van"){
//                                        Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
//                                    }else{
//                                        Toast.makeText(getActivity(), "2", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//
//
//
//                            } catch (ClientProtocolException e) {
//                                e.printStackTrace();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                            g++;
//
//
//
//                        }
//
//                    }
//                });
//            }
//        };
//        timer.start();
        final Handler handler = new Handler();

//        Timer timer = new Timer();
//        TimerTask doAsynchronousTask = new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(new Runnable() {
//                    public void run() {
//                        try {
//                            GetResponseTask task = new GetResponseTask();
//                            task.execute("http://lab411s.esy.es/sg/autosendhwsn.php");
//                        } catch (Exception e) {
//                            // TODO Auto-generated catch block
//                        }
//                    }
//                });
//            }
//        };
//        timer.schedule(doAsynchronousTask, 0, 4000);


        return view;
    }
// /////////////////////////////////////////////////////////

    public Bitmap opticalFlow(Bitmap bitmap) {
        Bitmap result=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),
                Bitmap.Config.RGB_565);
        // Convert Bitmap to Mat
        Utils.bitmapToMat(bitmap, mRgb);
        if (mMOP2fptsPrev.rows() == 0) {

            // get this mat
            Imgproc.cvtColor(mRgb, matOpFlowThis, Imgproc.COLOR_RGB2GRAY);

            // copy that to prev mat
            matOpFlowThis.copyTo(matOpFlowPrev);

            // get prev corners
            Imgproc.goodFeaturesToTrack(matOpFlowPrev, MOPcorners, maxCorners,
                    qualityLevel, minDistance);
            // Imgproc.goodFeaturesToTrack(matOpFlowPrev, MOPcorners,
            // maxCorners, qualityLevel, minDistance, maskImage, blockSize,
            // useHarrisDetector, k);
            mMOP2fptsPrev.fromArray(MOPcorners.toArray());

            // get safe copy of this corners
            mMOP2fptsPrev.copyTo(mMOP2fptsSafe);
        } else {
            // we've been through before so
            // this mat is valid. Copy it to prev mat
            matOpFlowThis.copyTo(matOpFlowPrev);

            // get this mat
            Imgproc.cvtColor(mRgb, matOpFlowThis, Imgproc.COLOR_RGB2GRAY);

            // get the corners for this mat
            Imgproc.goodFeaturesToTrack(matOpFlowThis, MOPcorners, maxCorners,
                    qualityLevel, minDistance);
            // Imgproc.goodFeaturesToTrack(matOpFlowPrev, MOPcorners,
            // maxCorners, qualityLevel, minDistance, maskImage, blockSize,
            // useHarrisDetector, k);
            mMOP2fptsThis.fromArray(MOPcorners.toArray());

            // retrieve the corners from the prev mat
            // (saves calculating them again)
            mMOP2fptsSafe.copyTo(mMOP2fptsPrev);

            // and save this corners for next time through

            mMOP2fptsThis.copyTo(mMOP2fptsSafe);
        }

        Video.calcOpticalFlowPyrLK(matOpFlowPrev, matOpFlowThis, mMOP2fptsPrev,
                mMOP2fptsThis, mMOBStatus, mMOFerr);

        cornersPrev = mMOP2fptsPrev.toList();
        cornersThis = mMOP2fptsThis.toList();
        byteStatus = mMOBStatus.toList();

        y = byteStatus.size() - 1;
        ArrayList<Point> listPoint = new ArrayList<Point>();
        for (x = 0; x < y; x++) {
            if (byteStatus.get(x) == 1) {
                pt = cornersThis.get(x);
                pt2 = cornersPrev.get(x);
                listPoint.add(new Point(Math.abs(pt.x - pt2.x), Math.abs(pt.y
                        - pt2.y)));

                Core.circle(mRgb, pt, 5, colorRed, 3 - 1);

                Core.line(mRgb, pt, pt2, colorRed, 3);
            }
        }
        warning(listPoint);
        Utils.matToBitmap(mRgb, result);
        return result;
    }

    public void warning(ArrayList<Point> listPoint) {
        int dem = 0;
        for (int i = 0; i < listPoint.size(); i++) {
            if (listPoint.get(i).x >= 5 || listPoint.get(i).y >= 5) {
                dem++;
            }
        }
        if (dem >= 20) {
            // warning = true;
            status = STATUS.DYNAMIC;
            count = 0;
            Log.e("DYNAMIC", dem + "");
        } else {
            count++;
            if (count <= 2) {
                status = STATUS.TRACKING;
                Log.e("TRACKING", count + "");
            } else {
                status = STATUS.STATIC;
                Log.e("STATIC", count + "");
                if (count > 10)
                    count = 3;
            }
        }
        switch (status) {
            case STATIC:
                if (player1.isPlaying()) {
                    player1.stop();
//                    Toast.makeText(getActivity(), "Stop",
//                            Toast.LENGTH_SHORT).show();
                }
                break;
            case TRACKING:
                if (player1.isPlaying()) {
                    player1.stop();
//                    Toast.makeText(getActivity(), "Stop",
//                            Toast.LENGTH_SHORT).show();
                }
                break;
            case DYNAMIC:
                if (!player1.isPlaying()) {
                    player1.reset();
                    player1 = android.media.MediaPlayer.create(
                            getActivity(), R.raw.warning);
                    player1.start();
//                    Toast.makeText(getActivity(), "isPlaying",
//                            Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }

    }
    ///////////////////////////////////////
    public Bitmap ongetCameraFrame(Bitmap inputFrame) {
        Utils.bitmapToMat(inputFrame, mRgba);
        Bitmap result=Bitmap.createBitmap(inputFrame.getWidth(),inputFrame.getHeight(),
                Bitmap.Config.RGB_565);
        //Log.e("Size:","W= "+inputFrame.getWidth()+"H= "+inputFrame.getHeight()+"\n");
        //Log.e("Size RGBA:","W= "+mRgba.width()+"H= "+mRgba.height()+"\n");
        Core.line(mRgba, new Point(mRgba.width() / 2 - 100, 0), new Point(mRgba.width() / 2 - 100, mRgba.height()), FACE_RECT_COLOR, 1);
        Core.line(mRgba,new Point(mRgba.width()/2+100,0),new Point(mRgba.width()/2+100,mRgba.height()),FACE_RECT_COLOR,1);
        Imgproc.cvtColor(mRgba, mGray, Imgproc.COLOR_RGB2GRAY);

        if (mAbsoluteFaceSize == 0) {
            int height = mGray.rows();
            if (Math.round(height * mRelativeFaceSize) > 0) {
                mAbsoluteFaceSize = Math.round(height * mRelativeFaceSize);
            }
            // mNativeDetector.setMinFaceSize(mAbsoluteFaceSize);
        }

        MatOfRect faces = new MatOfRect();
        MatOfRect fire  = new MatOfRect();

        if (mDetectorType == JAVA_DETECTOR) {
            if (mJavaDetector != null)
                mJavaDetector.detectMultiScale(mGray, faces, 1.3 , 2,2,new Size(),new Size());
               // mJavaDetector1.detectMultiScale(mGray, fire,   12, 2,12,new Size(),new Size());
        } else {
            Log.e("Levan", "Detection method is not selected!");
        }

        Rect[] facesArray = faces.toArray();
        Rect[] fireArray  = fire.toArray();

        if ((facesArray.length == 1)) {

            Mat m = new Mat();
            Rect r = facesArray[0];

            m = mRgba.submat(r);
            mBitmap = Bitmap.createBitmap(m.width(), m.height(),
                    Bitmap.Config.ARGB_8888);

            Utils.matToBitmap(m, mBitmap);
            // SaveBmp(mBitmap,"/sdcard/db/I("+countTrain+")"+countImages+".jpg");

        } else if ((facesArray.length > 0)) {
            Mat m = new Mat();
            m = mGray.submat(facesArray[0]);
            mBitmap = Bitmap.createBitmap(m.width(), m.height(),
                    Bitmap.Config.ARGB_8888);

            Utils.matToBitmap(m, mBitmap);
        }

        for (int i = 0; i < facesArray.length; i++) {
            Point center= new Point((facesArray[i].br().x+facesArray[i].tl().x)/2,(facesArray[i].br().y+facesArray[i].tl().y)/2);
            Core.rectangle(mRgba, facesArray[i].tl(), facesArray[i].br(), FACE_RECT_COLOR, 1);
           // Core.circle(mRgba, center, 3, FACE_RECT_COLOR, 3);
            //Core.putText(mRgba,"object"+i,facesArray[i].tl(),1,1,FACE_RECT_COLOR,1);
            if((check%3) ==0){
                if(center.x<(mRgba.width()/2-100)){
                    mOnvifService.requestPtzContinuousMoveLeft(serviceUrl, null);
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpResponse response = null;
                    try {
                        response = httpclient.execute(new HttpGet("http://lab411s.esy.es/sg/rx.php?data=SN:00000507"));
                        StatusLine statusLine = response.getStatusLine();
                        if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                            ByteArrayOutputStream out = new ByteArrayOutputStream();
                            response.getEntity().writeTo(out);
                            responseString = out.toString();

                            //Toast.makeText(getActivity(), responseString, Toast.LENGTH_SHORT).show();
                            out.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mOnvifService.requestStopPtzContinuousMove(serviceUrl, null);
                        }
                    }, 3000);
                }else if(center.x>(mRgba.width()/2+100)){
                    mOnvifService.requestPtzContinuousMoveRight(serviceUrl, null);
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpResponse response = null;
                    try {
                        response = httpclient.execute(new HttpGet("http://lab411s.esy.es/sg/rx.php?data=SN:00000507"));
                        StatusLine statusLine = response.getStatusLine();
                        if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                            ByteArrayOutputStream out = new ByteArrayOutputStream();
                            response.getEntity().writeTo(out);
                            responseString = out.toString();

                            // Toast.makeText(getActivity(), responseString, Toast.LENGTH_SHORT).show();
                            out.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mOnvifService.requestStopPtzContinuousMove(serviceUrl, null);
                        }
                    }, 3000);
                }

            }
            check++;
            if(check==10) check=0;


        }
        for (int i = 0; i < fireArray.length; i++) {
            Core.rectangle(mRgba, fireArray[i].tl(), fireArray[i].br(), new Scalar(255,0,0), 1);
            Core.putText(mRgba, "Fire", fireArray[i].tl(), 1, 1, new Scalar(255,0,0), 1);
        }

        Utils.matToBitmap(mRgba, result);
        return result;
    }
    public void Play() {
        try {
            mMediaPlayer = new io.vov.vitamio.MediaPlayer(getActivity());
            mMediaPlayer.setDataSource(videoPath);
            mMediaPlayer.setSurface(sss);

            // holder.setFixedSize(400, 320);
            // mMediaPlayer.setDisplay(holder);
            mMediaPlayer.prepareAsync();


            mMediaPlayer.prepare();
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                @Override
                public void onPrepared(MediaPlayer mp) {
                    // TODO Auto-generated method stub
                    Toast.makeText(getActivity(), "Prepared!",
                            Toast.LENGTH_SHORT).show();
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            mMediaPlayer.start();
                           // mVideoWidth=mMediaPlayer.getVideoWidth()*11/20;
                           // mVideoHeight=mMediaPlayer.getVideoHeight()*11/20;

                        }
                    });
                    thread.start();
                }
            });

        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private void playVideo() {

        // Create a new media player and set the listeners

        mMediaPlayer = new MediaPlayer(getActivity());
        try {
            mMediaPlayer.setDataSource(videoPath);
        } catch (IllegalArgumentException e) {
            Log.e("levan", e.toString());

        } catch (SecurityException e) {
            Log.e("levan", e.toString());
        } catch (IllegalStateException e) {
            Log.e("levan", e.toString());
        } catch (IOException e) {
            Log.e("levan", e.toString());
        }
        mMediaPlayer.setSurface(sss);
        mMediaPlayer.setDisplay(holder);
        mMediaPlayer.prepareAsync();

        mMediaPlayer.setOnBufferingUpdateListener(this);
        mMediaPlayer.setOnCompletionListener(this);
        mMediaPlayer.setOnPreparedListener(this);
        mMediaPlayer.setOnVideoSizeChangedListener(this);
        mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                switch (what) {
                    case MediaPlayer.MEDIA_INFO_FILE_OPEN_OK:
                        long buffersize = mMediaPlayer.audioTrackInit();
                        mMediaPlayer.audioInitedOk(buffersize);
                        break;
                    case MediaPlayer.MEDIA_INFO_UNKNOW_TYPE:
                        Log.e("XXX", " VITAMIO--TYPE_CHECK stype not include onInfo mediaplayer unknow type ");
                        break;

                    case MediaPlayer.MEDIA_INFO_BUFFERING_START:

                        mMediaPlayer.pause();
                        break;
                    case MediaPlayer.MEDIA_INFO_BUFFERING_END:

                        mMediaPlayer.start();
                        break;


                }
                return true;
            }
        });
        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);

    }
    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        sss = new Surface(surface);
        Log.e("Test", "Available");
        mRgba = new Mat();
        mGray = new Mat();
        mRgb = new Mat();
        mMOP2fptsPrev = new MatOfPoint2f();
        mMOP2fptsSafe = new MatOfPoint2f();
        mMOP2fptsThis = new MatOfPoint2f();
        matOpFlowThis = new Mat();
        matOpFlowThis = new Mat();
        matOpFlowPrev = new Mat();
        MOPcorners = new MatOfPoint();
        mMOBStatus = new MatOfByte();
        mMOFerr = new MatOfFloat();
        hsvImage = new Mat();
        bgrImage = new Mat();
        maskImage = new Mat();

    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

         Bitmap bmp = Bitmap.createBitmap(480, 360, Bitmap.Config.RGB_565);
         Canvas canvas = new Canvas(bmp);
        if (detectf) {
            tview.getBitmap(bmp);
            Bitmap result = ongetCameraFrame(bmp);
            Canvas c = holder.lockCanvas();
            if (canvas == null) {
                Log.e("Test", "Cannot draw onto the canvas as it's null");
            } else {

                c.drawBitmap(result, 0, 0, null);
                holder.unlockCanvasAndPost(c);
            }
        } else if (detect_motion) {
            tview.getBitmap(bmp);
            Bitmap result1 = opticalFlow(bmp);
            Canvas c = holder.lockCanvas();
            if (canvas == null) {
                Log.e("Test", "Cannot draw onto the canvas as it's null");
            } else {
                c.drawBitmap(result1, 0, 0, null);
                holder.unlockCanvasAndPost(c);
            }
        }
    }

    class GetResponseTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getActivity(), "lenh: " + s, Toast.LENGTH_SHORT).show();
            if (s.equals("van")) {
                mOnvifService.requestPtzContinuousMoveUp(serviceUrl, null);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mOnvifService.requestStopPtzContinuousMove(serviceUrl, null);
                    }
                }, 1000);
            } else {
                mOnvifService.requestPtzContinuousMoveDown(serviceUrl, null);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mOnvifService.requestStopPtzContinuousMove(serviceUrl, null);
                    }
                }, 1000);
            }
        }

        @Override
        protected String doInBackground(String... params) {

            String n = params[0];
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response;

            try {
                response = httpclient.execute(new HttpGet(n));
                StatusLine statusLine = response.getStatusLine();
                if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    response.getEntity().writeTo(out);
                    responseString = out.toString();

                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return responseString;
        }


        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mOnvifService = OnvifService.getInstance();
        Vitamio.isInitialized(getActivity());
//        if (!LibsChecker.checkVitamioLibs(getActivity()))
//            return;

        String url = getArguments().getString("service_url");
        String uri_rtsp = getArguments().getString("uri_rtsp");
        serviceUrl = "http://192.168.0.112:5000/onvif/device_service";
        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
        Dbug.w(tag, "url=" + url);
        if (!TextUtils.isEmpty(url)) {
            mOnvifService.requestPtzService(serviceUrl, new OnvifService.OnGetPtzServiceListener() {
                @Override
                public void onSuccess(List<PtzNode> serviceInfoList) {
                    if (serviceInfoList.size() > 0) {
                        Dbug.i(tag, "serviceInfoList size=" + serviceInfoList.size() + ", is home supported=" + serviceInfoList.get(0).isHomeSupported());
                    }
                }

                @Override
                public void onFailure(String message) {

                }
            });
        }
    }

    private Handler handler = new Handler();

    @Override
    public void onClick(View v) {
        if (v == ptzUp) {
            Dbug.i(tag, "on click= up");
            mOnvifService.requestPtzContinuousMoveUp(serviceUrl, null);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mOnvifService.requestStopPtzContinuousMove(serviceUrl, null);
                }
            }, 3000);
        } else if (ptzDown == v) {
            mOnvifService.requestPtzContinuousMoveDown(serviceUrl, null);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mOnvifService.requestStopPtzContinuousMove(serviceUrl, null);
                }
            }, 3000);
        } else if (v == ptzLeft) {
            mOnvifService.requestPtzContinuousMoveLeft(serviceUrl, null);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mOnvifService.requestStopPtzContinuousMove(serviceUrl, null);
                }
            }, 3000);
        } else if (v == ptzHome) {
           Play();
        } else if (v == btnSetPreset) {

            mOnvifService.requestPtzSetPreset(serviceUrl, null);
        } else if (v == ptzRight) {
            mOnvifService.requestPtzContinuousMoveRight(serviceUrl, null);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mOnvifService.requestStopPtzContinuousMove(serviceUrl, null);
                }
            }, 3000);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // if (!LibsChecker.checkVitamioLibs(getActivity()))
        //     return;
        Vitamio.isInitialized(getActivity());
        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);

    }




    public void onCompletion(MediaPlayer arg0) {

    }

    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
        mIsVideoSizeKnown = true;
        mVideoWidth = width;
        mVideoHeight = height;
        if (mIsVideoReadyToBePlayed && mIsVideoSizeKnown) {
            startVideoPlayback();
        }
    }

    public void onPrepared(MediaPlayer mediaplayer) {
        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
        mIsVideoReadyToBePlayed = true;
        if (mIsVideoReadyToBePlayed && mIsVideoSizeKnown) {
            startVideoPlayback();
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k) {
        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);

    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder) {

    }

    public void surfaceCreated(SurfaceHolder holder) {

       // playVideo();

    }

    @Override
    public void onPause() {
        super.onPause();
        releaseMediaPlayer();
        doCleanUp();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        releaseMediaPlayer();
        doCleanUp();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    private void doCleanUp() {
        mVideoWidth = 0;
        mVideoHeight = 0;
        mIsVideoReadyToBePlayed = false;
        mIsVideoSizeKnown = false;
    }

    private void startVideoPlayback() {

        holder.setFixedSize(640, 360);
        mMediaPlayer.start();
    }

    @Override
    public void onBufferingUpdate(MediaPlayer arg0, int arg1) {
        // TODO Auto-generated method stub

    }


}
