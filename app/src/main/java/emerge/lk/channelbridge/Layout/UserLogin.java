package emerge.lk.channelbridge.Layout;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import emerge.lk.channelbridge.R;



/**
 * Created by Himanshu on 12/22/2016.
 */

public class UserLogin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        ButterKnife.bind(this);


    }
    @OnClick(R.id.btn_login_login)
    public void logIn() {
        Intent i = new Intent(UserLogin.this, Home.class);
        Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
        finish();
        startActivity(i, bndlanimation);
    }

}
