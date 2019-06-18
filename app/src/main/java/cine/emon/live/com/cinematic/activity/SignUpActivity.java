package cine.emon.live.com.cinematic.activity;



import android.content.Intent;
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


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtCountyCode, edtUserName, edtPhoneNumber;
    private Button btnSignUpOrSingIn;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void initView() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

       /* progressBar = findViewById(R.id.progress_bar);
        progressBar.getIndeterminateDrawable()
                .setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
*/
        TextView tvToolbarFont = (TextView) findViewById(R.id.toolbarText);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/28 Days Later.ttf");
        tvToolbarFont.setTypeface(font);
        tvToolbarFont.setText(getString(R.string.app_name));

        edtUserName = (EditText) findViewById(R.id.edt_user_name);
        edtPhoneNumber = (EditText) findViewById(R.id.edt_phone_number);
        btnSignUpOrSingIn = (Button) findViewById(R.id.btn_sign_in);
        btnSignUpOrSingIn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign_in:
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
                break;

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here
                item.setIcon(R.drawable.ic_left_arrow);
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
