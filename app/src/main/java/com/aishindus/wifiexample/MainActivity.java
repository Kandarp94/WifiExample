package com.aishindus.wifiexample;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    WifiManager wm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);


        wm = (WifiManager) getSystemService(WIFI_SERVICE);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                wm.setWifiEnabled(true);
                Toast.makeText(MainActivity.this, "Wifi is ON", Toast.LENGTH_SHORT).show();
                WifiInfo info = wm.getConnectionInfo();
                String name = info.getMacAddress();
                int nid = info.getNetworkId();
                int strength = WifiManager.calculateSignalLevel(info.getRssi(), 10);
                Toast.makeText(MainActivity.this, "Mac Address: "+name+"\nId: "+nid+
                        "\nStrength: "+strength, Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                wm.setWifiEnabled(false);
                Toast.makeText(MainActivity.this, "Wifi is ON", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
