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

    private static Optional<List<Item>> ReadFromSource() throws IOException {
        return Optional.of(reader.read(URL).toList());
    }
}
