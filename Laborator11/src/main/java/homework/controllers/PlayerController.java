package homework.controllers;

import homework.entities.PlayerEntity;
import homework.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public List<PlayerEntity> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public PlayerEntity getPlayerById(@PathVariable("id") Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    @GetMapping("/name/{name}")
    public List<PlayerEntity> getPlayersByName(@PathVariable("name") String name) {
        return playerRepository.findByName(name);
    }

    @GetMapping("/paged")
    public Page<PlayerEntity> getPagedPlayers(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return playerRepository.findAll(pageable);
    }

    @PostMapping
    public PlayerEntity addPlayer(@RequestBody PlayerEntity player) {
        return playerRepository.save(player);
    }

    @PutMapping("/id/{id}")
    public PlayerEntity updatePlayerName(
            @PathVariable("id") Long id,
            @RequestParam("name") String newName
    ) {
        PlayerEntity player = playerRepository.findById(id).orElse(null);
        if (player != null) {
            player.setName(newName);
            return playerRepository.save(player);
        }
        return null;
    }

    @DeleteMapping("/id/{id}")
    public void deletePlayer(@PathVariable("id") Long id) {
        playerRepository.deleteById(id);
    }
}



