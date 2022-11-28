public class BestOption {
    private Integer initialPosition;
    private Integer freeSpaces;

    public BestOption() {
        this.initialPosition = 0;
        this.freeSpaces = 0;
    }

    public BestOption(Integer initialPosition, Integer freeSpaces) {
        this.initialPosition = initialPosition;
        this.freeSpaces = freeSpaces;
    }

    public Integer getInitialPosition() {
        return this.initialPosition;
    }

    public void setInitialPosition(Integer initialPosition) {
        this.initialPosition = initialPosition;
    }

    public Integer getFreeSpaces() {
        return this.freeSpaces;
    }

    public void setFreeSpaces(Integer freeSpaces) {
        this.freeSpaces = freeSpaces;
    }
}