package com.example.bucketlist.Control;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.bucketlist.Database.BucketListItem;
import com.example.bucketlist.R;

import java.util.List;

public class BucketListAdapter extends RecyclerView.Adapter<BucketListAdapter.ViewHolder> {
	
	private List<BucketListItem> bucketListItems;
	
	public BucketListAdapter(List<BucketListItem> bucketListItems) {
		this.bucketListItems = bucketListItems;
	}
	
	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		Context context = viewGroup.getContext();
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(android.R.layout.simple_list_item_1, null);
		BucketListAdapter.ViewHolder viewHolder = new BucketListAdapter.ViewHolder(view);
		return viewHolder;
	}
	
	@Override
	public void onBindViewHolder(@NonNull final BucketListAdapter.ViewHolder viewHolder, int i) {
		BucketListItem bucketListItem = bucketListItems.get(i);
		viewHolder.textViewTitle.setText(bucketListItem.getmTitle());
		viewHolder.textViewDescription.setText(bucketListItem.getmDescription());
		
		viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					viewHolder.textViewTitle.setPaintFlags(viewHolder.textViewTitle.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
					viewHolder.textViewDescription.setPaintFlags(viewHolder.textViewDescription.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
				} else {
					viewHolder.textViewTitle.setPaintFlags(viewHolder.textViewTitle.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
					viewHolder.textViewDescription.setPaintFlags(viewHolder.textViewDescription.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
				}
			}
		});
	}
	
	@Override
	public int getItemCount() {
		return bucketListItems.size();
	}
	
	public class ViewHolder extends RecyclerView.ViewHolder {
		TextView textViewTitle;
		TextView textViewDescription;
		CheckBox checkBox;
		
		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			this.textViewTitle = itemView.findViewById(R.id.titleTextView);
			this.textViewDescription = itemView.findViewById(R.id.descriptionTextView);
			this.checkBox = itemView.findViewById(R.id.bucketListCheck);
		}
	}
}
