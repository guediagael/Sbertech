package training.android.ui.habrhabrfeedreader.mainList;

import android.os.AsyncTask;
import android.util.Log;

import org.simpleframework.xml.core.Persister;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import training.android.ui.habrhabrfeedreader.Utils.FieldExtractor;
import training.android.ui.habrhabrfeedreader.mainList.models.Rss;

/**
 * Created by guedi on 7/21/2017.
 */

public class MainPresenter implements MainListContract.MainListPresenter {
    private MainListContract.MainListView mView;

    public MainPresenter(MainListContract.MainListView mView) {
        this.mView = mView;

    }

    @Override
    public void fetchData(String url) {
        FetcherTask fetcherTask = new FetcherTask();
        fetcherTask.execute(url);
    }


    class FetcherTask extends AsyncTask<String,Void,List<Map<String,Object>>> {

        @Override
        protected List<Map<String,Object>> doInBackground(String... strings) {
            List<Map<String,Object>> feedItems = new ArrayList<>();
            Persister persister = new Persister();
            Rss rss;
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                rss = persister.read(Rss.class,inputStream);
                feedItems = new FieldExtractor(rss.getChannel().itemList).extract();
            } catch (MalformedURLException e) {
                Log.d(getClass().getSimpleName(),e.getMessage());
            } catch (IOException e) {
                Log.d(getClass().getSimpleName(),e.getMessage());
            } catch (Exception e) {
                Log.d(getClass().getSimpleName(),e.getMessage());
            }
            return feedItems;
        }

        @Override
        protected void onPostExecute(List<Map<String,Object>> aRss) {
            super.onPostExecute(aRss);
            mView.DataLoaded(aRss);
        }
    }
}
