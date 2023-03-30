package com.player.service;

import com.player.entity.Player;
import com.player.entity.PlayerInput;
import com.player.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class PlayerServiceImpl implements PlayerService{
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Mono<Player> getPlayerById(String id) {
        Mono<Player> byId = this.playerRepository.findById(id);
        return byId;
    }

    @Override
    public Mono<Player> getPlayerByName(String name) {
      return this.playerRepository.findByName(name);
    }

    @Override
    public Flux<Player> getAllPlayers() {
        return this.playerRepository.findAll();
    }

    @Override
    public Flux<Player> getPlayerByClub(String club) {
        return this.playerRepository.findByClub(club);
    }

    @Override
    public Flux<Player> getPlayerByNationality(String nationality) {
        return this.playerRepository.findByNationality(nationality);
    }
    @Override
    public Mono<Player> addPlayer(PlayerInput playerInput) {
       Player player = new Player();
       player.setName(playerInput.getName());
       player.setAge(playerInput.getAge());
       player.setNationality(playerInput.getNationality());
       player.setClub(playerInput.getClub());
       return this.playerRepository.save(player);
    }
    @Override
    public Mono<Player> updatePlayer( String id, PlayerInput playerInput) {
        return this.playerRepository.findById(id)
                .flatMap(player -> {
                    player.setName(playerInput.getName());
                    player.setAge(playerInput.getAge());
                    player.setClub(playerInput.getClub());
                    player.setNationality(playerInput.getNationality());
                    return this.playerRepository.save(player).log();
                });

    }
    @Override
    public Mono<Player> deletePlayer(String id) {
        return getPlayerById(id).map(player -> {
             this.playerRepository.deleteById(id).subscribe();
             return player;
        });
    }
    @Override
    public Mono<Player> deletePlayerByName(String name) {
        return getPlayerByName(name).map(player -> {
            this.playerRepository.deleteByName(name).subscribe();
            return player;
        });
    }

}
