public class State {
    private String name;
    private boolean isFinal;

    public State(String name, boolean isFinal) {
        this.name = name.toUpperCase();
        this.isFinal = isFinal;
    }

    public String getName() { return name; }
    public boolean isFinal() { return isFinal; }
    public void setFinal(boolean isFinal) { this.isFinal = isFinal; }
}
