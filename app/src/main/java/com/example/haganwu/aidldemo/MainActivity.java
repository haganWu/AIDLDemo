package com.example.haganwu.aidldemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvMsg;
    private IBankAIDL bankBinder;//服务器端的Binder对象
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            bankBinder = IBankAIDL.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        final Intent intent = new Intent(this,BankService.class);
        bindService(intent,connection,BIND_AUTO_CREATE);
    }

    private void init() {
        tvMsg = (TextView) findViewById(R.id.tvMsg);
        findViewById(R.id.open_account).setOnClickListener(this);
        findViewById(R.id.save_money).setOnClickListener(this);
        findViewById(R.id.take_money).setOnClickListener(this);
        findViewById(R.id.close_account).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.open_account:
                try {
                    tvMsg.setText(bankBinder.openAccount("wuhaihengyydy@126.com","123456"));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.save_money:
                try {
                    tvMsg.setText(bankBinder.saveMoney(123456,"wuhaihengyydy@126.com"));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.take_money:
                try {
                    tvMsg.setText(bankBinder.takeMoney(123456,"wuhaihengyydy@126.com","123456"));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.close_account:
                try {
                    tvMsg.setText(bankBinder.closeAccount("wuhaihengyydy@126.com","123456"));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
