package br.com.bandtec.projetodragonball;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personagens")
public class DragonballController {

    private List<Personagens> persons;
    private List<Personagens> herois = new ArrayList<Personagens>();
    private List<Personagens> viloes = new ArrayList<Personagens>();

    public DragonballController() {
        this.persons = new ArrayList<Personagens>();
        persons.add(new Herois("Goku", "Sayajin", 10000.00, 100.00));
        persons.add(new Herois("Gohan","Sayajin/terraqueo",8000.00, 90.00 ));
        persons.add(new Herois("Vegeta","Sayajin",10000.00, 90.00));
        persons.add(new Viloes("Androide 19","Androide",70000.00));
        persons.add(new Viloes("Freeza","raça do freeza", 10000.00));
        persons.add(new Viloes("Majin Boo Kid", "Majin", 90000.00));
    }

    @GetMapping
    public ResponseEntity persons() {
        if(persons.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/herois")
    public ResponseEntity herois(){
        for (Personagens personagens : persons){
            if (personagens instanceof Herois){
                herois.add(personagens);
                }
            }
        if(herois.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(herois);

    }

    @GetMapping("/viloes")
    public ResponseEntity viloes(){
        for (Personagens personagens : persons){
            if (personagens instanceof Viloes){
                viloes.add(personagens);
            }
        }
        if(viloes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(viloes);
    }

    @GetMapping("/herois/{id}")
    public ResponseEntity heroisId (@PathVariable int id) {

        for (Personagens personagens : persons){
            if(personagens instanceof Herois){
                herois.add(personagens);
            }
        }
        if (herois.size() >= id){
            return ResponseEntity.ok(herois.get(id-1));
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/viloes/{id}")
    public ResponseEntity viloesId (@PathVariable int id) {

        for (Personagens personagens : persons){
            if(personagens instanceof Viloes){
                viloes.add(personagens);
            }
        }
        if (viloes.size() >= id){
            return ResponseEntity.ok(viloes.get(id-1));
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/herois")
    public ResponseEntity criandoHeroi(@RequestBody Herois novoHeroi){
        persons.add(novoHeroi);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/viloes")
    public ResponseEntity criandoVilao(@RequestBody Viloes novoVilao){
        persons.add(novoVilao);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPersonagem(@PathVariable int id) {
        if (id > 0) {
            if (persons.size() >= id) {
                persons.remove(--id);

            }return ResponseEntity.ok().build();

        }return ResponseEntity.notFound().build();
    }

}
