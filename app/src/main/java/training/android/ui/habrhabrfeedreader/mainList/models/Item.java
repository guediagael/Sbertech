package training.android.ui.habrhabrfeedreader.mainList.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

import static android.R.attr.name;

/**
 * Created by guedi on 7/21/2017.
 */

@Root(name = "item", strict = false)
public class Item {

    @Element(name = "title", required = true)
    String title;//The title of the item.	Venice Film Festival Tries to Quit Sinking

    @Element(name = "link", required = true)
    String link;//The LINK of the item.	http://www.nytimes.com/2002/09/07/movies/07FEST.html

    @Element(name = "description", required = true )
    String description;//The item synopsis.	Some of the most heated chatter at the Venice Film Festival this week was about the way that the arrival of the stars at the Palazzo del Cinema was being staged.


    @ElementList(name = "category", required = true, inline = true)
    List<Category> category;//Includes the item in one or more categories. More.	Simpsons Characters


    @Element(name = "guid", required = false)
    String guid;//A string that uniquely identifies the item. More.	<guid isPermaLink="true">http://inessential.com/2002/09/01.php#a2</guid>

    @Element(name = "pubDate", required = false)
    String pubDate;//	Indicates when the item was published. More.	Sun, 19 May 2002 15:21:36 GMT

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
