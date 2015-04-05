package com.example.flipclocktimer;

import java.util.Random;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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

	private int h_current = -1;
	private int m1_current = -1;
	private int m2_current = -1;
	private int s1_current = -1;
	private int s2_current = -1;

	public void flip(int changeNumber) {
		int upperBackId = R.id.up_back;
		ImageView up_back = (ImageView) findViewById(upperBackId);
		Drawable img = up_back.getDrawable();
		ImageView up = (ImageView) findViewById(R.id.up);
		up.setImageDrawable(img);
		up.setVisibility(View.VISIBLE);

		final ImageView down = (ImageView) findViewById(R.id.down);
		// down.getLayoutParams().height = 0;
		down.setVisibility(View.VISIBLE);

		int resId = getResources().getIdentifier("up_" + changeNumber,
				"drawable", getPackageName());
		Drawable image = getResources().getDrawable(resId);
		up_back.setImageDrawable(image);

		resId = getResources().getIdentifier("down_" + changeNumber,
				"drawable", getPackageName());
		image = getResources().getDrawable(resId);
		down.setImageDrawable(image);

		Animation anim = new ScaleAnimation(1f, 1f, // Start and end values for
													// the X axis scaling
				1f, 0f, // Start and end values for the Y axis scaling
				Animation.RELATIVE_TO_SELF, 0f, // Pivot point of X scaling
				Animation.RELATIVE_TO_SELF, 1f); // Pivot point of Y scaling
		anim.setFillAfter(true); // Needed to keep the result of the animation
		anim.setDuration(100);
		anim.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				Animation anim = new ScaleAnimation(1f, 1f, 0f, 1f,
						Animation.RELATIVE_TO_SELF, 0f,
						Animation.RELATIVE_TO_SELF, 0f);
				anim.setFillAfter(true); // Needed to keep the result of the
											// animation
				anim.setDuration(200);
				down.startAnimation(anim);

			}
		});
		up.startAnimation(anim);

	}// end flip

	public void check(View v) {
		Random r = new Random();
		int num = r.nextInt() % 10;
		if (num < 0) {
			num = -(num);
		}
		System.out.println(num);
		try {
			flip(num);
		} catch (Exception e) {
		}
	}
}
