package com.example.bucketlist.Database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;

public abstract class BucketListDatabase extends RoomDatabase {
	
	@NonNull
	@Override
	protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
		return null;
	}
	
	@NonNull
	@Override
	protected InvalidationTracker createInvalidationTracker() {
		return null;
	}
	
	@Override
	public void clearAllTables() {
		
	}
}
