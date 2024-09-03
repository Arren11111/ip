package FlyChat.Core;

import java.io.IOException;

/**
 * Contains methods involved in parsing user input.
 */
public class Parser {
    /**
     * Parses through the user input and returns the type of command requested by the user.
     * 
     * @param inputString String containing user input.
     * @return The specific command requested by the user.
     */
    public String parseCommand(String inputString) {
        String filteredString = inputString.replaceAll("\\s.*", "");
        return filteredString;
    }
    
    public String getTaskDescription(String inputString) {
        return inputString.replaceFirst("^\\S*\\s*", "").replaceAll("\\s*/.*", "");
    }

    public String getDeadlineEndDate(String inputString) {
        return inputString.replaceAll(".*/by\\s*", "").trim();
    }

    public String getEventStartTime(String inputString) {
        return inputString.replaceAll(".*/from\\s*|\\s*/to.*",""); 
    }

    public String getEventEndTime(String inputString) {
        return inputString.replaceAll(".*/to\\s*", "").trim();
    }

    public String getTaskTypeFromFile(String inputString) {
        return inputString.substring(0, 3);
    }

    /**
     * Checks if the task saved in the save file has been marked as completed.
     * 
     * @param inputString String containing info on the task saved in the save file.
     * @return boolean indicating whether the task has been marked.
     * @throws IOException If save file has been corrupted and cannot be read.
     */
    public boolean checkTaskCompletedFromFile(String inputString) throws IOException{
        try {
            return inputString.charAt(4) == 'X';
        } catch (IndexOutOfBoundsException e) {
            throw new IOException("Save file has been corrupted. Save progress will be reset");
        }
    }

    public String getTaskDescriptionFromFile(String inputString) {
        return inputString.replaceAll(".*]\\s|\\s\\(.*", "");
    }

    public String getDeadlineEndDateFromFile(String inputString) {
        return inputString.replaceAll(".*by:\\s|\\)", "");
    }

    public String getEventStartTimeFromFile(String inputString) {
        return inputString.replaceAll(".*from:\\s|\\sto:.*", "");
    }

    public String getEventEndTimeFromFile(String inputString) {
        return inputString.replaceAll(".*to:\\s|\\)", "");
    }

    public int getTargetTaskIndex(String inputString) {
        return Integer.valueOf(inputString.replaceAll("[^0-9]", ""));
    }
}
