package com.example.insodroid1.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private ArrayList<Model> modelsAll = new ArrayList<>();

    public Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Model model = modelsAll.get(position);
        holder.textView.setText(model.name);

        holder.itemView.setTag(R.string.MODEL, model);
        holder.itemView.setTag(R.string.position, position);

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) holder.textView.getLayoutParams();
        layoutParams.setMargins((50 * model.level), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = (int) v.getTag(R.string.position);
                Model rootModel = (Model) v.getTag(R.string.MODEL);
                if (rootModel.models.isEmpty()) {
                    return;
                }
                switch (rootModel.state) {

                    case CLOSED:
                        modelsAll.addAll(position + 1, rootModel.models);
                        notifyItemRangeInserted(position + 1, rootModel.models.size());
                        notifyItemRangeChanged(position + rootModel.models.size(), modelsAll.size() - (position + rootModel.models.size()));
                        rootModel.state = Model.STATE.OPENED;
                        break;

                    case OPENED:

                        int start = position + 1;
                        int end = modelsAll.size();
                        for (int i = start; i < modelsAll.size(); i++) {
                            Model model1 = modelsAll.get(i);
                            if (rootModel.level == model1.level) {
                                end = i;
                                break;
                            }else {
                                if(model1.state == Model.STATE.OPENED){
                                    model1.state = Model.STATE.CLOSED;
                                }
                            }
                        }

                        if (end != -1) {
                            modelsAll.subList(start, end).clear();
                            notifyItemRangeRemoved(start, end - start);
                            notifyItemRangeChanged(start, end - start);
                        }

                        rootModel.state = Model.STATE.CLOSED;
                        break;
                }


            }
        });
    }


    public void removeAllChilds(ArrayList<Model> childList) {

//        for (int j = 1; j <= model.models.size(); j++) {
//            Model modelToRemove = modelsAll.get(j);
//            if (modelToRemove.state == Model.STATE.OPENED) {
//                removeAllChilds(modelToRemove, start + 1);
//            } else {
//                modelsAll.remove(start);
//            }
//        }

//        Model modelToRemove = modelsAll.get(start);
//        if (modelToRemove.state == Model.STATE.OPENED) {
//            removeAllChilds(start + 1);
//        } else {
//            modelsAll.remove(start);
//        }


        for (int j = 0; j < childList.size(); j++) {
            Model model = childList.get(j);
            removeAllChilds(model.models);
            modelsAll.remove(model);
        }

    }

    @Override
    public int getItemCount() {
        return modelsAll.size();
    }

    public void setData(ArrayList<Model> list) {
        modelsAll = list;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {

            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tvName);
        }
    }
}
