package allocationPolicies;

public class WorstFit implements AllocationPolicy {

    @Override
    public BestOption run(Integer initialPosition, Integer freeSpaces, Integer processSize, BestOption bestOption) {
        if (freeSpaces >= processSize) {
			if (bestOption.getFreeSpaces() == 0 //TODO review this logic
					|| (freeSpaces - processSize > bestOption.getFreeSpaces() - processSize)) {
				return new BestOption(initialPosition, freeSpaces);
			}
		}
		
		return null;
    }
}
