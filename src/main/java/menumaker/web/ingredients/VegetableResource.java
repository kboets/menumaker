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
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class VegetableResource {

    @Autowired
    private VegetableService vegetableService;


    @GetMapping("/vegetable")
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

    @GetMapping("/vegetableByType")
    public Map<String, List<VegetableDto>> getVegetableByType() {
        return vegetableService.findAllByType();
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

    @PutMapping("/vegetable")
    public ResponseEntity<VegetableDto> updateVegetable(@Valid @RequestBody VegetableDto vegetableDto) {
        Optional<VegetableDto> foundVegetableDto = vegetableService.findById(Long.parseLong(vegetableDto.getVegetableId()));
        if(!foundVegetableDto.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        vegetableService.save(vegetableDto);

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/vegetable/{id}")
    public void deleteVegetable(@PathVariable("id") Long id) {
        if(!vegetableService.deleteVegetable(id)) {
            throw new IngredientNotFoundException(String.format("No vegetable found with id %s", id));
        }
    }


}
