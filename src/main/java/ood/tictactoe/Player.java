package ood.tictactoe;

public class Player {

    private String  name;
    private Value   value;
    private boolean isComputer;

    public Player(String name, Value value, boolean isComputer) {
        super();
        this.name = name;
        this.value = value;
        this.isComputer = isComputer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean isComputer) {
        this.isComputer = isComputer;
    }

}
