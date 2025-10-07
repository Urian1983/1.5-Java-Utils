package model;

import org.junit.jupiter.api.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryManagerTest {

    private DirectoryManager directoryManager;

    @BeforeEach
    void setUp(){
        directoryManager = new DirectoryManager();
    }

    @Test
    void testCreateNewFolder(){
        boolean created = directoryManager.createNewFolder("TestDir");
        assertTrue(created);
        File folder = directoryManager.getFolder();
        assertEquals("TestDir",folder.getName());
        assertTrue(folder.exists());
    }

    @Test
    void testShowDirectory() {
        directoryManager.createNewFolder(("TestDir2"));
        File[] files = directoryManager.showDirectory();
        assertNotNull(files);
    }
}
