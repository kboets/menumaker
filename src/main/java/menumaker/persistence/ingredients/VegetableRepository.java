package menumaker.persistence.ingredients;

import menumaker.domain.ingredients.Vegetable;
import menumaker.domain.ingredients.VegetableFamilyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    Vegetable findByName(String name);

    List<Vegetable> findByVegetableFamilyType(VegetableFamilyType type);
}
