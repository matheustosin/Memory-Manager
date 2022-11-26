import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.List;

import static java.util.Objects.nonNull;

public class MemoryVariablePartition {
    private static final Logger LOG = Logger.getLogger(MemoryVariablePartition.class.getName());

    private List<String> memory;
    private AllocationPolicy allocationPolicy;

    public MemoryVariablePartition(Integer size, AllocationPolicy allocationPolicy) {
        this.memory = new ArrayList<String>(Arrays.asList((String[]) Array.newInstance(String.class, size)));
        this.allocationPolicy = allocationPolicy;
    }

    public void in(String processID, Integer processSize) {
        LOG.info(String.format("(IN) => ## processID = %s | processSize = %d ##", processID, processSize));

        BestOption bestOption = this.allocationPolicy.run(memory, processSize);
        if (nonNull(bestOption) && bestOption.getFreeSpaces() != 0) {
            for (int i = bestOption.getInitialPosition(); i < (bestOption.getInitialPosition() + processSize); i++) {
                this.memory.set(i, processID);
            }
        } else {
            LOG.info("Espaco insuficiente de memoria");
        }

        printMemory();
    }

    public void out(String processID) {
        LOG.info(String.format("(OUT) => ## processID = %s ##", processID));

        for (int i = 0; i < this.memory.size(); i++) {
            if (processID.equalsIgnoreCase(this.memory.get(i))) {
                this.memory.set(i, null);
            }
        }

        // this.memory.forEach(space -> {
        //     if (processID.equalsIgnoreCase(space)) {
        //         space = null;
        //     }
        // });
    
        // this.memory.stream()
        //     .filter(space -> processID.equalsIgnoreCase(space))
        //     .forEach(space -> space = null);
            
        printMemory();    
    }


    private void printMemory() {
        this.memory.forEach(m -> System.out.print(String.format(" [ %s ] ", nonNull(m) ? m : "-")));
        System.out.println();
    }
}
