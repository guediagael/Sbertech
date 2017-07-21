package training.android.ui.habrhabrfeedreader.Utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import training.android.ui.habrhabrfeedreader.mainList.MainListAdapter;
import training.android.ui.habrhabrfeedreader.mainList.models.Category;
import training.android.ui.habrhabrfeedreader.mainList.models.Item;

/**
 * Created by guedi on 7/21/2017.
 */

public class FieldExtractor {
    private List<Item> items;

    public FieldExtractor(List<Item> items) {
        this.items = items;
    }

    public List<Map<String,Object>> extract(){
        List<Map<String,Object>> list = new ArrayList<>();
        for (Item item : items){
            Map<String,Object> i = new HashMap<>();
            Log.d(getClass().getSimpleName(),item.getCategory().toString());
            List<String> cats =new ArrayList<>();
            for (Category s : item.getCategory())
                cats.add(s.toString());

            i.put(MainListAdapter.KEY_CATEGORIES,cats);
            i.put(MainListAdapter.KEY_DATE,item.getPubDate());
            i.put(MainListAdapter.KEY_DESCRIPTION,item.getDescription());
            i.put(MainListAdapter.KEY_TITLE, item.getTitle());
            i.put(MainListAdapter.KEY_LINK, item.getGuid());
            i.put(MainListAdapter.KEY_CREATOR, item.getCreator());
            list.add(i);

            Log.d(getClass().getSimpleName(),item.toString());
        }

        return list;
    }
}
