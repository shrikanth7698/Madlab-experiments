package me.shrikanthravi.madlab.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import me.shrikanthravi.madlab.R;
import me.shrikanthravi.madlab.data.models.Experiment;


public class ExperimentsAdapter extends RecyclerView.Adapter<ExperimentsAdapter.MyViewHolder> {
    private List<Experiment> experimentList;
    private final OnItemClickListener onItemClickListener;
    private final OnViewCodeClickListener onViewCodeClickListener;
    private final OnRunAppClickListener onRunAppClickListener;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView titleTV;
        public TextView viewCodeTV;
        public TextView runAppTV;
        public CardView rootLayoutCV;

        public MyViewHolder(View view) {
            super(view);

            titleTV = view.findViewById(R.id.titleTV);
            viewCodeTV = view.findViewById(R.id.viewCodeTV);
            runAppTV = view.findViewById(R.id.runAppTV);
            rootLayoutCV = view.findViewById(R.id.rootLayoutCV);

        }
    }

    public ExperimentsAdapter(List<Experiment> verticalList,
                              Context context,
                              OnItemClickListener listener,
                              OnViewCodeClickListener viewCodeClickListener,
                              OnRunAppClickListener runAppClickListener) {
        this.experimentList = verticalList;
        this.context = context;
        this.onItemClickListener = listener;
        this.onViewCodeClickListener = viewCodeClickListener;
        this.onRunAppClickListener = runAppClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exp_row_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Experiment experiment = experimentList.get(position);
        holder.titleTV.setText(experiment.getNumber()+". "+experiment.getTitle());
        holder.rootLayoutCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(experiment,position);
            }
        });
        holder.viewCodeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onViewCodeClickListener.onViewCodeClick(experiment,position);
            }
        });
        holder.runAppTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRunAppClickListener.onRunAppClick(experiment,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return experimentList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Experiment item,int pos);
    }

    public interface OnViewCodeClickListener {
        void onViewCodeClick(Experiment item,int pos);
    }

    public interface OnRunAppClickListener {
        void onRunAppClick(Experiment item,int pos);
    }

}