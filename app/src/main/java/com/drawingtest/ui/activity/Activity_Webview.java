package com.drawingtest.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.drawingtest.R;
import com.google.android.material.navigation.NavigationView;

public class Activity_Webview extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private WebView webView;
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer= findViewById(R.id.drawer_web);

        NavigationView navigationView= findViewById(R.id.nav_view_web);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle( this, drawer,toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.view_menu);
        }

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://ww1.putlockers.movie/putlocker");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
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
}

