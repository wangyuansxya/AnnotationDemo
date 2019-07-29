package com;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

/**
 * Created by wangyuan on 2017/2/27.
 * 处理耳机和扬声器相关广播
 */
public final class NetworkConnectHelper {

    private NetworkConnectReceiver mReceiver;

    public void registerHeadsetPlugReceiver(Activity activity, NetworkChangeListener l) {
        addSdkCallback(l);
        if (mReceiver == null) mReceiver = new NetworkConnectReceiver();
        mReceiver.setListener(mListeners);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        activity.registerReceiver(mReceiver, intentFilter);
    }

    public void unRegisterHeadsetPlugReceiver(Activity activity, NetworkChangeListener l) {
        removeSdkCallback(l);
        if (mReceiver == null) return;
        activity.unregisterReceiver(mReceiver);
    }

    private static class NetworkConnectReceiver extends BroadcastReceiver {
        private static final String TAG = "NetworkConnectReceiver";
        private WeakContainer<NetworkChangeListener> mListeners;

        public void setListener(WeakContainer<NetworkChangeListener> mListeners) {
            this.mListeners = mListeners;
        }

        int connCount = 0;

        int disConnCount = 0;

        private boolean mLastState = false;

        @Override
        public void onReceive(Context context, Intent intent) {
            //获取manager
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            //获取wifi状态
//            NetworkInfo.State state1 = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
//            NetworkInfo.State state2 = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
//            boolean isAvailable = (state1 == NetworkInfo.State.CONNECTED) || (state2 == NetworkInfo.State.CONNECTED);
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            boolean isAvailable = info == null ? false : info.isConnected();
            if(mLastState == isAvailable)return;
            mLastState = isAvailable;
            if (isAvailable) {
                Toast.makeText(context, "网络已连接" + connCount, Toast.LENGTH_SHORT).show();
                connCount++;
            } else /*if (state == NetworkInfo.State.CONNECTED)*/ {
                Toast.makeText(context, "网络已断开连接" + disConnCount, Toast.LENGTH_SHORT).show();
                disConnCount++;
            }
            if (mListeners != null && mListeners.size() > 0) {
                for (NetworkChangeListener cb : mListeners) {
                    if (cb != null) {
                        cb.onNetworkChange(isAvailable);
                    }
                }
            }
        }
    }

    private WeakContainer<NetworkChangeListener> mListeners;

    private void addSdkCallback(NetworkChangeListener cb) {
        if(cb == null)return;
        if (mListeners == null) {
            mListeners = new WeakContainer<>();
        }
        mListeners.add(cb);

    }

    private void removeSdkCallback(NetworkChangeListener cb) {
        if(cb == null)return;
        if (mListeners == null) {
            return;
        }
        mListeners.remove(cb);
    }

    public interface NetworkChangeListener {
        void onNetworkChange(boolean state);
    }
}
