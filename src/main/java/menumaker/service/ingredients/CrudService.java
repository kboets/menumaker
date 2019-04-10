package menumaker.service.ingredients;

import menumaker.web.ingredients.dto.BaseDto;

import java.util.List;
import java.util.Optional;

public interface CrudService {

    List<?> findAll();

    Optional<?> findById(Long id);


}
