package ro.go.adrhc.constructionauthsrv.http;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.go.adrhc.constructionauth.datasource.index.UrlContentIndexRecord;
import ro.go.adrhc.constructionauth.datasource.index.UrlContentIndexSearcher;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class BuildAuthzSearchController {
    private final UrlContentIndexSearcher searcher;

    @GetMapping
    public List<String> search(@RequestParam String query) throws IOException {
        return searcher.search(query).stream().map(UrlContentIndexRecord::url).sorted().toList();
    }
}
