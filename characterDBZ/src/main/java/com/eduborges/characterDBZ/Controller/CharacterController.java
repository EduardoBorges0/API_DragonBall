package com.eduborges.characterDBZ.Controller;

import com.eduborges.characterDBZ.entities.Characters;
import com.eduborges.characterDBZ.repositories.Repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Responsavel por manipular requisições HTTP e retornar resposta HTTP no formato JSON
@RequestMapping("/characters") //Para ter acesso a CharacterController, usaria localhost:8080/characters
public class CharacterController {
    @Autowired //Fazendo a injeção de dependência para o controlador ter acesso aos métodos do repositories
    private Repositories repositories;
    @GetMapping // Mapeando a requisição GET findAll
    public List<Characters> findAll(){
        List<Characters> result = repositories.findAll(); //Ele pega tudo do banco de dados, requisição GET
        return result;
    }
    @GetMapping(value = "{name}") //Mapeando a requisição GET findByName
    public Characters findByName(@PathVariable String name){
        Characters result = repositories.findByName(name); //pega o nome e leva tudo do personagem no banco de dados
        return result;
    }
    @PostMapping  //Mapeando a requisição POST insert
    public Characters insert(@RequestBody Characters characters){
        Characters result = repositories.save(characters); //Salva no banco de dados, requisoção POST
        return result;
    }

}
