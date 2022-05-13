package fr.EvilCorpRobot.Core.Files;

public enum FileError {
    NO_TYPE_DIRECTORY("the type is not directory"), NO_CHILDREN_FOR_NAME("the children doesn't this name"), CHILDREN_NO_DIRECTORY("there is no child"), SUCSESS("sucsess"), ROOT_DIRECTORY("you are already at the root");

    private String errorMessage;
    FileError(String s) {
        this.errorMessage = s;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
