package com.example.volleyproject;

import org.json.JSONArray;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//start volley jason request
		RequestQueue mQuene=Volley.newRequestQueue(this);
		JsonArrayRequest json805 = new JsonArrayRequest("http://ilab.tongji.edu.cn/pm25/web/restful/device-datas?devid=1000-A215&time_point=2015-08-26",
	            new Response.Listener<JSONArray>() {
	                @Override
	                public void onResponse(JSONArray response) {
	                    Log.d("polution", response.toString());
	                
	                }
	            }, new Response.ErrorListener() {
	        @Override
	        public void onErrorResponse(VolleyError error) {
	            Log.d("TAG", "Error: " + error.getMessage());
	        }
	    });	
		
		

		
		mQuene.add(json805);
		mQuene.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
