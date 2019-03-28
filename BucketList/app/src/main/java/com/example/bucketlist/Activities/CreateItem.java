package com.example.bucketlist.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bucketlist.Database.BucketListItem;
import com.example.bucketlist.R;

public class CreateItem extends AppCompatActivity {
	
	EditText mEditTitle;
	EditText mEditDescription;
	Button mButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_item);
		
		mEditTitle = findViewById(R.id.Title);
		mEditDescription = findViewById(R.id.Description);
		mButton = findViewById(R.id.button);
		
		mButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String title = mEditTitle.getText().toString();
				String description = mEditDescription.getText().toString();
				
				BucketListItem bucketListItem = new BucketListItem(title, description);
				Intent intent = new Intent();
				intent.putExtra(MainActivity.KEY, bucketListItem);
				finish();
			}
		});
		
	}
}
