package com.jinzhong.jiguangdemo;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.guo.android_extend.image.ImageConverter;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.Cipher;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import static android.graphics.Bitmap.createBitmap;
import static android.os.BatteryManager.BATTERY_PLUGGED_AC;
import static android.os.BatteryManager.BATTERY_PLUGGED_USB;

public class ApplyMainActivity  {

    private int afCode = -1;
    SurfaceView mPreview;
    SurfaceHolder mHolder;
    private int cameraPosition = 0;
    Context context;
    final String SEND_SUCCESS_ACITON = "SEND_SUCCESS_ACITON";
    final String ACCEPT_SUCCESS_ACITON = "ACCEPT_SUCCESS_ACITON";
    boolean flag = false;
    private int buttonCount=1;
    Camera camera;
    Camera mcamera;
    private boolean ischange=false;//电源插拔状态
    int screenWidth,screenHeight;
    boolean isPreview = false; // 是否在浏览中
    private String ipname;
    int pic_name = 1;
    int handle_name = 1;
    int email_num = 1;
    int a = 1;
    private String phone_num;
    OkHttpClient _okHttpClient = new OkHttpClient();
    public  String myTime;
    public Cipher cipher;
    public String PASSWORD;
    // private Camera.Size previewSize;
//    private String mBaseUrl="http://112.74.61.24:8080/ServletTest/";
    private String mBaseUrl="https://112.74.61.24:8443/ServletTest/";
    private String mBaseUrl1="https://localhost:8080/webservice/";
    static {
        System.loadLibrary("opencv_java3");
        System.loadLibrary("opencv_java");
        System.loadLibrary("native-lib");
    }
    public void sendM()
    {
        FormEncodingBuilder requestBodyBuilder = new FormEncodingBuilder();
        RequestBody requestBody = requestBodyBuilder.add("Alis", (phone_num)).add("TIME", myTime).build();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(mBaseUrl1 + "AESPasswordServlet").post(requestBody).build(); //aesSERVLET
        Call call = _okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

            }
        });
    }
    }
