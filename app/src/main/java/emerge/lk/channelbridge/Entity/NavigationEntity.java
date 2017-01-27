package emerge.lk.channelbridge.Entity;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class NavigationEntity extends BaseObservable {
    public  String mTitle;
    public  int mIcon;
//
    public NavigationEntity(String title, int icon) {
        mTitle = title;
        mIcon = icon;
    }
    @Bindable
    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
    @Bindable
    public int getmIcon() {
        return mIcon;
    }

    public void setmIcon(int mIcon) {
        this.mIcon = mIcon;
    }
}
