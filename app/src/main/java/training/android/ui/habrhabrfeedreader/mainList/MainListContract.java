package training.android.ui.habrhabrfeedreader.mainList;

import java.util.List;
import java.util.Map;

/**
 * Created by guedi on 7/21/2017.
 */

public interface MainListContract {

    interface MainListView {

        void DataLoaded(List<Map<String,Object>> news);
    }


    interface MainListPresenter {

        void fetchData(String url);

    }
}
