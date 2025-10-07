package model;

import java.io.Serializable;

public class SerDesDirectory implements Serializable {

    private DirectoryManager directoryManager;

    public SerDesDirectory(DirectoryManager directoryManager){
        this.directoryManager = directoryManager;
    }

    public DirectoryManager getDirectoryManager() {
        return directoryManager;
    }

    public void setDirectoryManager(DirectoryManager directoryManager) {
        this.directoryManager = directoryManager;
    }
}
