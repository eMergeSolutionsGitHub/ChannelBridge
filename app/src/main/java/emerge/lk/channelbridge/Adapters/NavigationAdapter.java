package emerge.lk.channelbridge.Adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;

import java.util.ArrayList;


import emerge.lk.channelbridge.Entity.NavigationEntity;
import emerge.lk.channelbridge.Font.TextViewFontAwesome;
import emerge.lk.channelbridge.R;



public class NavigationAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<NavigationEntity> mNavItems;

    public NavigationAdapter(Context context, ArrayList<NavigationEntity> navItems) {
        mContext = context;
        mNavItems = navItems;
    }

    @Override
    public int getCount() {
        return mNavItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mNavItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_navigation, null);
        } else {
            view = convertView;
        }

        TextView titleView = (TextView) view.findViewById(R.id.txtView__listnavigation_title);
        TextViewFontAwesome iconview =(TextViewFontAwesome)view.findViewById(R.id.txtView__listnavigation_icon);


        titleView.setText(mNavItems.get(position).mTitle);
        iconview.setText(mNavItems.get(position).mIcon);

        return view;
    }
}
