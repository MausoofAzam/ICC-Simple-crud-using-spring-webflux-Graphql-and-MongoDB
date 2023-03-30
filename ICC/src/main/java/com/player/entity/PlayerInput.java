package com.player.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PlayerInput {

    private String name;
    private Integer age;
    private String club;
    private String nationality;
}
