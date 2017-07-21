package training.android.ui.habrhabrfeedreader.mainList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import training.android.ui.habrhabrfeedreader.R;
import training.android.ui.habrhabrfeedreader.articleDetails.DetailsActivity;

public class MainActivity extends AppCompatActivity implements MainListAdapter.MainAdapterListener {

    private static final String  BASE_URL ="https://habrahabr.ru/rss/hubs/all/";

    public static final String EXTRA_LINK = "link";
    public static final String EXTRA_PICTURE = "Picture";
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_DATE= "date";
    public static final String EXTRA_DESCRIPTION = "descriptiom";
    public static final String EXTRA_AUTHOR = "author";
    public static final String EXTRA_CATEGORIES = "categories";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame_main, NewsListFragment.newInstance(BASE_URL)).commit();

    }



    @Override
    public void openDetails(String link, String articlePicture, String title, String date,
                            String description, String author, List<String> categories) {

        StringBuilder str = new StringBuilder();
        for (String category : categories) str.append(category+ "");

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(EXTRA_LINK,link);
        intent.putExtra(EXTRA_PICTURE, articlePicture);
        intent.putExtra(EXTRA_TITLE, title);
        intent.putExtra(EXTRA_DATE, date);
        intent.putExtra(EXTRA_DESCRIPTION, description);
        intent.putExtra(EXTRA_AUTHOR, author);
        intent.putExtra(EXTRA_CATEGORIES, str.toString());
        startActivity(intent);




    }
}
