package training.android.ui.habrhabrfeedreader.Utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import training.android.ui.habrhabrfeedreader.mainList.ui.MainListAdapter;
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
            List<String> strings = new ArrayList<>();

            for (Category c : item.getCategory())  strings.add(c.getLink());

            i.put(MainListAdapter.KEY_CATEGORIES,strings);
            i.put(MainListAdapter.KEY_DATE,item.getPubDate());
            i.put(MainListAdapter.KEY_DESCRIPTION,item.getDescription());
            i.put(MainListAdapter.KEY_TITLE, item.getTitle());
            i.put(MainListAdapter.KEY_LINK, item.getLink());
            i.put(MainListAdapter.KEY_CREATOR,item.getCreator());

            list.add(i);

            Log.d(getClass().getSimpleName(),item.toString());
        }

        return list;
    }
}
