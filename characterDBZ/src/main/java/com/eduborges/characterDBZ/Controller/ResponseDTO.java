package com.eduborges.characterDBZ.Controller;

import com.eduborges.characterDBZ.entities.Characters;

public record ResponseDTO(Long Id, String race, String name, String backstory) {
    public ResponseDTO(Characters characters){
        this(characters.getId(), characters.getRace(), characters.getName(), characters.getBackstory());
    }
}
