import allocationPolicies.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.List;

public class App {
    private static final Logger LOG = Logger.getLogger(App.class.getName());

    public static void main(String[] args)  {
        try {
            Path path = Paths.get("C:\\Users\\Matheus_Tosin\\Desktop\\PUCRS\\SISOP\\Memory-Manager\\src\\config.txt");
            List<String> lines = Files.readAllLines(path);


            while (true) {
                MenuUtils.showInitialMenuMemorySize();
                Integer option = MenuUtils.nextInt();
                if (option == 2) break;
                
                MenuUtils.showInitialMenuMemorySize();
                Integer memorySize = MenuUtils.nextInt();

                MenuUtils.showInitialMenuAllocationPolicy();
                Integer allocationOption = MenuUtils.nextInt();
                
                AllocationPolicy allocationPolicy = getPolicy(allocationOption);
                MemoryVariablePartition memory = new MemoryVariablePartition(memorySize, allocationPolicy);

                lines.forEach(line -> {
                    if (line.toUpperCase().startsWith("IN")) {
                        String[] instruction = resolveInstruction(line);
                        String processID = instruction[0];
                        Integer processSize = Integer.parseInt(instruction[1]);
                        memory.in(processID, processSize);
                    } else {
                        String[] instruction = resolveInstruction(line);
                        String processID = instruction[0];
                        memory.out(processID);
                    }
                });
            }

        } catch (Exception e) {
            LOG.severe(e.getMessage());
        }

    }

    public static String[] resolveInstruction(String line) {
        line = line.replace("IN", "");
        line = line.replace("OUT", "");
        line = line.replace("(", "");
        line = line.replace(")", "");
        return line.split(",");
    }

    public static AllocationPolicy getPolicy(Integer allocationPolicy) {
        switch (allocationPolicy) {
            case 1:
                return new FirstFit();
            case 2:
                return new BestFit();
            case 3:
                return new WorstFit();
            case 4:
                return new CircularFit();
            default:
                LOG.info("A politica de alocacao informada nao existe!");
        };
        
        return null;
    }
}
