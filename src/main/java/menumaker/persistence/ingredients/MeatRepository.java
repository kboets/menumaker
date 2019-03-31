package menumaker.persistence.ingredients;

import menumaker.domain.Meat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface MeatRepository extends JpaRepository<Meat, Long> {

//    private static List<Meat> meatList = new ArrayList<>();
//
//    static {
//        meatList.add(new Meat.Builder().withName("Hamburger").withType("ROOD").withId(1L).build());
//        meatList.add(new Meat.Builder().withName("Haan").withType("WIT").withId(2L).build());
//        meatList.add(new Meat.Builder().withName("Stoofvlees").withType("ROOD").withId(3L).build());
//    }
//
//    public List<Meat> getAll() {
//        return meatList;
//    }
//
//    public Optional<Meat> getById(Long id) {
//        return meatList.stream().filter(d -> d.getId().equals(id)).findFirst();
//    }
//
//
//    public Meat save(Meat toBeSaved) {
//        Long id = meatList.stream().map(Meat::getId).max(Comparator.naturalOrder()).orElse(0L);
//        toBeSaved.setId(++id);
//        meatList.add(toBeSaved);
//        return toBeSaved;
//    }
//
//
//    public Meat update(Object toBeUpdated) {
//        return null;
//    }
//
//
//    public boolean deleteById(Long id) {
//        Optional<Meat> toBeDeleted = getById(id);
//        if(toBeDeleted.isPresent()) {
//            return meatList.remove(toBeDeleted.get());
//        }
//        return false;
//    }

}
