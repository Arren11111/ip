package Tasks;


public class Task {
    private boolean done;
    private String text;

    public Task(String textString) {
        this.done = false;
        this.text = textString;
    }

    public void completeTask() {
        this.done = true;
    }

    public void uncompleteTask() {
        this.done = false;
    }

    public String formatStringForSaving() {
        return toString();
    }

    @Override
    public String toString() {
        return "[" + (done ? "X" : " ") + "] " + this.text;
    }
}
