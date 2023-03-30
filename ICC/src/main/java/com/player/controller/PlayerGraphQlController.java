package com.player.controller;

import com.player.entity.Player;
import com.player.entity.PlayerInput;
import com.player.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
public class PlayerGraphQlController {

    private final PlayerService playerService;

    public PlayerGraphQlController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @QueryMapping("getPlayerById")
    public Mono<Player> getPlayerById(@Argument String id){
        log.info("getPlayerById(@Argument Integer id) :PlayerGraphQlController called ");
        return this.playerService.getPlayerById(id);
    }
    @QueryMapping("getPlayerByName")
    public Mono<Player> getPlayerByName(@Argument String name){
        log.info("getPlayerByName(@Argument String name) : PlayerGraphQlController called!");
        return this.playerService.getPlayerByName(name);
    }
    @QueryMapping("getAllPlayer")
    public Flux<Player> getAllPlayer(){
        log.info("getAllPlayer() :PlayerGraphQlController is Called !");
        return this.playerService.getAllPlayers();
    }

    @QueryMapping("getPlayerByClub")
    public Flux<Player> getPlayerByClub(@Argument String club){
        log.info("getPlayerByClub(@Argument String club) :PlayerGraphQlController called! ");
        return this.playerService.getPlayerByClub(club);
    }
    @QueryMapping("getPlayerByNationality")
    public Flux<Player> getPlayerByNationality(@Argument String nationality){
        log.info("getPlayerByNationality(@Argument String nationality) : PlayerGraphQlController");
        return this.playerService.getPlayerByNationality(nationality);
    }
    @MutationMapping("addPlayer")
    public Mono<Player> addPlayer(@Argument PlayerInput  playerInput){
        log.info("addPlayer(@Argument PlayerInput  playerInput) :PlayerGraphQlController is called! ");
        return this.playerService.addPlayer(playerInput);

    }

    @MutationMapping("updatePlayer")
    public Mono<Player> updatePlayer(@Argument String id, @Argument PlayerInput playerInput){
        log.info("updatePlayer(@Argument Integer id, @Argument PlayerInput playerInput) : PlayerGraphQlController");
        return this.playerService.updatePlayer(id, playerInput);
    }
    @MutationMapping("deletePlayerById")
    public  Mono<Player> deletePlayerById(@Argument String id){
        log.info("deletePlayerById(@Argument Integer id) : PlayerGraphQlController");
        return this.playerService.deletePlayer(id);

    }
    @MutationMapping("deletePlayerByName")
    public Mono<Player> deletePlayerByName(@Argument String name){
        log.info("deletePlayerByName(@Argument String name) : PlayerGraphQlController");
        return this.playerService.deletePlayerByName(name);

    }

}
