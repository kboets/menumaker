package menumaker.service.ingredients;

import menumaker.domain.ingredients.Fish;
import menumaker.persistence.ingredients.FishRepository;
import menumaker.web.ingredients.dto.FishDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FishService {

    @Autowired
    private FishRepository fishRepository;
    @Autowired
    private FishMapper fishMapper;


    public List<?> findAll() {
        return fishMapper.fishListToDtos(fishRepository.findAll());
    }

    public Optional<?> findById(Long id) {
        Optional<Fish> optionalFish = fishRepository.findById(id);
        if(optionalFish.isPresent()){
            return Optional.of(fishMapper.fishToDto(optionalFish.get()));
        }
        return Optional.empty();
    }

    public FishDto save(FishDto dto) {
        return fishMapper.fishToDto(fishRepository.save(fishMapper.dtoToFish(dto)));
    }



    public boolean delete(FishDto dto) {
        fishRepository.delete(fishMapper.dtoToFish(dto));
        return true;
    }
}
