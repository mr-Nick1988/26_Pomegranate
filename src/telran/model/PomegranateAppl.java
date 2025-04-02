package telran.model;

import telran.utils.BoxUtils;

import java.util.List;
import java.util.Random;

public class PomegranateAppl {
    public static void main(String[] args) {
        Random random = new Random();
        List<Box> boxes = BoxUtils.createRandomBoxes(random);
        System.out.println("Total seeds in boxes " + BoxUtils.getTotalSeedCount(boxes));
        long maxSeedsInBox = BoxUtils.getMaxSeedsCount(boxes);
        System.out.println("Max seeds in one box " + maxSeedsInBox);
        BoxUtils.printBoxesWithMaxSeeds(boxes);
    }
}
