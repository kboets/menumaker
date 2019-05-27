package menumaker.web.ingredients;

import menumaker.exception.IngredientNotFoundException;
import menumaker.service.ingredients.VegetableService;
import menumaker.web.ingredients.dto.VegetableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class VegetableResource {

    @Autowired
    private VegetableService vegetableService;

    @GetMapping("/vegetable/{id}")
    public VegetableDto getVegetable(@PathVariable ("id") Long id) {
        Optional<VegetableDto> optionalVegetable = vegetableService.findById(id);
        if(!optionalVegetable.isPresent()){
          throw new IngredientNotFoundException(String.format("No vegetable found with id %s", id));
        }
        return optionalVegetable.get();
    }


}
