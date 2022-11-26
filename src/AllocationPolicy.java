import java.util.List;

public interface AllocationPolicy {
    BestOption run(List<String> memory, Integer processSize);
}
