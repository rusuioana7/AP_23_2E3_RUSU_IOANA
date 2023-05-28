package homework.services;

import homework.entities.GameEntity;
import homework.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameEntity> getIdOrderedGames(Pageable pageable) {
        return gameRepository.findAll();
    }

    public GameEntity getGameById(Long id) {
        return (GameEntity) gameRepository.findById(id).orElse(null);
    }

    public List<GameEntity> getGamesByPlayerName(String playerName) {
        return gameRepository.findByPlayer1NameOrPlayer2Name(playerName, playerName);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    public GameEntity saveGame(GameEntity game) {
        return gameRepository.save(game);
    }
    public Page<GameEntity> getIdOrderedPaged(Integer pageNumber, Integer pageSize) {
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return gameRepository.findAll(pageable);
    }
}


