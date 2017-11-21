package com.log.andserver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by rd0256 on 2017/6/28.
 */

public class BootCompletedReceiver extends BroadcastReceiver {

    private final static String BOOT_COMPLETE_ACTION = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

        String action = intent.getAction();
        Log.d("AndServer", "action:" + action);
        if (action.equals(BOOT_COMPLETE_ACTION)) {
            // start up serverservice
            Intent itent = new Intent(context, BootCompletedService.class);
            context.startService(itent);
        }
    }
}
