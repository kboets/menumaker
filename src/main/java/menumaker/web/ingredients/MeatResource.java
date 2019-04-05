package menumaker.web.ingredients;

import menumaker.domain.Meat;
import menumaker.domain.MeatOrigin;
import menumaker.exception.IngredientNotFoundException;
import menumaker.service.ingredients.MeatService;
import menumaker.web.ingredients.dto.MeatDto;
import menumaker.web.ingredients.dto.MeatOriginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
public class MeatResource {

    @Autowired
    private MeatService meatService;

    @GetMapping("/meat")
    public List<MeatDto> getAllMeat() {
        return meatService.getAll();
    }

    @GetMapping("/meat/{id}")
    public Resource<MeatDto> getMeat(@PathVariable("id") Long id) {
        Optional<MeatDto> meatOptional = meatService.getMeatById(id);
        if (!meatOptional.isPresent()) {
            throw new IngredientNotFoundException(String.format("No meat found with id %s", id));
        }
        //HATEAOS
        Resource<MeatDto> resource = new Resource<>(meatOptional.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllMeat());
        resource.add(linkTo.withRel("all-meat"));

        return resource;
    }

    @DeleteMapping("/meat/{id}")
    public void deleteMeat(@PathVariable("id") Long id) {
        boolean isDeleted = meatService.deleteMeat(id);
        if (!isDeleted) {
            throw new IngredientNotFoundException(String.format("No meat found with id %s", id));
        }
    }

    @PostMapping("/meat")
    public ResponseEntity<MeatDto> createMeat(@Valid @RequestBody MeatDto meat) {
        MeatDto saved = meatService.saveMeat(meat);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getMeatId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/meat/{id}/meatorigins")
    public List<MeatOriginDto> retrieveMeatOrigin(@PathVariable("id") Long id) {
        Optional<MeatDto> optionalMeat = meatService.getMeatById(id);
        if(!optionalMeat.isPresent()) {
            throw new IngredientNotFoundException(String.format("No meat found with id %s", id));
        }
        return optionalMeat.get().getMeatOriginDtos();
    }

}
