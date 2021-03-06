package sample.carpool.delvelogic.poolmyridesample.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
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
public class CarpoolAdapter extends RecyclerView.Adapter<CarpoolAdapter.CarpoolViewHolder> {

    Context ctx;
    List<CarPool> carPoolList;

    public CarpoolAdapter(Context ctx, List<CarPool> carPoolList) {
        this.ctx = ctx;
        this.carPoolList = carPoolList;
    }

    public class CarpoolViewHolder extends RecyclerView.ViewHolder {
        ImageView userIv;
        TextView sourceTv;
        TextView destinationTv;
        TextView userNameTv;

        public CarpoolViewHolder(View itemView) {
            super(itemView);
            userIv = (ImageView) itemView.findViewById(R.id.user_image);
            sourceTv = (TextView) itemView.findViewById(R.id.source);
            destinationTv = (TextView) itemView.findViewById(R.id.destination);
            userNameTv = (TextView) itemView.findViewById(R.id.user_name);
        }
    }

    @Override
    public CarpoolAdapter.CarpoolViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(ctx).inflate(R.layout.carpool_item, parent, false);
        return new CarpoolViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CarpoolAdapter.CarpoolViewHolder holder, int position) {
        CarPool carPool = carPoolList.get(position);
        holder.sourceTv.setText(carPool.getSource());
        holder.destinationTv.setText(carPool.getDestination());
        holder.userNameTv.setText(carPool.getUser().getUserName());
        String url = carPool.getUser().getImage();
        fetchImage(url, holder.userIv);


    }

    public void fetchImage(String url, final ImageView userImage) {
        Glide.with(ctx).load(url).asBitmap().into(new BitmapImageViewTarget(userImage) {
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
