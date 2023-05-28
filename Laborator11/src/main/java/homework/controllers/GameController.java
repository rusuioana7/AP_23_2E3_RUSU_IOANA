package homework.controllers;

import homework.entities.GameEntity;
import homework.entities.PlayerEntity;
import homework.repositories.GameRepository;
import homework.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;
    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public List<GameEntity> getAllPlayers() {
        return gameRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public GameEntity getGameById(@PathVariable("id") Long id) {
        return gameService.getGameById(id);
    }

    @GetMapping("/player/name/{name}")
    public List<GameEntity> getGamesByPlayerName(@PathVariable("name") String playerName) {
        return gameService.getGamesByPlayerName(playerName);
    }

    @GetMapping("/paged")
    public Page<GameEntity> getPagedGames(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return gameRepository.findAll(pageable);
    }

    @PostMapping
    public GameEntity addGame(@RequestBody GameEntity game) {
        return gameService.saveGame(game);
    }

    @PutMapping("/id/{id}")
    public GameEntity updateGame(@PathVariable("id") Long id, @RequestBody GameEntity game) {
        GameEntity existingGame = gameService.getGameById(id);
        if (existingGame != null) {
            existingGame.setGrid(game.getGrid());
            existingGame.setPlayer1Name(game.getPlayer1Name());
            existingGame.setPlayer1Symbol(game.getPlayer1Symbol());
            existingGame.setPlayer2Name(game.getPlayer2Name());
            existingGame.setPlayer2Symbol(game.getPlayer2Symbol());
            existingGame.setDuration(game.getDuration());
            existingGame.setDate(game.getDate());

            return gameService.saveGame(existingGame);
        } else {
            return null;
        }
    }

    @DeleteMapping("/id/{id}")
    public void deleteGame(@PathVariable("id") Long id) {
        gameService.deleteGame(id);
    }
}

