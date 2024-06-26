package ro.go.adrhc.constructionauthsrv.http;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.go.adrhc.constructionauth.datasource.index.UrlContentIndexRecord;
import ro.go.adrhc.constructionauth.datasource.index.UrlContentIndexService;
import ro.go.adrhc.constructionauthsrv.datasource.SearchType;
import ro.go.adrhc.constructionauthsrv.datasource.SearchTypeAwareUrlContentIndexSearcher;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class BuildAuthzSearchController {
    private final SearchTypeAwareUrlContentIndexSearcher searcher;
    private final UrlContentIndexService indexService;

    @GetMapping("search")
    public List<String> search(@RequestParam String query,
            @RequestParam(defaultValue = "SMALL") SearchType type) throws IOException {
        log.info("\nsearching {} for: {}", type, query);
        return searcher.search(type, query).stream().map(UrlContentIndexRecord::url).sorted().toList();
    }

    @RequestMapping("update")
    public void update() {
        indexService.updateIndex();
        log.trace("\nIndex updated!");
    }
}
