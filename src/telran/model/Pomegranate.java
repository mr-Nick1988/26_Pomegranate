package telran.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Pomegranate implements Iterable<Seed> {
    private final List<Seed> lists;

    public Pomegranate(List<Seed> lists) {
        this.lists = new ArrayList<>(lists);
    }

    public List<Seed> getLists() {
        return new ArrayList<>(lists);
    }

    @Override
    public Iterator<Seed> iterator() {
        return lists.iterator();
    }
    public long getSeedCount(){
        return lists.size();
    }
    public static Pomegranate createRandomPomegranateSeeds(Random random){
        int seedsNum = random.ints(400,701)
                .limit(1)
                .findFirst()
                .orElse(400);
        List<Seed> seeds = random.ints(0,seedsNum)
                .limit(seedsNum)
                .boxed()
                .map(k->new Seed(2.0))
                .collect(Collectors.toList());
        return new Pomegranate(seeds);

    }
}
