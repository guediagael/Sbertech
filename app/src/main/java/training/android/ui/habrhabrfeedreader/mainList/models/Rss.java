package training.android.ui.habrhabrfeedreader.mainList.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by guedi on 7/21/2017.
 */

@Root
public class Rss {
    @Attribute
    String version;

    @Element
    Channel channel;

    public Channel getChannel() {

        return channel;

    }



    @Override
    public String toString() {

        return "RSS{" +

                "version='" + version + '\'' +

                ", channel=" + channel +

                '}';

    }
}