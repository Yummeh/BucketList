package com.example.bucketlist.Database;

import android.arch.persistence.room.Entity;
import android.os.Parcel;
import android.os.Parcelable;

@Entity
public class BucketListItem implements Parcelable {
	private String mTitle;
	private String mDescription;
	
	public BucketListItem(String mTitle, String mDescription) {
		this.mTitle = mTitle;
		this.mDescription = mDescription;
	}
	
	public String getmTitle() {
		return mTitle;
	}
	
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	
	public String getmDescription() {
		return mDescription;
	}
	
	public void setmDescription(String mDescription) {
		this.mDescription = mDescription;
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.mTitle);
		dest.writeString(this.mDescription);
	}
	
	protected BucketListItem(Parcel in) {
		this.mTitle = in.readString();
		this.mDescription = in.readString();
	}
	
	public static final Creator<BucketListItem> CREATOR = new Creator<BucketListItem>() {
		@Override
		public BucketListItem createFromParcel(Parcel source) {
			return new BucketListItem(source);
		}
		
		@Override
		public BucketListItem[] newArray(int size) {
			return new BucketListItem[size];
		}
	};
}
