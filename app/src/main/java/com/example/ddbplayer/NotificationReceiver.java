package com.example.ddbplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


import static com.example.ddbplayer.ApplicationClass.ACTION_NEXT;
import static com.example.ddbplayer.ApplicationClass.ACTION_PLAY;
import static com.example.ddbplayer.ApplicationClass.ACTION_PREVIOUS;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String actionName = intent.getAction();
        Intent serviceIntent = new Intent(context,MusicService.class);
        if (actionName != null){
            switch (actionName){
                case ACTION_PLAY:
                    serviceIntent.putExtra("ActionName","playPause");
                    context.startActivity(serviceIntent);
                    break;
                case ACTION_NEXT:
                    serviceIntent.putExtra("ActionName","next");
                    context.startActivity(serviceIntent);
                    break;
                case ACTION_PREVIOUS:
                    serviceIntent.putExtra("ActionName","previous");
                    context.startActivity(serviceIntent);
                    break;
            }
        }
    }
}
