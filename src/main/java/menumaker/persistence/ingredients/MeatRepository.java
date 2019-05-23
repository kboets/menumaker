package menumaker.persistence.ingredients;

import menumaker.domain.ingredients.Meat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeatRepository extends JpaRepository<Meat, Long> {

}
