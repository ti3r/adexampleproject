package org.blanco.android.addex;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tapcontext.AdCallback;
import com.tapcontext.TapContextSDK;

public class MainActivity extends Activity {

    TapContextSDK adsContext;
    Button btnShowAd;
    Button btnShowAdCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowAd = (Button) findViewById(R.id.btn_show_ad);
        btnShowAdCallBack = (Button) findViewById(R.id.btn_show_add_call_back);
        adsContext = new TapContextSDK(getApplicationContext());
        adsContext.initialize();
    }

    public void onBtnShowAdClicked(View view){
        if (view == btnShowAd){
            adsContext.showAd("Mensaje de Prueba");
        }else if (view == btnShowAdCallBack) {
                adsContext.showAd(new AdCallback() {
                    @Override
                    public void onAdNotShown() {
                        Toast.makeText(MainActivity.this, "Mensaje no mostrado",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
