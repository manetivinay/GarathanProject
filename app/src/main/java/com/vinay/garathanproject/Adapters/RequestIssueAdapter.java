package com.vinay.garathanproject.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vinay.garathanproject.DataModel.IssueItemDataModel;
import com.vinay.garathanproject.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RequestIssueAdapter  extends RecyclerView.Adapter<RequestIssueAdapter.MyViewHolder> {

    private List<IssueItemDataModel> issuesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public RequestIssueAdapter(List<IssueItemDataModel> issuesList){
        this.issuesList = issuesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.issue_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        IssueItemDataModel movie = issuesList.get(position);
        holder.title.setText(movie.getRequestId());
        holder.genre.setText(movie.getIssueDescription());
        holder.year.setText(movie.getIssueDate());
    }

    @Override
    public int getItemCount(){
        return issuesList.size();
    }
}