package training.android.ui.habrhabrfeedreader.mainList;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Map;

import training.android.ui.habrhabrfeedreader.R;

/**
 * Created by guedi on 7/21/2017.
 */

public class MainListAdapter extends RecyclerView.Adapter<MainRecyclerViewHolder> {

    private List<Map<String,Object>> articles;
    private MainAdapterListener mListener;

    public static final String KEY_TITLE = "title";
    public static final String KEY_DATE = "date";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_CATEGORIES = "category";
    public static final String KEY_LINK = "link";
    public static final String KEY_CREATOR = "creator";

    public MainListAdapter(List<Map<String, Object>> articles) {
        this.articles = articles;
    }

    @Override
    public MainRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (parent.getContext() instanceof MainAdapterListener)
            mListener = (MainAdapterListener) parent.getContext();
        else throw new ClassCastException(parent.getContext().toString()+
                "must implement MainAdapterListener");

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_recycler_view_holder,parent,false);
        return new MainRecyclerViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MainRecyclerViewHolder holder, int position) {
        Map<String,Object> article = articles.get(position);
        final String title = (String)article.get(KEY_TITLE);
        final List<String> categories =(List<String>)article.get(KEY_CATEGORIES);
        final String date = (String)article.get(KEY_DATE);
        holder.setData(title,date,categories);

        final String link = (String) article.get(KEY_LINK);
        String description = (String)article.get(KEY_DESCRIPTION);
        Log.d(getClass().getSimpleName(), description);


        String s = "<img src=\"";
        int ix = description.indexOf(s)+s.length();
        final String parsedDescription = "";
        final String picture =description.substring(ix, description.indexOf("\"", ix+1)) ;
        final String creator = (String)article.get(KEY_CREATOR);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.openDetails(link,picture,title,date,parsedDescription,creator,categories);
            }
        });


    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public interface MainAdapterListener {
        void openDetails(String link, String articlePicture, String title, String date,
                         String description,String author, List<String> categories);
    }
}
