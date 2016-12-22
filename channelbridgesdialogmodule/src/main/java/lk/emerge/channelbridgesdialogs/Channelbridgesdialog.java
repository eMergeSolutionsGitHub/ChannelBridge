package lk.emerge.channelbridgesdialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Himanshu on 11/17/2016.
 */

public class Channelbridgesdialog extends Dialog implements View.OnClickListener {

    private View mDialogView;
    TextView txtTitle, txtMessage, txtLoading;
    TextViewFontAwesome txtIcon;
    private String mTitleText, mMessageText, bConfirmBtnText = "OK", bCancelBtnText = "CANCEL", pLoadingText = "Loading";
    private RelativeLayout layoutMain, layoutMargin, layoutMarginTop, layoutProgressBar;
    Boolean cancelableStatus = false;


    int errorType, btnStstus = 0, titelStatus = 0, messageStatus = 0;
    Context mContext;


    private OnClickListener mConfirmClickListener;
    private OnClickListener mCancelClickListener;

    private Button mOKButton;
    private Button mCancelButton;


    public static final int NORMAL_TYPE = 0;
    public static final int ERROR_TYPE = 1;
    public static final int SUCCESS_TYPE = 2;
    public static final int WARNING_TYPE = 3;
    public static final int PROGRESS_TYPE = 4;


    public Channelbridgesdialog(Context context) {
        super(context);
        mContext = context;
    }

    public static interface OnClickListener {
        public void onClick(Channelbridgesdialog channelBridgesDialog);
    }

    public Channelbridgesdialog(Context context, int alertType) {
        super(context);
        errorType = alertType;
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //before
        setContentView(R.layout.layout_main);

        mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        txtTitle = (TextView) findViewById(R.id.textView_Titel);
        txtMessage = (TextView) findViewById(R.id.textView_Message);
        txtLoading = (TextView) findViewById(R.id.textView_Loading);


        txtIcon = (TextViewFontAwesome) findViewById(R.id.textViewErrorIcon);
        mOKButton = (Button) findViewById(R.id.btn_ok);
        mOKButton.setOnClickListener(this);

        mCancelButton = (Button) findViewById(R.id.btn_no);
        mCancelButton.setOnClickListener(this);


        layoutMain = (RelativeLayout) findViewById(R.id.relativelayoutmain);
        layoutMargin = (RelativeLayout) findViewById(R.id.relativelayout_margin);
        layoutMarginTop = (RelativeLayout) findViewById(R.id.relativelayout_marginTop);
        layoutProgressBar = (RelativeLayout) findViewById(R.id.relativelayout_progressBar);

        setBackgroundColor(errorType);

        if (errorType == 4) {
            layoutProgressBar.setVisibility(View.VISIBLE);
            layoutMarginTop.setVisibility(View.GONE);
        } else {
            layoutProgressBar.setVisibility(View.GONE);
            layoutMarginTop.setVisibility(View.VISIBLE);
        }

        setTextStatus();
        setTitleText(mTitleText);
        setMessageText(mMessageText);
        setConfirmText(bConfirmBtnText);
        setCancelText(bCancelBtnText);
        setLoadingText(pLoadingText);
        setDialogCancelable(cancelableStatus);
        setLayout(errorType);
        setButtonOntuch();



    }


    public Channelbridgesdialog setLoadingText(String text) {
        pLoadingText = text;
        if (txtLoading != null && pLoadingText != null) {
            txtLoading.setText(pLoadingText);
        }
        return this;
    }


    public Channelbridgesdialog setCancelLoading() {
        dismiss();
        return this;
    }


    public Channelbridgesdialog setDialogCancelable(Boolean cancelable) {

        cancelableStatus = cancelable;
        setCancelable(cancelableStatus);
        return this;
    }

    public Channelbridgesdialog setTitleText(String text) {
        mTitleText = text;
        titelStatus = 1;
        if (txtTitle != null && mTitleText != null) {
            txtTitle.setText(mTitleText);
        }
        return this;
    }

    public Channelbridgesdialog setMessageText(String text) {
        mMessageText = text;
        messageStatus = 1;
        if (txtMessage != null && mMessageText != null) {
            txtMessage.setText(mMessageText);
        }
        return this;
    }

    public Channelbridgesdialog setConfirmText(String text) {
        bConfirmBtnText = text;
        if (mOKButton != null && mOKButton != null) {
            mOKButton.setText(bConfirmBtnText);
        }

        return this;
    }

    public Channelbridgesdialog setCancelText(String text) {
        bCancelBtnText = text;
        if (mCancelButton != null && mCancelButton != null) {
            mCancelButton.setText(bCancelBtnText);
        }
        return this;
    }


    public Channelbridgesdialog setConfirmClickListener(OnClickListener listener) {
        btnStstus = 1;
        mConfirmClickListener = listener;
        return this;
    }


    public Channelbridgesdialog setCancelClickListener(OnClickListener listener) {
        btnStstus = 2;
        mCancelClickListener = listener;
        return this;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_ok) {
            if (mConfirmClickListener != null) {
                mConfirmClickListener.onClick(Channelbridgesdialog.this);
            } else {

            }

        } else if (v.getId() == R.id.btn_no) {
            if (mCancelClickListener != null) {
                mCancelClickListener.onClick(Channelbridgesdialog.this);
            } else {

            }
        }


    }

    public void dismissWithAnimation() {
        dismissWithAnimation(false);
    }

    private void dismissWithAnimation(boolean fromCancel) {

    }

    protected void onStart() {
        mDialogView.showContextMenu();

    }

    public void setBackgroundColor(int eType) {
        final int sdk = android.os.Build.VERSION.SDK_INT;
        switch (eType) {
            case 0:
                txtIcon.setText(R.string.icon_normal);
                if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    layoutMain.setBackgroundDrawable(mDialogView.getResources().getDrawable(R.drawable.shadow_borders_green));
                    mOKButton.setBackgroundDrawable(mDialogView.getResources().getDrawable(R.drawable.button_green));
                } else {
                    layoutMain.setBackground(mDialogView.getResources().getDrawable(R.drawable.shadow_borders_green));
                    mOKButton.setBackground(mDialogView.getResources().getDrawable(R.drawable.button_green));
                }

                break;
            case 1:
                txtIcon.setText(R.string.icon_warring);
                if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    layoutMain.setBackgroundDrawable(mDialogView.getResources().getDrawable(R.drawable.shadow_borders_red));
                    mOKButton.setBackgroundDrawable(mDialogView.getResources().getDrawable(R.drawable.button_green));
                } else {
                    layoutMain.setBackground(mDialogView.getResources().getDrawable(R.drawable.shadow_borders_red));
                    mOKButton.setBackground(mDialogView.getResources().getDrawable(R.drawable.button_green));
                }
                break;

            case 2:
                txtIcon.setText(R.string.icon_suecces);
                if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    layoutMain.setBackgroundDrawable(mDialogView.getResources().getDrawable(R.drawable.shadow_borders_blue));
                    mOKButton.setBackgroundDrawable(mDialogView.getResources().getDrawable(R.drawable.button_blue));
                } else {
                    layoutMain.setBackground(mDialogView.getResources().getDrawable(R.drawable.shadow_borders_blue));
                    mOKButton.setBackground(mDialogView.getResources().getDrawable(R.drawable.button_blue));
                }
                break;

            case 3:
                txtIcon.setText(R.string.icon_warring);
                if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    layoutMain.setBackgroundDrawable(mDialogView.getResources().getDrawable(R.drawable.shadow_borders_yellow));
                    mOKButton.setBackgroundDrawable(mDialogView.getResources().getDrawable(R.drawable.button_yellow));
                } else {
                    layoutMain.setBackground(mDialogView.getResources().getDrawable(R.drawable.shadow_borders_yellow));
                    mOKButton.setBackground(mDialogView.getResources().getDrawable(R.drawable.button_yellow));
                }
                break;

            case 4:
                txtIcon.setText(R.string.icon_loading);
                if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    layoutMain.setBackgroundDrawable(mDialogView.getResources().getDrawable(R.drawable.shadow_borders_orange));
                } else {
                    layoutMain.setBackground(mDialogView.getResources().getDrawable(R.drawable.shadow_borders_orange));
                }
                break;


            default:
                if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    layoutMain.setBackgroundDrawable(mDialogView.getResources().getDrawable(R.drawable.shadow_borders_green));
                    mOKButton.setBackgroundDrawable(mDialogView.getResources().getDrawable(R.drawable.button_green));
                } else {
                    layoutMain.setBackground(mDialogView.getResources().getDrawable(R.drawable.shadow_borders_green));
                    mOKButton.setBackground(mDialogView.getResources().getDrawable(R.drawable.button_green));
                }
        }

    }

    public void setTextStatus() {
        if (titelStatus == 0) {
            txtTitle.setVisibility(View.INVISIBLE);
        } else if (messageStatus == 0) {
            txtMessage.setVisibility(View.INVISIBLE);
        } else {
            txtMessage.setVisibility(View.VISIBLE);
            txtTitle.setVisibility(View.VISIBLE);
        }

    }

    public void setLayout(int eType) {
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if (btnStstus == 1) {
            layoutMargin.setVisibility(View.GONE);
            mCancelButton.setVisibility(View.GONE);
            View positiveButton = findViewById(R.id.btn_ok);
            positiveButton.setLayoutParams(new RelativeLayout.LayoutParams(300, 70));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) positiveButton.getLayoutParams();
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
            positiveButton.setLayoutParams(layoutParams);

        } else if (btnStstus == 2) {
            layoutMarginTop.setVisibility(View.GONE);
            layoutMargin.setVisibility(View.VISIBLE);
            mCancelButton.setVisibility(View.VISIBLE);

            txtMessage.setVisibility(View.VISIBLE);
            txtTitle.setVisibility(View.VISIBLE);
        } else {
            if (titelStatus == 0) {
                layoutMargin.setVisibility(View.GONE);
                mCancelButton.setVisibility(View.GONE);
                View positiveButton = findViewById(R.id.btn_ok);
                positiveButton.setLayoutParams(new RelativeLayout.LayoutParams(300, 70));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) positiveButton.getLayoutParams();
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                positiveButton.setLayoutParams(layoutParams);



            } else if (messageStatus == 0) {
                layoutMargin.setVisibility(View.GONE);
                mCancelButton.setVisibility(View.GONE);
                View positiveButton = findViewById(R.id.btn_ok);
                positiveButton.setLayoutParams(new RelativeLayout.LayoutParams(300, 70));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) positiveButton.getLayoutParams();
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                positiveButton.setLayoutParams(layoutParams);



            } else {
                if (btnStstus == 0) {
                    layoutMargin.setVisibility(View.GONE);
                    mCancelButton.setVisibility(View.GONE);


                    View positiveButton = findViewById(R.id.btn_ok);
                    positiveButton.setLayoutParams(new RelativeLayout.LayoutParams(300, 70));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) positiveButton.getLayoutParams();
                    layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                    positiveButton.setLayoutParams(layoutParams);


                } else {
                    layoutMarginTop.setVisibility(View.GONE);
                    layoutMargin.setVisibility(View.VISIBLE);
                    mCancelButton.setVisibility(View.VISIBLE);

                    txtMessage.setVisibility(View.VISIBLE);
                    txtTitle.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    private void setButtonOntuch(){

        mOKButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    mOKButton.setTextColor(Color.WHITE);

                } else if (event.getAction() == KeyEvent.ACTION_UP) {
                    mOKButton.setTextColor(Color.BLACK);
                }
                return false;
            }
        });

        mCancelButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    mCancelButton.setTextColor(Color.WHITE);

                } else if (event.getAction() == KeyEvent.ACTION_UP) {
                    mCancelButton.setTextColor(Color.BLACK);
                }
                return false;
            }
        });

    }

}
