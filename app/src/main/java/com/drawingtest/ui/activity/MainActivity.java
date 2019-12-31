package com.drawingtest.ui.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import org.xdty.preference.colorpicker.ColorPickerDialog;
import org.xdty.preference.colorpicker.ColorPickerSwatch;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.drawingtest.R;
import com.drawingtest.domain.manager.FileManager;
import com.drawingtest.domain.manager.PermissionManager;
import com.drawingtest.ui.component.DrawingView;
import com.drawingtest.ui.dialog.StrokeSelectorDialog;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener
{
	@Bind(R.id.main_drawing_view) DrawingView mDrawingView;
	@Bind(R.id.main_fill_iv) ImageView mFillBackgroundImageView;
	@Bind(R.id.main_color_iv) ImageView mColorImageView;
	@Bind(R.id.main_stroke_iv) ImageView mStrokeImageView;
	@Bind(R.id.main_undo_iv) ImageView mUndoImageView;
	@Bind(R.id.main_redo_iv) ImageView mRedoImageView;
	@Bind(R.id.drawgrid) ImageView mDrawgrid;

	private int mCurrentBackgroundColor;
	private int mCurrentColor;
	private int mCurrentStroke;
	private static final int MAX_STROKE_WIDTH = 50;
	private Canvas canvas = new Canvas();
	private Paint rPaint = new Paint();
	private DrawerLayout drawer;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);


		setContentView(R.layout.activity_main);

		ButterKnife.bind(this);

		initDrawingView();

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

		drawer= findViewById(R.id.drawer_layout);
		NavigationView navigationView= findViewById(R.id.nav_view);
		 navigationView.setNavigationItemSelectedListener(this);

		ActionBarDrawerToggle toggle= new ActionBarDrawerToggle( this, drawer,toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();
		if (savedInstanceState == null) {
			navigationView.setCheckedItem(R.id.view_grid);
		}


	}

	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item){
		switch (item.getItemId()) {
			case R.id.view_grid:
				Intent intent = new Intent(this,CreateGrid.class);
				startActivity(intent);
				break;
			case R.id.view_canvas:
				Intent intent1 = new Intent(this,DrawShapes.class);
				startActivity(intent1);
				break;
			case R.id.view_menu:
				Intent intent2 = new Intent(this,MainMenu.class);
				startActivity(intent2);
				break;

			case R.id.about:
				Intent intent3 = new Intent(this,About.class);
				startActivity(intent3);
				break;

			case R.id.webview:
				Intent intent4 = new Intent(this, Activity_Webview.class);
				startActivity(intent4);
				break;

			case R.id.movies:
				Intent intent5 = new Intent(this,Movies.class);
				startActivity(intent5);
				break;

            case R.id.calculator:
                Intent intent6 = new Intent(this,Calculator.class);
                startActivity(intent6);
                break;


            case R.id.share:
				Intent shareIntent = new Intent();
				shareIntent.setAction(Intent.ACTION_SEND);
				shareIntent.setType("text/plain");
				startActivity(shareIntent);
				Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
				break;
			case R.id.send:
				Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
				emailIntent.setData(Uri.parse("mailto:djdashize@gmail.com"));
				startActivity(emailIntent);
				Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
				break;
		}

		drawer.closeDrawer(GravityCompat.START);

		return true;

	}



	@Override
	public void onBackPressed() {
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.action_share:
				requestPermissionsAndSaveBitmap();
				break;
			case R.id.action_clear:
				mDrawingView.clearCanvas();
				break;
            case R.id.action_settings:
                startActivity(new Intent(this, CanvasSettings.class));
                return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private void initDrawingView()
	{
		mCurrentBackgroundColor = ContextCompat.getColor(this, android.R.color.white);
		mCurrentColor = ContextCompat.getColor(this, android.R.color.black);
		mCurrentStroke = 10;

		mDrawingView.setBackgroundColor(mCurrentBackgroundColor);
		mDrawingView.setPaintColor(mCurrentColor);
		mDrawingView.setPaintStrokeWidth(mCurrentStroke);
	}

	private void startFillBackgroundDialog()
	{
		int[] colors = getResources().getIntArray(R.array.palette);

		ColorPickerDialog dialog = ColorPickerDialog.newInstance(R.string.color_picker_default_title,
				colors,
				mCurrentBackgroundColor,
				5,
				ColorPickerDialog.SIZE_SMALL);

		dialog.setOnColorSelectedListener(new ColorPickerSwatch.OnColorSelectedListener()
		{

			@Override
			public void onColorSelected(int color)
			{
				mCurrentBackgroundColor = color;
				mDrawingView.setBackgroundColor(mCurrentBackgroundColor);
			}

		});

		dialog.show(getFragmentManager(), "ColorPickerDialog");
	}

	private void startColorPickerDialog()
	{
		int[] colors = getResources().getIntArray(R.array.palette);

		ColorPickerDialog dialog = ColorPickerDialog.newInstance(R.string.color_picker_default_title,
				colors,
				mCurrentColor,
				5,
				ColorPickerDialog.SIZE_SMALL);

		dialog.setOnColorSelectedListener(new ColorPickerSwatch.OnColorSelectedListener()
		{

			@Override
			public void onColorSelected(int color)
			{
				mCurrentColor = color;
				mDrawingView.setPaintColor(mCurrentColor);
			}

		});

		dialog.show(getFragmentManager(), "ColorPickerDialog");
	}

		private void startStrokeSelectorDialog()
		{
			StrokeSelectorDialog dialog = StrokeSelectorDialog.newInstance(mCurrentStroke, MAX_STROKE_WIDTH);

			dialog.setOnStrokeSelectedListener(new StrokeSelectorDialog.OnStrokeSelectedListener()
			{
				@Override
				public void onStrokeSelected(int stroke)
				{
					mCurrentStroke = stroke;
					mDrawingView.setPaintStrokeWidth(mCurrentStroke);
				}
			});

			dialog.show(getSupportFragmentManager(), "StrokeSelectorDialog");
		}

		private void startShareDialog(Uri uri)
		{
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_SEND);
			intent.setType("image/*");

			intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "");
			intent.putExtra(android.content.Intent.EXTRA_TEXT, "");
			intent.putExtra(Intent.EXTRA_STREAM, uri);
			startActivity(Intent.createChooser(intent, "Share Image"));
		}

		private void requestPermissionsAndSaveBitmap()
		{
			if (PermissionManager.checkWriteStoragePermissions(this))
			{
				Uri uri = FileManager.saveBitmap(mDrawingView.getBitmap());
				startShareDialog(uri);
			}
		}


		@Override
		public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
		{
			super.onRequestPermissionsResult(requestCode, permissions, grantResults);
			switch (requestCode)
			{
				case PermissionManager.REQUEST_WRITE_STORAGE:
				{
					if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
					{
						Uri uri = FileManager.saveBitmap(mDrawingView.getBitmap());
						startShareDialog(uri);
					} else
					{
						Toast.makeText(this, "The app was not allowed to write to your storage. Hence, it cannot function properly. Please consider granting it this permission", Toast.LENGTH_LONG).show();
					}
				}
			}
		}

		@OnClick(R.id.main_fill_iv)
		public void onBackgroundFillOptionClick()
		{
			startFillBackgroundDialog();
		}

		@OnClick(R.id.main_color_iv)
		public void onColorOptionClick()
		{
			startColorPickerDialog();
		}

		@OnClick(R.id.main_stroke_iv)
		public void onStrokeOptionClick()
		{
			startStrokeSelectorDialog();
		}

		@OnClick(R.id.main_undo_iv)
		public void onUndoOptionClick()
		{
			mDrawingView.undo();
		}

		@OnClick(R.id.main_redo_iv)
		public void onRedoOptionClick()
		{
			mDrawingView.redo();
		}

		@OnClick (R.id.drawgrid)
		public void OnDrawRectangle(View view) {
			openActivity();
		}

		public void openActivity(){
			Intent intent = new Intent(this,CreateGrid.class);
			startActivity(intent);
		}




	}
