package com.player.repository;

import com.player.entity.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayerRepository extends ReactiveMongoRepository<Player,String> {
    Mono<Player> findByName(String name);
    Mono<Player> deleteByName(String name);
    Flux<Player> findByClub(String club);
    Flux<Player> findByNationality(String nationality);
}
