package pungfaye.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {

//	private Button myAdapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		findViews();
//		setLIsteners();
	}

//	private void findViews() {
//
//		myAdapter = (Button) findViewById(R.id.view_btn);
//	}

//	private void setLIsteners() {
//		myAdapter.setOnClickListener(myAdapterBtnListener);
//	}

//	private View.OnClickListener myAdapterBtnListener = new View.OnClickListener() {
//
//		@Override
//		public void onClick(View v) {
//			Log.v("MainActivity", "myAdapter");
//			Intent intent = new Intent(Main.this, MainActivity.class);
//			startActivity(intent);
//		}
//	};

}