package training.android.ui.habrhabrfeedreader.mainList.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

/**
 * Created by guedi on 7/21/2017.
 */

public class Link {

    @Attribute(required = false)
    public String href;

    @Attribute(required = false)
    public String rel;

    @Attribute(name = "type", required = false)
    public String contentType;

    @Text(required = false)
    public String link;

}
