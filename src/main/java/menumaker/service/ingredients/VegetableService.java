package menumaker.service.ingredients;

import menumaker.domain.ingredients.Vegetable;
import menumaker.persistence.ingredients.VegetableRepository;
import menumaker.web.ingredients.dto.VegetableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<VegetableDto> findAllVegetables() {
        List<Vegetable>  allVegetables = vegetableRepository.findAll();
        allVegetables.stream().filter(vegetable -> vegetable.getImageUrl() == null).forEach(Vegetable::initImageUrl);
        return vegetableMapper.vegetableListToDtos(allVegetables);
    }

    public Map<String, List<VegetableDto>> findAllByType() {
        return findAllVegetables().stream().collect(Collectors.groupingBy(VegetableDto::getType));
    }

    public boolean deleteVegetable(Long id) {
        vegetableRepository.deleteById(id);
        return true;
    }

    public VegetableDto save(VegetableDto vegetableDto) {
        return vegetableMapper.vegetableToDto(vegetableRepository.save(vegetableMapper.dtoToVegetable(vegetableDto)));
    }
}
