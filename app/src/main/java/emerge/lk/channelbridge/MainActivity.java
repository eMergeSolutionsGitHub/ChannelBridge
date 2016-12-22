package emerge.lk.channelbridge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import lk.emerge.channelbridgesdialogs.Channelbridgesdialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Channelbridgesdialog(MainActivity.this, Channelbridgesdialog.WARNING_TYPE)
                .setTitleText("Delete")
                .setMessageText("Are you sure delete?")
                .setConfirmText("Yes")
                .setConfirmClickListener(new Channelbridgesdialog.OnClickListener() {
                    @Override
                    public void onClick(Channelbridgesdialog channelBridgesDialog) {
                        //Your Code
                        // channelBridgesDialog.cancel();
                    }
                })
                .show();

    }
}
