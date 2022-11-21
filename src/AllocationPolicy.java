public interface AllocationPolicy {
    BestOption run(Integer initialPosition, Integer freeSpaces, Integer processSize, BestOption bestOption);
}
