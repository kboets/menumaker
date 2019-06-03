package menumaker.web.ingredients;

import menumaker.exception.IngredientNotFoundException;
import menumaker.service.ingredients.VegetableService;
import menumaker.web.ingredients.dto.VegetableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class VegetableResource {

    @Autowired
    private VegetableService vegetableService;

    @GetMapping
    public List<VegetableDto> getAllVegetables() {
        return vegetableService.findAllVegetables();
    }

    @GetMapping("/vegetable/{id}")
    public VegetableDto getVegetable(@PathVariable ("id") Long id) {
        Optional<VegetableDto> optionalVegetable = vegetableService.findById(id);
        if(!optionalVegetable.isPresent()){
          throw new IngredientNotFoundException(String.format("No vegetable found with id %s", id));
        }
        return optionalVegetable.get();
    }

    @PostMapping("/vegetable")
    public ResponseEntity<VegetableDto> createVegetable(@Valid @RequestBody VegetableDto vegetableDto) {
        VegetableDto savedDto = vegetableService.save(vegetableDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedDto.getVegetableId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/vegetable")
    public void deleteVegetable(@PathVariable("id") Long id) {
        if(!vegetableService.deleteMeat(id)) {
            throw new IngredientNotFoundException(String.format("No vegetable found with id %s", id));
        }
    }


}
