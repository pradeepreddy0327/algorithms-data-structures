package ood;

public class Player {

    private String name;
    private Cell value;
    private boolean isComputer;

    public Player(String name, Cell value, boolean isComputer) {
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

    public Cell getValue() {
        return value;
    }

    public void setValue(Cell value) {
        this.value = value;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean isComputer) {
        this.isComputer = isComputer;
    }

}
