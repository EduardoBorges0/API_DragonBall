package com.eduborges.characterDBZ.entities;

import com.eduborges.characterDBZ.Controller.RequestDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity //Mapeia para uma tabela banco de dados
@Data //Gerando por baixo dos panos os setters e getters
@Table(name = "character") //Criando uma tabela no banco de dados com o nome "character"
public class Characters {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;
    private String race, name, backstory;
    public Characters() {
    }
    public Characters(RequestDTO data){
        this.race = data.race();
        this.name = data.name();
        this.backstory = data.backstory();
    }
}
