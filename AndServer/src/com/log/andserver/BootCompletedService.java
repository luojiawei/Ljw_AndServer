package com.log.andserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by rd0256 on 2017/6/28.
 */

public class BootCompletedService extends Service {

    private Intent mService;
    /**
     * Accept and server status.
     */
    private ServerStatusReceiver mReceiver;

    public BootCompletedService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        Log.d("AndServer", "BootCompletedService onCreate");
        // AndServer run in the service.
        mService = new Intent(this, CoreService.class);
        mReceiver = new ServerStatusReceiver(this);
        mReceiver.register();
        
        startService(mService);
    }

    public void startCoreService() {
        startService(mService);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        mReceiver.unRegister();
    }
}
