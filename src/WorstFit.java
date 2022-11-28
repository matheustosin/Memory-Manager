import java.util.List;

import static java.util.Objects.isNull;

public class WorstFit implements AllocationPolicy {

    @Override
	public BestOption run(List<String> memory, Integer processSize) {
		int freeSpaces = 0;
        int initialPosition = 0;
        BestOption bestOption = new BestOption();

        for (int i = 0; i < memory.size(); i++) {
            if (isNull(memory.get(i)) && i < memory.size() - 1) {
                if (freeSpaces == 0) {
                    initialPosition = i;
                }
                freeSpaces++;
            } else {
                if (isNull(memory.get(i))) {
                    freeSpaces++;
                }

				if (freeSpaces >= processSize) {
					if (bestOption.getFreeSpaces() == 0
							|| (freeSpaces - processSize > bestOption.getFreeSpaces() - processSize)) {
						bestOption = new BestOption(initialPosition, freeSpaces);
					}
				}   

                initialPosition = 0;
                freeSpaces = 0;
            }
        }
		
		return bestOption;
    }
}
