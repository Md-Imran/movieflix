package cine.emon.live.com.cinematic.activity;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import cine.emon.live.com.cinematic.R;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGetStart;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_reg, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_sign_in:
                Intent intent = new Intent(this, SignUpActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_help:
                // showHelp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get_start:
                Intent intentCreateAccount = new Intent(this, SignInActivity.class);
                startActivity(intentCreateAccount);
                break;
            default:
                break;
        }
    }

    private void initView() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView tvToolbarFont = (TextView) findViewById(R.id.toolbarText);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/28 Days Later.ttf");
        tvToolbarFont.setTypeface(font);
        tvToolbarFont.setText(getString(R.string.app_name));
        btnGetStart = (Button) findViewById(R.id.btn_get_start);
        btnGetStart.setOnClickListener(this);


    }

}
