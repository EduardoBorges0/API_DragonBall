package com.eduborges.characterDBZ.Controller;

import com.eduborges.characterDBZ.entities.Characters;
import com.eduborges.characterDBZ.repositories.Repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("characters")
public class CharacterController {
    @Autowired
    private Repositories repositories;
    @GetMapping
    public List<ResponseDTO> findAll(){
        List<ResponseDTO> result = repositories.findAll().stream().map(ResponseDTO::new).toList();
        return result;
    }
    @GetMapping(value = "{name}")
    public Characters findByName(@PathVariable String name){
        Characters result = repositories.findByName(name);
        return result;
    }
    @PostMapping
    public void insert(@RequestBody List<RequestDTO> dataList){
        List<Characters> charactersList = new ArrayList<>();
        for (RequestDTO data : dataList) {
            Characters characters = new Characters(data);
            charactersList.add(characters);
        }
        repositories.saveAll(charactersList);
    }

}
