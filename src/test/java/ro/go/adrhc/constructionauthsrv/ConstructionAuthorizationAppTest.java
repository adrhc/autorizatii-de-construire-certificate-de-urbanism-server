package ro.go.adrhc.constructionauthsrv;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "index.readonly=true")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConstructionAuthorizationAppTest {
    @Test
    void contextLoads() {
    }
}
