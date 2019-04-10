package menumaker.persistence.ingredients;

import menumaker.domain.ingredients.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepository extends JpaRepository<Fish, Long> {

    Fish findByName(String name);
}
