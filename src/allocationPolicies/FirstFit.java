package allocationPolicies;

public class FirstFit implements AllocationPolicy {

    @Override
    public BestOption run(Integer initialPosition, Integer freeSpaces, Integer processSize, BestOption bestOption) {
        if (freeSpaces >= processSize) {
            if (bestOption.getFreeSpaces() == 0);
        }
        return null;
    }
}
