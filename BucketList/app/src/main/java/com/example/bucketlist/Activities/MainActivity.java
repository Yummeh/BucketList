package com.example.bucketlist.Activities;

import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bucketlist.Control.BucketListAdapter;
import com.example.bucketlist.Database.BucketListItem;
import com.example.bucketlist.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {
	
	public static final String KEY = "key";
	public static final int REQUESTCODE = 1234;
	
	private BucketListAdapter mBucketListAdapter;
	private RecyclerView mRecyclerView;
	private List<BucketListItem> mBucketList;
	
	private RoomDatabase db;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		
		initBucketList();
		initInteraction();
		initDatabase();
		
		
	}
	
	private void initBucketList() {
		mBucketList = new ArrayList<>();
		mRecyclerView = findViewById(R.id.recyclerView);
		mBucketListAdapter = new BucketListAdapter(mBucketList);
		
		mRecyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
		mRecyclerView.addOnItemTouchListener(this);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
		
		mRecyclerView.setAdapter(mBucketListAdapter);
	}
	
	private void initDatabase() {
	}
	
	private void initInteraction() {
		FloatingActionButton fab = findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this, CreateItem.class);
				startActivityForResult(intent, REQUESTCODE);
			}
		});
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		if (requestCode == REQUESTCODE) {
			if (resultCode == RESULT_OK) {
				BucketListItem bucketListItem = data.getParcelableExtra(KEY);
				mBucketList.add(bucketListItem);
				mBucketListAdapter.notifyDataSetChanged();
				//TODO add to recyclerview and database
			}
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
		return false;
	}
	
	@Override
	public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
		
	}
	
	@Override
	public void onRequestDisallowInterceptTouchEvent(boolean b) {
		
	}
}
