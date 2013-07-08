/*
* The MIT License (MIT)
*
* Copyright (c) 2013 Alexandro Blanco Santana
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
 */
package org.blanco.android.addex;

import android.app.Activity;
import android.os.Bundle;
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

    @Override
    protected void onStart() {
        TapContextSDK adsContext = new TapContextSDK(getApplicationContext());
        adsContext.initialize();
        adsContext.showAd();
        super.onStart();
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
