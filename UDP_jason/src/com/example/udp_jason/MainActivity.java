package com.example.udp_jason;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		BroadCastUdp bcu = new BroadCastUdp("?ip");
		bcu.start();
		Log.v("thread", "start thread in main activity");
	}
	
	
}
