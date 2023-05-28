package homework.services;

import homework.entities.PlayerEntity;
import homework.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Page<PlayerEntity> getIdOrderedPaged(Integer pageNumber, Integer pageSize) {
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return playerRepository.findAll(pageable);
    }
}

