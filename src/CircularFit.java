import java.util.List;

import static java.util.Objects.isNull;

public class CircularFit implements AllocationPolicy {
    private int currentPosition = 0;

    @Override
    public BestOption run(List<String> memory, Integer processSize) {
        int freeSpaces = 0;
        int start = currentPosition;
        int i = start;
        
        do {
            if (isNull(memory.get(i))) {
                if (freeSpaces == 0) {
                    currentPosition = i;
                }
                freeSpaces++;
                if (freeSpaces == processSize) {
                    return new BestOption(currentPosition, freeSpaces);
                }
            } else {
                freeSpaces = 0;
                currentPosition = 0;
            }

            if (i == memory.size() - 1) {
                i = 0;
            }

            i++;
        } while (i != start);


        // for (int i = start; i < memory.size(); i++) {
        //     if (isNull(memory.get(i))) {
        //         if (freeSpaces == 0) {
        //             currentPosition = i;
        //         }
        //         freeSpaces++;
        //         if (freeSpaces == processSize) {
        //             return new BestOption(currentPosition, freeSpaces);
        //         }
        //     } else {
        //         freeSpaces = 0;
        //         currentPosition = 0;
        //     }

        //     if (i == memory.size() - 1) {
        //         i = 0;
        //         restart = true;
        //     }

        //     if (restart && i == start) {
        //         break;
        //     }
        // }
        // for (int i = 0; i < memory.size(); i++) {
        //     if (isNull(memory.get(i)) && i < memory.size() - 1) {
        //         if (freeSpaces == 0) {
        //             initialPosition = i;
        //         }
        //         freeSpaces++;
        //     } else {
        //         if (isNull(memory.get(i))) {
        //             freeSpaces++;
        //         }

        //         if (freeSpaces >= processSize) {
                    
		// 			// if (bestOption.getFreeSpaces() == 0 
		// 			// 		|| (freeSpaces - processSize > bestOption.getFreeSpaces() - processSize)) {
		// 			// 	return new BestOption(initialPosition, freeSpaces);
		// 			// }
		// 		}   

        //         initialPosition = 0;
        //         freeSpaces = 0;
        //     }
        // }
		
		return new BestOption();
    }
}
