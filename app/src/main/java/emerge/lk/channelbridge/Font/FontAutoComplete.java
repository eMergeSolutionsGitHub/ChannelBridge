package emerge.lk.channelbridge.Font;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

/**
 * Created by Himanshu on 2/6/2017.
 */

public class FontAutoComplete extends AutoCompleteTextView {
    public FontAutoComplete(Context context) {
        super(context);
        init();
    }

    public FontAutoComplete(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FontAutoComplete(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FontAutoComplete(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public FontAutoComplete(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, Resources.Theme popupTheme) {
        super(context, attrs, defStyleAttr, defStyleRes, popupTheme);
        init();
    }
    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Aaargh.ttf");
        setTypeface(tf);
    }
}
