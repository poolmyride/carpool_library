package sample.carpool.delvelogic.poolmyridesample.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.List;

import carpool.delvelogic.library.models.CarPool;
import sample.carpool.delvelogic.poolmyridesample.R;

/**
 * Created by himanshu on 04/03/16.
 */
public class RealTimeCarpoolAdapter extends RecyclerView.Adapter<RealTimeCarpoolAdapter.FilterViewHolder> {

    Context ctx;
    List<CarPool> carPoolList;

    public RealTimeCarpoolAdapter(Context ctx, List<CarPool> carPoolList) {
        this.ctx = ctx;
        this.carPoolList = carPoolList;
    }

    public class FilterViewHolder extends RecyclerView.ViewHolder {
        ImageView userImage;
        TextView userName;

        public FilterViewHolder(View itemView) {
            super(itemView);
            userImage = (ImageView) itemView.findViewById(R.id.userImageView);
            userName = (TextView) itemView.findViewById(R.id.userNameTv);
        }
    }

    @Override
    public RealTimeCarpoolAdapter.FilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(ctx).inflate(R.layout.member_item, parent, false);
        return new FilterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RealTimeCarpoolAdapter.FilterViewHolder holder, int position) {
        CarPool carPool = carPoolList.get(position);
        holder.userName.setText(carPool.getUser().getUserName());
        String url = carPool.getUser().getImage();
        fetchImage(url, holder.userImage);
    }

    private void fetchImage(String imageUrl, final ImageView userImage) {
        Glide.with(ctx).load(imageUrl).asBitmap().into(new BitmapImageViewTarget(userImage) {
            @Override
            public void onLoadStarted(Drawable placeholder) {
                super.onLoadStarted(placeholder);
            }

            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(
                        ctx.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                userImage.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    @Override
    public int getItemCount() {
        return carPoolList.size();
    }
}
