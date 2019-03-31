package menumaker.persistence.ingredients;

import menumaker.domain.MeatOrigin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeatOriginRepository extends JpaRepository<MeatOrigin,Long> {
}
