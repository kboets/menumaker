package menumaker.service.ingredients;

import menumaker.domain.ingredients.Vegetable;
import menumaker.exception.IngredientNotFoundException;
import menumaker.persistence.ingredients.VegetableRepository;
import menumaker.web.ingredients.dto.VegetableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VegetableService {

    @Autowired
    private VegetableRepository vegetableRepository;
    @Autowired
    private VegetableMapper vegetableMapper;

    public Optional<VegetableDto> findById(Long id) {
        Optional<Vegetable> vegetableOptional = vegetableRepository.findById(id);
        if(vegetableOptional.isPresent()) {
            return Optional.of(vegetableMapper.vegetableToDto(vegetableOptional.get()));
        }
        return Optional.empty();
    }

    public boolean deleteMeat(Long id) {
        vegetableRepository.deleteById(id);
        return true;
    }

    public VegetableDto save(VegetableDto vegetableDto) {
        return vegetableMapper.vegetableToDto(vegetableRepository.save(vegetableMapper.dtoToVegetable(vegetableDto)));
    }
}
