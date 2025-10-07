package model;
import org.junit.jupiter.api.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTest {

    private FileManager fileManager;

    @BeforeEach
    void setUp(){
        fileManager = new FileManager();
    }

    @Test
    void testCreateNewFile(){
        boolean created = fileManager.createNewFile("testFile");
        assertTrue(created, "file should exist");
        assertEquals("testFile.txt", fileManager.getFile().getName());

    }

    @Test
    void testWriteAndRead(){
        ArrayList<String> lines = new ArrayList<String>();
        lines.add("Linea 1");
        lines.add("Linea 2");

        fileManager.createNewFile("testFile2");
        assertTrue(fileManager.write(lines));

        fileManager.read();
        assertEquals(2, fileManager.getClipBoard().size());
        assertEquals("Linea 1", fileManager.getClipBoard().get(0));
        assertEquals("Linea 2", fileManager.getClipBoard().get(1));
    }

    @Test
    void testClipBoard(){
        fileManager.read();
        fileManager.clearClipboard();
        assertEquals(0,fileManager.getClipBoard().size());
    }
}
