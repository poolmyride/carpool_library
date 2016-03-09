package sample.carpool.delvelogic.poolmyridesample.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import sample.carpool.delvelogic.poolmyridesample.R;

/**
 * Created by himanshu on 04/03/16.
 */
public class MenuAdapter extends BaseAdapter {
    Context ctx;
    String[] fetchCarpool;

    public MenuAdapter(Context ctx, String[] fetchCarpool) {
        this.ctx = ctx;
        this.fetchCarpool = fetchCarpool;
    }

    @Override
    public int getCount() {
        return fetchCarpool.length;
    }

    @Override
    public Object getItem(int position) {
        return fetchCarpool[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView textView;

        public ViewHolder(TextView carpoolText) {
            this.textView = carpoolText;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null) {
            convertView = LayoutInflater.from(ctx).inflate(R.layout.menu_layout, parent, false);
            holder=new ViewHolder((TextView) convertView);
            convertView.setTag(holder);
        }else
            holder= (ViewHolder) convertView.getTag();
        holder.textView.setText(fetchCarpool[position]);
        return convertView;
    }
}
