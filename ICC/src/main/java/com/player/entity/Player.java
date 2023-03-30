package com.player.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Player {
    @Id
    private String id;
    private String name;
    private Integer age;
    private String club;
    private String nationality;
//    public Player(PlayerInput playerInput) {
//    }

}




