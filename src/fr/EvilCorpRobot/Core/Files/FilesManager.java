package fr.EvilCorpRobot.Core.Files;

import fr.EvilCorpRobot.Main;

import java.awt.*;
import java.util.Scanner;

public class FilesManager {

    private static File root = new File();
    private static File cursorDirectory;

    public FilesManager() {
        root.setName("~/");
        root.setAbsolutePath("~/");
        root.setType(FileTypes.DIRECTORY);
        cursorDirectory = root;

    }

    public static void addFiles(String name, String extension, File parent) {
        File file = new File();
        file.setAbsolutePath(new StringBuilder()
                .append(parent.getAbsolutePath())
                .append("/")
                .append(name)
                .append(".")
                .append(extension)
                .toString());
        file.setName(name);
        file.setExtension(extension);
        file.setType(FileTypes.FILE);
        parent.addChildren(file);
    }

    public static void addDirectory(String name, File parent) {
        File file = new File();
        file.setName(name);
        file.setExtension(null);
        file.setType(FileTypes.DIRECTORY);
        file.setAbsolutePath(new StringBuilder().append(parent.getAbsolutePath()).append(name).append("/").toString());
        parent.addChildren(file);
        file.setParent(parent);
    }

    public FileError cd(String directory) {

        for (String dir : directory.split("/")) {
            System.out.println(dir);
            if (dir.contains("..")) {
                if (cursorDirectory == root) {
                    return FileError.ROOT_DIRECTORY;
                }
                if (cursorDirectory.getParent().getType() != FileTypes.DIRECTORY) {
                    return FileError.NO_TYPE_DIRECTORY;
                }
                cursorDirectory = cursorDirectory.getParent();
                return FileError.SUCSESS;
            }
            if (cursorDirectory.getChildren(dir) == null){
                return FileError.NO_CHILDREN_FOR_NAME;
            }
            if(cursorDirectory.getChildren(dir).getType() != FileTypes.DIRECTORY) {
                return FileError.CHILDREN_NO_DIRECTORY;
            }
            cursorDirectory = cursorDirectory.getChildren(dir);
            return FileError.SUCSESS;
        }
        return null;
    }

    public boolean mkdir(File parent, String name) {
        if (cursorDirectory.getChildren(name) != null) {
            return false;
        }
        FilesManager.addDirectory(name, cursorDirectory);
        return true;
    }

    public boolean ls(String absolutePath) {
        File file = FilesManager.getCursorDirectory();
        System.out.println(".");
        System.out.println("..");
        for (File children : file.getChildrens()) {
            if (children.getType() == FileTypes.DIRECTORY) {
                System.out.println(children.getName() + "/");
            } else {
                System.out.println(children.getName() + "." + children.getExtension());
            }
        }
        return true;
    }

    public static File getRoot() {
        return root;
    }

    public static void setRoot(File root) {
        FilesManager.root = root;
    }

    public static File getCursorDirectory() {
        return cursorDirectory;
    }

    public static void setCursorDirectory(File cursorDirectory) {
        FilesManager.cursorDirectory = cursorDirectory;
    }
}
