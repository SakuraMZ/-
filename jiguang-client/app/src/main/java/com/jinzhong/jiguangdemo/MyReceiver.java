package com.jinzhong.jiguangdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by ${sheldon} on 2018/6/13.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(JPushInterface.ACTION_MESSAGE_RECEIVED)){
                Bundle extras = intent.getExtras();
                String title = extras.getString(JPushInterface.EXTRA_TITLE);
                String message = extras.getString(JPushInterface.EXTRA_MESSAGE);
                Toast.makeText(context, "标题"+title+"内容"+message, Toast.LENGTH_SHORT).show();
            } else if (intent.getAction().equals(JPushInterface.ACTION_NOTIFICATION_OPENED)){
                Intent intent1=new Intent(context,JiguangActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);
            }
    }
}
