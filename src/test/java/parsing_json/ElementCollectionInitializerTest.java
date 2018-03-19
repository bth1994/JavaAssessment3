package parsing_json;

import org.json.simple.parser.ParseException;
import org.junit.Test;

        import java.io.IOException;
        import static org.junit.Assert.*;

public class ElementCollectionInitializerTest {

    @Test
    public void generate() {
        assertEquals(119, ElementCollectionInitializer.generate().size());
    }
}