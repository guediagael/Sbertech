package training.android.ui.habrhabrfeedreader.mainList.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;


/**
 * Created by guedi on 7/21/2017.
 */

@Root(name = "item", strict = false)
public class Item {

    @Element(name = "title", required = true)
    String title;

    @Element(name = "link", required = true)
    String link;

    @Element(name = "description", required = true )
    String description;


    @ElementList(name = "category", required = true, inline = true)
    List<Category> category;


    @Element(name = "guid", required = false)
    String guid;

    @Element(name = "pubDate", required = false)
    String pubDate;

    @Namespace( prefix="dc", reference="http://purl.org/dc/elements/1.1/")
    @Element(name = "creator", required = false)
    String creator;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }


    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override

    public String toString() {

        return "Item{" +

                "title='" + title + '\'' +

                ", link='" + link + '\'' +

                ", description='" + description + '\'' +

                ", category='" + category + '\'' +

                ", guid='" + guid + '\'' +

                ", pubDate='" + pubDate + '\'' +
                ", creator ='" + creator + '\'' +

                '}';

    }


}
