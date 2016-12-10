package com.hhbgk.webservice.discovery.ui.fragment;

import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hhbgk.webservice.discovery.R;
import com.hhbgk.webservice.discovery.data.model.PtzNode;
import com.hhbgk.webservice.discovery.onvif.OnvifService;
import com.hhbgk.webservice.discovery.util.Dbug;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

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
public class PtzFragment extends Fragment implements View.OnClickListener, SurfaceHolder.Callback, MediaPlayer.OnPreparedListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnVideoSizeChangedListener {
    private String tag = getClass().getSimpleName();
    private static List<PtzNode> mPtzNodeList;
    private Button ptzUp, ptzDown, ptzLeft, ptzRight, ptzHome,btn_preset,btn_getPreset;
    private OnvifService mOnvifService;
    private String serviceUrl,uri_rtsp;
    private io.vov.vitamio.widget.VideoView videoView;
    private int mVideoWidth = 160;
    private int mVideoHeight = 90;
    private MediaPlayer mMediaPlayer;
    private SurfaceView mPreview;
    private AudioManager audioManager;
    private SurfaceHolder holder;
    private String videoPath = "rtsp://hellboy1994.ddns.net:554/onvif1";
    private boolean mIsVideoSizeKnown = false;
    private boolean mIsVideoReadyToBePlayed = false;
    private Camera.PictureCallback jpegCallback;
    private Camera camera;
    private View v1;
    private Bitmap bitmap;
    public static PtzFragment newInstance(String serviceUrl) {
        Dbug.e("PtzFragment", "service url=" + serviceUrl);
        PtzFragment fragment = new PtzFragment();
        Bundle bundle = new Bundle();
        bundle.putString("service_url", serviceUrl);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ptz_layout, container, false);
        Vitamio.isInitialized(getActivity());
        view.setKeepScreenOn(true);

        ptzUp = (Button) view.findViewById(R.id.ptz_up);
        ptzUp.setOnClickListener(this);
        ptzDown = (Button) view.findViewById(R.id.ptz_down);
        ptzDown.setOnClickListener(this);
        ptzHome = (Button) view.findViewById(R.id.ptz_home);
       // ptzHome.setOnClickListener(this);
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
        mPreview = (SurfaceView) view.findViewById(R.id.surfaceView);
        holder = mPreview.getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        holder.setFormat(PixelFormat.RGBA_8888);
        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
        ptzHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View v1=getView().getRootView();
                v1.setDrawingCacheEnabled(true);
                bitmap=v1.getDrawingCache();
                String root = Environment.getExternalStorageDirectory().toString();
                File myDir = new File(root + "/saved_images");
                myDir.mkdirs();
                Random generator = new Random();
                int n = 10000;
                n = generator.nextInt(n);
                String fname = "Image-"+ n +".jpg";
                File file = new File (myDir, fname);
                if (file.exists ()) file.delete ();
                try {
                    FileOutputStream out = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
                    out.flush();
                    out.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mOnvifService = OnvifService.getInstance();
        Vitamio.isInitialized(getActivity());
//        if (!LibsChecker.checkVitamioLibs(getActivity()))
//            return;

        String url = getArguments().getString("service_url");
        String uri_rtsp= getArguments().getString("uri_rtsp");
        serviceUrl = "http://hellboy1994.ddns.net:5000/onvif/device_service";
        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
        Dbug.w(tag, "url=" + url);
        if (!TextUtils.isEmpty(url)) {
            mOnvifService.requestPtzService(url, new OnvifService.OnGetPtzServiceListener() {
                @Override
                public void onSuccess(List<PtzNode> serviceInfoList) {
                    if (serviceInfoList.size() > 0) {
                        Dbug.i(tag, "serviceInfoList size=" + serviceInfoList.size() + ", is home supported="+ serviceInfoList.get(0).isHomeSupported());
                    }
                }

                @Override
                public void onFailure(String message) {

                }
            });
        }
    }

    private final Handler handler = new Handler();

    @Override
    public void onClick(View v) {
        if (v == ptzUp) {
            Dbug.i(tag, "on click= up");
            mOnvifService.requestPtzContinuousMoveUp(serviceUrl, null);
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    mOnvifService.requestStopPtzContinuousMove(serviceUrl, null);
//                }
//            }, 3000);
        } else if (ptzDown == v) {
            mOnvifService.requestPtzContinuousMoveDown(serviceUrl, null);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mOnvifService.requestStopPtzContinuousMove(serviceUrl, null);
                }
            }, 3000);
        } else if (v == ptzHome) {


        } else if (v == ptzLeft) {
            mOnvifService.requestPtzContinuousMoveLeft(serviceUrl, null);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mOnvifService.requestStopPtzContinuousMove(serviceUrl, null);
                }
            }, 3000);
        } else if (v == ptzRight) {
            mOnvifService.requestPtzContinuousMoveRight(serviceUrl, null);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mOnvifService.requestStopPtzContinuousMove(serviceUrl, null);
                }
            }, 3000);
        } else if (v == btn_preset) {
            mOnvifService.requestPtzGotoPreset(serviceUrl, null);

        }else if (v == btn_getPreset) {
            mOnvifService.requestPtzGetPreset(serviceUrl, null);

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

    private void playVideo(){

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
                    case MediaPlayer.MEDIA_INFO_FILE_OPEN_OK :
                        long buffersize=mMediaPlayer.audioTrackInit();
                        mMediaPlayer.audioInitedOk(buffersize);
                        break;
                    case MediaPlayer.MEDIA_INFO_UNKNOW_TYPE:
                        Log.e("XXX"," VITAMIO--TYPE_CHECK stype not include onInfo mediaplayer unknow type ");
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

        playVideo();

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

        holder.setFixedSize(mVideoWidth, mVideoHeight);
        mMediaPlayer.start();
    }

    @Override
    public void onBufferingUpdate(MediaPlayer arg0, int arg1) {
        // TODO Auto-generated method stub

    }





}
