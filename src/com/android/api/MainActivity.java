package com.android.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button listButton;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        listButton = (Button)findViewById(R.id.to_list_view);
        listButton.setOnClickListener(click);
    }
    
    View.OnClickListener click = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.to_list_view:
				Intent list = new Intent(MainActivity.this,ManyGetView.class);
				startActivity(list);
				break;
			default:
				break;
			}
		}
	};
}