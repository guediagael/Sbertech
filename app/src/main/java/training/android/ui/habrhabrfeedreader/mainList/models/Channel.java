package training.android.ui.habrhabrfeedreader.mainList.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by guedi on 7/21/2017.
 */
@NamespaceList({
        @Namespace(reference = "http://purl.org/dc/elements/1.1/", prefix = "dc")
})
@Root(strict = false)
public class Channel {


    @ElementList(name = "item", required = true, inline = true)
    public List<Item> itemList;


    @ElementList(entry = "link", inline = true, required = false)
    public List<Link> links;

    @Element
    String title;

    @Element
    String language;


    @Element(name = "pubDate", required = false)
    String pubDate;

    @Override
    public String toString() {

        return "Channel{" +

                "links=" + links +

                ", itemList=" + itemList +

                ", title='" + title + '\'' +

                ", language='" + language + '\'' +

//                ", ttl=" + ttl +

                ", pubDate='" + pubDate + '\'' +

                '}';
    }

}
