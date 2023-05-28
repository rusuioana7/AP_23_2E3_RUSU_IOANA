package homework;

import homework.entities.GameEntity;
import homework.entities.PlayerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ClientApp {

    private final RestTemplate restTemplate;
    private final String gameUrl = "http://localhost:8087/games";
    private final String playerUrl = "http://localhost:8087/players";

    @Autowired
    public ClientApp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

//for games
    public void getAllGames() {
        GameEntity[] games = restTemplate.getForObject(gameUrl, GameEntity[].class);

        for (GameEntity game : games) {
            System.out.println(game);
        }
    }

    public void getPagedGames(Integer pageNumber, Integer pageSize) {
        String url = "http://localhost:8087/games/paged?pageNumber={pageNumber}&pageSize={pageSize}";
        Page<GameEntity> gamesPage = restTemplate.getForObject(url, Page.class, pageNumber, pageSize);

        if (gamesPage != null) {
            for (GameEntity game : gamesPage.getContent()) {
                System.out.println(game);
            }
        } else {
            System.out.println("Failed to retrieve paged games");
        }
    }

    public void getGameById(Long id) {
        String url = gameUrl + "/id/{id}";
        GameEntity game = restTemplate.getForObject(url, GameEntity.class, id);

        if (game != null) {
            System.out.println(game);
        } else {
            System.out.println("Game not found");
        }
    }

    public void getGamesByPlayerName(String playerName) {
        String url = gameUrl + "/player/name/{name}";
        GameEntity[] games = restTemplate.getForObject(url, GameEntity[].class, playerName);

        for (GameEntity game : games) {
            System.out.println(game);
        }
    }

    public void addGame(GameEntity game) {
        GameEntity createdGame = restTemplate.postForObject(gameUrl, game, GameEntity.class);

        if (createdGame != null) {
            System.out.println("Game created: " + createdGame);
        } else {
            System.out.println("Failed to create game");
        }
    }

    public void updateGame(Long id, GameEntity game) {
        String url = gameUrl + "/id/{id}";
        restTemplate.put(url, game, id);

        System.out.println("Game updated");
    }

    public void deleteGame(Long id) {
        String url = gameUrl + "/id/{id}";
        restTemplate.delete(url, id);

        System.out.println("Game deleted");
    }

//for players
    public void getAllPlayers() {
        PlayerEntity[] players = restTemplate.getForObject(playerUrl, PlayerEntity[].class);

        for (PlayerEntity player : players) {
            System.out.println(player);
        }
    }

    public void getPagedPlayer(Integer pageNumber, Integer pageSize) {
        String url = "http://localhost:8087/players/paged?pageNumber={pageNumber}&pageSize={pageSize}";
        Page<PlayerEntity> gamesPage = restTemplate.getForObject(url, Page.class, pageNumber, pageSize);

        if (gamesPage != null) {
            for (PlayerEntity player : gamesPage.getContent()) {
                System.out.println(player);
            }
        } else {
            System.out.println("Failed to retrieve paged games");
        }
    }

    public void getPlayerById(Long id) {
        String url = playerUrl + "/id/{id}";
        PlayerEntity player = restTemplate.getForObject(url, PlayerEntity.class, id);

        if (player != null) {
            System.out.println(player);
        } else {
            System.out.println("Player not found");
        }
    }

    public void getPlayersByName(String name) {
        String url = playerUrl + "/name/{name}";
        PlayerEntity[] players = restTemplate.getForObject(url, PlayerEntity[].class, name);

        for (PlayerEntity player : players) {
            System.out.println(player);
        }
    }

    public void addPlayer(PlayerEntity player) {
        PlayerEntity createdPlayer = restTemplate.postForObject(playerUrl, player, PlayerEntity.class);

        if (createdPlayer != null) {
            System.out.println("Player created: " + createdPlayer);
        } else {
            System.out.println("Failed to create player");
        }
    }

    public void updatePlayerName(Long id, String newName) {
        String url = playerUrl + "/id/{id}?name={newName}";
        restTemplate.put(url, null, id, newName);

        System.out.println("Player name updated");
    }

    public void deletePlayer(Long id) {
        String url = playerUrl + "/id/{id}";
        restTemplate.delete(url, id);

        System.out.println("Player deleted");
    }

}
