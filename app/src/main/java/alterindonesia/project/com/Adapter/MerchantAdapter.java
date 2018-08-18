package alterindonesia.project.com.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import alterindonesia.project.com.MerchantDetailActivity;
import alterindonesia.project.com.Model.Merchant;
import alterindonesia.project.com.R;
import alterindonesia.project.com.Utils.StoreObjek;

public class MerchantAdapter extends RecyclerView.Adapter<MerchantAdapter.ViewHolder> {
    private List<Merchant> merchants = new ArrayList<>();
    private Context context;
    private StoreObjek storeObjek;

    public MerchantAdapter(Context context, List<Merchant> merchants){
        this.context    = context;
        this.merchants  = merchants;
        storeObjek      = (StoreObjek) context.getApplicationContext();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_merchant, parent, false);
        MerchantAdapter.ViewHolder viewHolder = new MerchantAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvTitle.setText(merchants.get(position).getNama());
        holder.tvDeskripsi.setText(merchants.get(position).getKeterangan());
        holder.tvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeObjek.merchant = merchants.get(position);
                Intent intent = new Intent(context, MerchantDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return merchants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvTitle, tvDeskripsi, tvDetail;
        public ImageView imgGambar;
        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle     = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.tvDeskripsi);
            tvDetail    = (TextView) itemView.findViewById(R.id.tvDetail);
            imgGambar   = (ImageView) itemView.findViewById(R.id.imgGambar);
        }
    }
}
