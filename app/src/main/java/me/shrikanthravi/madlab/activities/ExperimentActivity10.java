package me.shrikanthravi.madlab.activities;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import me.shrikanthravi.madlab.HomeActivity;
import me.shrikanthravi.madlab.R;

public class ExperimentActivity10 extends AppCompatActivity {

    EditText writeET;
    Button notifyBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment10);

        //Initialization
        init();

        notifyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(writeET.getText().toString().trim().length()!=0){
                    notifyMessage(writeET.getText().toString().trim());
                }else {
                    Toast.makeText(getApplicationContext(),"Blank text !",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void init(){
        //Hiding action bar that displays app name
        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }

        //Linking xml views with java
        notifyBTN = findViewById(R.id.notifyBTN);
        writeET = findViewById(R.id.writeET);
    }

    void notifyMessage(String message){
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId = 1;
        String channelId = "channel-01";
        String channelName = "Channel Name";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), channelId)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("New message")
                .setContentText(message);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
        stackBuilder.addNextIntent(new Intent(getApplicationContext(),HomeActivity.class));
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
                0,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        mBuilder.setContentIntent(resultPendingIntent);

        notificationManager.notify(notificationId, mBuilder.build());
    }
}
