import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import tools.ConvertFen;
import tools.FenHandler;

import java.io.File;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoadFolderTest {
    String path = "examplePGN";
    File[] selectedFolder;

    @BeforeAll
    public void setUp() {
        selectedFolder = new File[]{new File(path)};

    }

    @AfterAll
    public void tearDown() {
        selectedFolder = null;
    }

    @Test
    public void selectedFolderShouldNotContainNulls() {
        for (int i = 0; i < selectedFolder.length; i++) {
            Assert.assertNotNull(selectedFolder[i]);
        }
    }
}
