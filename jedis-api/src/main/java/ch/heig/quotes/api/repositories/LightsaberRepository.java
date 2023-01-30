package ch.heig.quotes.api.repositories;

import ch.heig.quotes.api.entities.LightsaberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LightsaberRepository extends JpaRepository<LightsaberEntity, Integer> {
    /*LightsaberEntity findById(int id);
    List<LightsaberEntity> findByColorLike(String pattern);*/
}
