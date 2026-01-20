package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

// Part H: Populate DetailActivity from arrays.xml using index-based lookup (no if/switch).
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int index = getIntent().getIntExtra(MainActivity.EXTRA_TOPIC_INDEX, 0);

        String[] titles  = getResources().getStringArray(R.array.string_array_titles);
        String[] content = getResources().getStringArray(R.array.string_array_content);
        String[] images  = getResources().getStringArray(R.array.string_array_images);

        String titleText = titles[index];
        String bodyText  = content[index];

        // Trim is allowed; it avoids issues if array items contain extra spaces.
        String imageName = images[index].trim();

        int imageResId = getResources().getIdentifier(imageName, "drawable", getPackageName());

        ImageView headerIcon = findViewById(R.id.headerIcon);
        TextView headerTitle = findViewById(R.id.headerTitle);
        TextView detailTitle = findViewById(R.id.detailTitle);
        TextView detailContent = findViewById(R.id.detailContent);

        headerIcon.setImageResource(imageResId);
        headerTitle.setText(titleText);
        detailTitle.setText(titleText);
        detailContent.setText(bodyText);
    }

}