package menumaker.service.ingredients;

import menumaker.domain.ingredients.Meat;
import menumaker.persistence.ingredients.MeatRepository;
import menumaker.web.ingredients.dto.MeatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeatService {

    @Autowired
    private MeatRepository repository;

    @Autowired
    private MeatMapper meatMapper;

    public List<MeatDto> findAllMeat() {
        List<Meat> meatList = repository.findAll();
        meatList.stream().filter(meat -> meat.getImageUrl() == null).forEach(Meat::initImageUrl);
        return meatMapper.meatsToMeatDtos(meatList);
    }

    public Optional<MeatDto> getMeatById(Long id) {
        Optional<Meat> meatOptional = repository.findById(id);
        if(meatOptional.isPresent()) {
            return Optional.of(meatMapper.meatToMeatDto(meatOptional.get()));
        }
        return Optional.empty();
    }

    public MeatDto saveMeat(MeatDto meatDto) {
        return meatMapper.meatToMeatDto(repository.save(meatMapper.dtoToMeat(meatDto)));
    }

    public boolean deleteMeat(Long id) {
        repository.deleteById(id);
        return true;
    }
}

