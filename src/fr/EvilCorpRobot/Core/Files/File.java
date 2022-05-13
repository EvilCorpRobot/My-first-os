package fr.EvilCorpRobot.Core.Files;

import java.util.ArrayList;
import java.util.UUID;

public class File {

    private String absolutePath;
    private UUID uuid = UUID.randomUUID();
    private String name;
    private String extension;
    private int size;
    private boolean isOpened;

    private FileTypes type;
    private File parent;
    private ArrayList<File> childrens = new ArrayList<File>();

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public FileTypes getType() {
        return type;
    }

    public void setType(FileTypes type) {
        this.type = type;
    }

    public File getParent() {
        return parent;
    }

    public void setParent(File parent) {
        this.parent = parent;
    }

    public ArrayList<File> getChildrens() {
        return childrens;
    }

    public File getChildren(UUID uuid) {
        for (File children : childrens) {
             if (children.getUuid() == uuid) {
                 return children;
             }
        }
        return null;
    }

    public File getChildren(String name) {
        for (File children : childrens) {
            if (children.getName().contains(name)) {
                return children;
            }
        }
        return null;
    }

    public void addChildren(File children) {

        this.childrens.add(children);
    }
}
