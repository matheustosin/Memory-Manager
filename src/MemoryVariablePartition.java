import allocationPolicies.AllocationPolicy;
import allocationPolicies.BestOption;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.List;

public class MemoryVariablePartition {
    private static final Logger LOG = Logger.getLogger(MemoryVariablePartition.class.getName());

    private Integer size;
    private List<String> memory;
    private AllocationPolicy allocationPolicy;

    public MemoryVariablePartition(Integer size, AllocationPolicy allocationPolicy) {
        this.size = size;
        this.memory = new ArrayList<>(size);
        this.allocationPolicy = allocationPolicy;
    }

    public void in(String processID, Integer processSize) {
        int freeSpaces = 0;
        int initialPosition = 0;
        BestOption bestOption = new BestOption();

        for (int i = 0; i < this.size; i++) {
            if (isNull(this.memory.get(i)) && i < this.size - 1) {
                if (freeSpaces == 0) {
                    initialPosition = i;
                }
                freeSpaces++;
            } else {
                if (isNull(this.memory.get(i))) {
                    freeSpaces++;
                }

                bestOption = this.allocationPolicy.run(initialPosition, freeSpaces, processSize, bestOption);

                initialPosition = 0;
                freeSpaces = 0;
            }
        }

        if (bestOption.getFreeSpaces() != 0) {
            for (int i = bestOption.getInitialPosition(); i < (bestOption.getInitialPosition() + processSize); i++) {
                this.memory.set(i, processID);
            }
        } else {
            LOG.info("Espaco insuficiente de memoria");
        }
    }

    public void out(String processID) {
        memory.stream()
                .filter(space -> space.equalsIgnoreCase(processID))
                .map(space -> space = null);
    }
}
