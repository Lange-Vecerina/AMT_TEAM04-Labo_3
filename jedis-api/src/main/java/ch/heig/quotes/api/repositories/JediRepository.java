package ch.heig.quotes.api.repositories;

import ch.heig.quotes.api.entities.JediEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JediRepository extends JpaRepository<JediEntity, Integer> {
        JediEntity findById(int id);
        List<JediEntity> findByNameLike(String pattern);
}

