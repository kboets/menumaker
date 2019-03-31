package menumaker.service.ingredients;

import menumaker.domain.Meat;
import menumaker.persistence.ingredients.MeatRepository;
import menumaker.web.ingredients.dto.MeatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MeatService {

    @Autowired
    private MeatRepository repository;

    @Autowired
    private MeatMapper meatMapper;

    public List<MeatDto> getAll() {
        return meatMapper.meatsToMeatDtos(repository.findAll());
    }

    public Optional<MeatDto> getMeatById(Long id) {
        Optional<Meat> meatOptional = repository.findById(id);
        return Optional.ofNullable(meatMapper.meatToMeatDto(meatOptional.get()));
    }

    public MeatDto saveMeat(MeatDto meatDto) {
        return meatMapper.meatToMeatDto(repository.save(meatMapper.dtoToMeat(meatDto)));
    }

    public boolean deleteMeat(Long id) {
        boolean isDeleted = false;
        repository.deleteById(id);
        isDeleted = true;
        return isDeleted;
    }
}

