package ro.go.adrhc.constructionauthsrv.datasource;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.go.adrhc.constructionauth.datasource.index.UrlContentIndexRecord;
import ro.go.adrhc.constructionauth.datasource.index.UrlContentIndexSearcher;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchTypeAwareUrlContentIndexSearcher {
    private final UrlContentIndexSearcher searcher;

    public List<UrlContentIndexRecord> search(SearchType type, String words) throws IOException {
        return switch (type) {
            case SMALL -> searcher.searchWithSmallMistakes(words);
            case BIG -> searcher.searchWithBigMistakes(words);
            case EXACT -> searcher.searchExact(words);
        };
    }
}
