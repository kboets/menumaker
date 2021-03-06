package menumaker.persistence.ingredients;

import menumaker.domain.ingredients.Potato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PotatoRepository extends JpaRepository<Potato, Long> {

    @Query("select p from Potato  p where p.name LIKE CONCAT('%',:name,'%')")
    List<Potato> findByName(@Param("name") String name);

}
