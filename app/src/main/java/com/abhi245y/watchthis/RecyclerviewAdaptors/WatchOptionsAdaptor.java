package com.abhi245y.watchthis.RecyclerviewAdaptors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhi245y.watchthis.Extra.Constants;
import com.abhi245y.watchthis.Models.WatchOptionsModel;
import com.abhi245y.watchthis.R;
import com.abhi245y.watchthis.ui.TelegramResultsActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Map.Entry;


public class WatchOptionsAdaptor extends RecyclerView.Adapter<WatchOptionsAdaptor.ViewHolder> {

    ArrayList<WatchOptionsModel> watchOptionsModels;
    Context context;

    public WatchOptionsAdaptor(ArrayList<WatchOptionsModel> watchOptionsModels, Context context) {
        this.watchOptionsModels = watchOptionsModels;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.watching_options_model,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WatchOptionsModel watchOptions = watchOptionsModels.get(position);
        Log.d("MovieCardActivity","Service Link: "+watchOptions.getService_link());
        if (watchOptions.getService_name().equals("justWatch")){
            for (Entry services: Constants.getProviderId().entrySet()) {
                if (services.getKey().equals(watchOptions.getProvider_id())) {
                    String service_image_url = "https://images.justwatch.com/icon/" + services.getValue() + "/s100";
                    Log.d("MovieCardActivity", "Provider Id: " + services.getKey() + " service_image_url: " + service_image_url);

                    String monetization_type = watchOptions.getMonetization_type();

                    if (monetization_type.equals("flatrate")) {
                        Glide.with(context)
                                .load(service_image_url)
                                .fitCenter()
                                .into(holder.service_image);
                        holder.monetization_type_text.setText(R.string.Stream);
                    } else {
                        Glide.with(context)
                                .load(service_image_url)
                                .fitCenter()
                                .into(holder.service_image);
                        holder.monetization_type_text.setText(monetization_type);
                    }
                }
            }
        }else if (watchOptions.getService_name().equals("telegram")){
            holder.service_image.setBackgroundResource(R.drawable.telegram);
            holder.monetization_type_text.setText("Telegram");
        }

        holder.service_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MovieCardActivity","Provider Id: "+watchOptions.getProvider_id()+" Service Link: "+watchOptions.getService_link());
                if (watchOptions.getService_name().equals("justWatch")) {
                    ServiceLauncher(watchOptions.getProvider_id(), watchOptions.getService_link());
                }else if (watchOptions.getService_name().equals("telegram")){
                    Intent intent = new Intent(context, TelegramResultsActivity.class);
                    intent.putExtra("Tg_results",watchOptions.getTelegramResultsModel());
                    context.startActivity(intent);
                }

            }
        });

    }

    private void ServiceLauncher(int provider_id, String service_link) {
        if (provider_id == 8) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setClassName("com.netflix.mediaclient", "com.netflix.mediaclient.ui.launch.UIWebViewActivity");
            intent.setData(Uri.parse(service_link));
            context.startActivity(intent);
        }else {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(service_link));
            context.startActivity(intent);
        }
    }


    @Override
    public int getItemCount() {
        return watchOptionsModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView service_image;
        TextView monetization_type_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            service_image = itemView.findViewById(R.id.service_image);
            monetization_type_text = itemView.findViewById(R.id.monetization_type);
        }
    }
}
