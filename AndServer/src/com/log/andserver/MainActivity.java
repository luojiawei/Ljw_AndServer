/*
 * Copyright © Yan Zhenjie. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.log.andserver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Yan Zhenjie on 2016/6/13.
 */
public class MainActivity extends Activity {

    private Intent mService;
    /**
     * Accept and server status.
     */
    private ServerStatusReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Intent itent = new Intent(this, BootCompletedService.class);
        startService(itent);
    }

    public void startCoreService() {
        startService(mService);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mReceiver.unRegister();
    }

}
