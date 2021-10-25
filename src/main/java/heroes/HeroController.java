package heroes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/hero")
public class HeroController {

    private List<Hero> heroes = Hero.makeHeroes();
    private List<String> powers = List.of(Power.RED_MAGIC, Power.FLIGHT, Power.PHASING, Power.BLAST, Power.TELEKINESIS, Power.PLANT_CONTROL);

    @GetMapping
    public List<Hero> getHeroes() {
        return heroes;
    }

    @GetMapping("/{heroId}")
    public ResponseEntity<Hero> getHero(@PathVariable int heroId) {
        Hero hero = heroes.stream().filter(h -> h.getId() == heroId).findFirst().orElse(null);
        if (hero == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hero);
    }

    @PostMapping
    public ResponseEntity<Hero> post(@RequestBody Hero hero, ServletRequest request) {
        int nextId = heroes.stream().mapToInt(h -> h.getId()).max().orElse(0) + 1;
        hero.setId(nextId);
        heroes.add(hero);
        return ResponseEntity.created(URI.create("http://localhost:8080/hero/" + hero.getId())).body(hero);
    }

    @PutMapping("/{heroId}")
    public ResponseEntity<Void> put(@PathVariable int heroId, @RequestBody Hero hero) {
        if (hero == null || hero.getId() != heroId) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getId() == heroId) {
                heroes.set(i, hero);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{heroId}")
    public ResponseEntity<Void> delete(@PathVariable int heroId) {
        boolean success = heroes.removeIf(h -> h.getId() == heroId);
        if (success) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/powers")
    public List<String> getPowers() {
        return powers;
    }
}
