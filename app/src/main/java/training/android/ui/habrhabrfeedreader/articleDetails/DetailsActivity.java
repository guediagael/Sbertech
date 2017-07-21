package training.android.ui.habrhabrfeedreader.articleDetails;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

import training.android.ui.habrhabrfeedreader.R;

import static training.android.ui.habrhabrfeedreader.mainList.MainActivity.EXTRA_AUTHOR;
import static training.android.ui.habrhabrfeedreader.mainList.MainActivity.EXTRA_CATEGORIES;
import static training.android.ui.habrhabrfeedreader.mainList.MainActivity.EXTRA_DATE;
import static training.android.ui.habrhabrfeedreader.mainList.MainActivity.EXTRA_DESCRIPTION;
import static training.android.ui.habrhabrfeedreader.mainList.MainActivity.EXTRA_LINK;
import static training.android.ui.habrhabrfeedreader.mainList.MainActivity.EXTRA_PICTURE;
import static training.android.ui.habrhabrfeedreader.mainList.MainActivity.EXTRA_TITLE;

public class DetailsActivity extends AppCompatActivity {
    private String mLink;
    private String mArticlePicture;
    private String mTitle;
    private String mDate;
    private String mDescription;
    private String mAuthor;
    private String mCategories;

    private ImageView imageView;
    private TextView tvTitle;
    private TextView tvDate;
    private TextView tvAuthor;
    private TextView tvCategories;
    private TextView tvDescription;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();

        mLink = intent.getStringExtra(EXTRA_LINK);
        mArticlePicture = intent.getStringExtra(EXTRA_PICTURE);
        mTitle =intent.getStringExtra(EXTRA_TITLE);
        mDate = intent.getStringExtra(EXTRA_DATE);
        mDescription = intent.getStringExtra(EXTRA_DESCRIPTION);
        mAuthor = intent.getStringExtra(EXTRA_AUTHOR);
        mCategories = intent.getStringExtra(EXTRA_CATEGORIES);

        imageView = (ImageView) findViewById(R.id.image_details);

        tvTitle = (TextView) findViewById(R.id.text_details_title);
        tvTitle.setText(mTitle);

        tvDescription = (TextView)findViewById(R.id.text_details_description) ;
        tvDescription.setText(mDescription);

        tvAuthor  = (TextView) findViewById(R.id.text_details_author);
        tvAuthor.setText(mAuthor);

        tvCategories  = (TextView) findViewById(R.id.text_details_categories);
        tvCategories.setText(mCategories);

        tvDate  = (TextView) findViewById(R.id.text_details_date);
        tvDate.setText(mDate);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Button button =(Button)findViewById(R.id.button_details_read_more);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse(mLink);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        PictureExtractorTask extractorTask = new PictureExtractorTask(imageView);
        extractorTask.execute(mArticlePicture);

    }


    public class PictureExtractorTask extends AsyncTask<String,Void,Bitmap> {
        private ImageView imageView;

        public PictureExtractorTask(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... s) {
            Bitmap bmp = null;
            try {
                URL url = new URL(s[0]);
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (IOException e) {
                Log.d(getClass().getSimpleName(),e.getMessage());
            }
            return bmp;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }
    }



}
