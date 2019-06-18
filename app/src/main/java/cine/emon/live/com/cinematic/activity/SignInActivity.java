package cine.emon.live.com.cinematic.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;



import cine.emon.live.com.cinematic.R;


public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText  edtPhoneNumber;
    private TextView tvSignUp;
    private Button btnSignUpOrSingIn;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initView();
    }


    @Override
    protected void onResume() {
        super.onResume();

    }


    private void initView() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView tvToolbarFont = (TextView) findViewById(R.id.toolbarText);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/28 Days Later.ttf");
        tvToolbarFont.setTypeface(font);
        tvToolbarFont.setText(getString(R.string.app_name));

        progressBar = findViewById(R.id.progress_bar);

        progressBar.getIndeterminateDrawable()
                .setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);


        edtPhoneNumber = (EditText) findViewById(R.id.edt_phone_number);
        // edtCountyCode = (EditText) findViewById(R.id.edt_county_code);
        tvSignUp = (TextView) findViewById(R.id.tv_sign_up);
        //tvSignUp.setPaintFlags(tvSignUp.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        btnSignUpOrSingIn = (Button) findViewById(R.id.btn_sign_in);
        btnSignUpOrSingIn.setOnClickListener(this);
        tvSignUp.setOnClickListener(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign_in:
                startActivity(new Intent(this, MainActivity.class));

                break;
            case R.id.tv_sign_up:
                startActivity(new Intent(this, SignUpActivity.class));
                break;

        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here
                item.setIcon(R.drawable.ic_left_arrow);
               /* Intent intent = new Intent(this,
                        UserBillingActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();*/
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
