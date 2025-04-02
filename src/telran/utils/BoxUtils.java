package telran.utils;

import telran.model.Box;
import telran.model.Pomegranate;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BoxUtils {
    public static List<Box> createRandomBoxes(Random random) {
        int numBoxes = random.ints(100, 201)
                .limit(1)
                .findFirst()
                .orElse(100);

        return random.ints(100, numBoxes +1)
                .limit(numBoxes)
                .boxed()
                .map(i -> {
                    int pomegranatesNum = random.ints(10, 21)
                            .limit(1)
                            .findFirst()
                            .orElse(10);

                    List<Pomegranate> pomegranates = random.ints(0, pomegranatesNum)
                            .limit(pomegranatesNum)
                            .boxed()
                            .map(p -> Pomegranate.createRandomPomegranateSeeds(random))
                            .collect(Collectors.toList());

                    return new Box("Box " + i, pomegranates);
                })
                .collect(Collectors.toList());
    }
    public static long getTotalSeedCount(List<Box> boxes){
        return boxes.stream()
                .mapToLong(Box::getSeedCount)
                .sum();
    }
    public static long getMaxSeedsCount(List<Box> boxes){
        return boxes.stream()
                .mapToLong(Box::getSeedCount)
                .max()
                .orElse(0);
    }
    public static void printBoxesWithMaxSeeds(List<Box> boxes){
        long maxSeeds = getMaxSeedsCount(boxes);
        boxes.stream()
                .filter(box->box.getSeedCount()==maxSeeds)
                .forEach(box-> System.out.println(box.getName()));
    }
}
