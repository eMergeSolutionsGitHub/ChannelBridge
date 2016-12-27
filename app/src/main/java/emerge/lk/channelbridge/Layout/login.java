package emerge.lk.channelbridge.Layout;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;


import emerge.lk.channelbridge.R;
import emerge.lk.channelbridge.databinding.LayoutLoginBinding;


/**
 * Created by Himanshu on 12/22/2016.
 */

public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        LayoutLoginBinding logingBinding = DataBindingUtil.setContentView(this, R.layout.layout_login);


        OnClickLoginHandler handler = new OnClickLoginHandler();
        logingBinding.setHandlers(handler);
    }

    public class OnClickLoginHandler {
        public void onUpdateLoginOnClick(View view) {
            Intent i = new Intent(Login.this, Home.class);
            Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
            finish();
            startActivity(i, bndlanimation);
        }
    }
}
