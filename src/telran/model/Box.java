package telran.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class  Box implements Iterable<Pomegranate> {
    private final String name;
    private final List<Pomegranate> pomegranates;

    public Box(String name, List<Pomegranate> pomegranates) {
        this.name = name;
        this.pomegranates = new ArrayList<>(pomegranates);
    }

    public String getName() {
        return name;
    }

    public List<Pomegranate> getPomegranates() {
        return new ArrayList<>(pomegranates);
    }

    @Override
    public Iterator<Pomegranate> iterator() {
        return  pomegranates.iterator();
    }
    public long getSeedCount(){
        return pomegranates.stream()
                .mapToLong(Pomegranate::getSeedCount)
                .sum();
    }


}
