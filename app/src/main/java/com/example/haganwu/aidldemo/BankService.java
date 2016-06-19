package com.example.haganwu.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by haganwu on 16/6/19.
 */

public class BankService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new BankBinder();
    }
}
