package dev.space.rss;

import com.apptasticsoftware.rssreader.Item;
import com.apptasticsoftware.rssreader.RssReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tomislav
 */
public class RSSReader {

    private static final String URL = "https://www.nasa.gov/news-release/feed/";

    private RSSReader() {
    }
    
    private static final RssReader reader;
    
    static{
        reader = new RssReader();
    }

    /**
     *
     * This RSS reader library can't read descriptions from certain URLs if
     * they have HTML elements inside instead of plain text. Only option is downloading
     * source code and trying to write new tag. Registering new extension (reader.addItemExtension
     * ("content:encoded", Item::setDescription)) will break the parser. Upon further investigation
     * it seems that original creator of this RSS library didn't make separate setter for 
     * content tags, instead content tag uses same setter as description tag.
     * 
     * @return Items
     * @throws IOException
     * 
     */
    public static Optional<List<Item>> ReadFromSource() throws IOException {
        return Optional.of(reader.read(URL).toList());
    }
}
