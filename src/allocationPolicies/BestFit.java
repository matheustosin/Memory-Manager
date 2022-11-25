package allocationPolicies;

public class BestFit implements AllocationPolicy {

	@Override
	public BestOption run(Integer initialPosition, Integer freeSpaces, Integer processSize, BestOption bestOption) {
		if (freeSpaces >= processSize) {
			if (bestOption.getFreeSpaces() == 0
					|| (freeSpaces - processSize < bestOption.getFreeSpaces() - processSize)) {
				return new BestOption(initialPosition, freeSpaces);
			}
		}

		return null;
	}
}
