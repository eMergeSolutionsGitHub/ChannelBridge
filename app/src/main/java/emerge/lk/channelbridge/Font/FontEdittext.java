package emerge.lk.channelbridge.Font;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Himanshu on 2/6/2017.
 */

public class FontEdittext extends EditText {
    public FontEdittext(Context context) {
        super(context);
        init();
    }

    public FontEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FontEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FontEdittext(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Aaargh.ttf");
        setTypeface(tf);
    }

}
