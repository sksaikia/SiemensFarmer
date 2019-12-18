package com.github.tenx.xcom.ui.Function.contactExperts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.xcom.R;
import com.github.tenx.xcom.data.models.functions.appointments.ExpertProfileBody;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ContactExpertsAdapter extends RecyclerView.Adapter<ContactExpertsAdapter.ContactExpertViewHolder> {


    private List<ExpertProfileBody> mList;
    private View.OnClickListener onItemClickListener;

    @Inject
    public ContactExpertsAdapter() {
        mList = new ArrayList<>();
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ContactExpertViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_experts,parent,false);
        return new ContactExpertViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactExpertViewHolder holder, int position) {
            holder.expertName.setText(mList.get(position).getName());
            holder.expertImage.setImageResource(mList.get(position).getProfilePic());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void updateListData(List<ExpertProfileBody>  mList){
        this.mList.addAll(mList);
        notifyDataSetChanged();

    }


    public class ContactExpertViewHolder extends RecyclerView.ViewHolder {

        TextView expertName;
        ImageView expertImage;

        public ContactExpertViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setTag(this);

            expertName =  itemView.findViewById(R.id.tv_topic);
            expertImage = itemView.findViewById(R.id.iv_topic);

            itemView.setOnClickListener(onItemClickListener);


        }
    }
}
