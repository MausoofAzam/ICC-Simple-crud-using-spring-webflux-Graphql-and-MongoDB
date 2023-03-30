package com.player.service;

import com.player.entity.Player;
import com.player.entity.PlayerInput;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface PlayerService {
    Mono<Player> getPlayerById(String id);
    Mono<Player> getPlayerByName(String name);
    Flux<Player> getAllPlayers();
    Flux<Player> getPlayerByClub(String club);
    Flux<Player> getPlayerByNationality(String nationality);
    Mono<Player> addPlayer(PlayerInput playerInput);
    Mono<Player> updatePlayer(String id, PlayerInput playerInput);
    Mono<Player> deletePlayer (String id);
    Mono<Player> deletePlayerByName(String name);

}
