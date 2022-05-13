package fr.EvilCorpRobot.Core.console;

import fr.EvilCorpRobot.Core.Files.File;
import fr.EvilCorpRobot.Core.Files.FileError;
import fr.EvilCorpRobot.Core.Files.FilesManager;
import fr.EvilCorpRobot.Main;

import java.awt.*;
import java.util.Scanner;

public class Console {
    private boolean isOpended = false;
    private FilesManager filesManager;

    public Console(FilesManager filesManager) {
        this.filesManager = filesManager;
    }

    public void start() {
        isOpended = true;
        while (isOpended) {
            System.out.println(Main.COLOR_PURPLE + "---------------------------------------------------------------------" + Main.COLOR_RESET);
            Scanner scanner = new Scanner(System.in);
            System.out.print(Main.COLOR_GREEN + FilesManager.getCursorDirectory().getAbsolutePath() + "> " + Main.COLOR_RESET);
            String[] stringScanner = scanner.nextLine().split(" ");
            System.out.println();
            if (stringScanner[0].contains("cd")) {
                FileError fileError =  filesManager.cd(stringScanner[1]);
                if(fileError != FileError.SUCSESS) {
                    System.out.println(Main.COLOR_RED + "Error : " + fileError.getErrorMessage() + Main.COLOR_RESET);
                }
            }
            if (stringScanner[0].contains("mkdir")) {
                if (!filesManager.mkdir(FilesManager.getCursorDirectory(), stringScanner[1])) {
                    System.out.println(Main.COLOR_RED + "Erreur de nom de nom de dossier" + Main.COLOR_RESET);
                }
                System.out.println("mkdir sucsess : " + stringScanner[1]);
            }
            if (stringScanner[0].contains("ls")) {
                filesManager.ls(FilesManager.getCursorDirectory().getAbsolutePath());

            }
            if (stringScanner[0].contains("exit")) {
                this.isOpended = false;
            }
        }
    }
}
