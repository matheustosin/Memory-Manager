import java.util.List;

import static java.util.Objects.isNull;

public class FirstFit implements AllocationPolicy {

    @Override
    public BestOption run(List<String> memory, Integer processSize) {
        int freeSpaces = 0;
        int initialPosition = 0;

        for (int i = 0; i < memory.size(); i++) {
            if (isNull(memory.get(i))) {
                if (freeSpaces == 0) {
                    initialPosition = i;
                }
                freeSpaces++;
                if (freeSpaces == processSize) {
                    return new BestOption(initialPosition, freeSpaces);
                }
            } else {
                freeSpaces = 0;
                initialPosition = 0;
            }
        }
        
        return new BestOption();
    }
}
