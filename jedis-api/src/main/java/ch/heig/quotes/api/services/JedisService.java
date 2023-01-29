package ch.heig.quotes.api.services;

import ch.heig.quotes.api.entities.JediEntity;
import ch.heig.quotes.api.entities.LightsaberEntity;
import ch.heig.quotes.api.exceptions.JediNotFoundException;
import ch.heig.quotes.api.exceptions.LightsaberNotFoundException;
import ch.heig.quotes.api.repositories.JediRepository;
import org.openapitools.model.Jedi;
import org.openapitools.model.Lightsaber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JedisService {

    @Autowired
    private JediRepository jediRepository;

    public List<Jedi> getJedis() {
        List<JediEntity> jediEntities = jediRepository.findAll();
        List<Jedi> jedis = new ArrayList<>();
        for (JediEntity jediEntity : jediEntities) {
            Jedi jedi = new Jedi();
            jedi.setId(jediEntity.getId());
            jedi.setName(jediEntity.getName());
            jedi.setRank(jediEntity.getRank());
            jedis.add(jedi);
        }
        return jedis;
    }

    public URI addJedi(@RequestBody Jedi jedi) {
        JediEntity jediEntity = new JediEntity();
        jediEntity.setName(jedi.getName());
        jediEntity.setRank(jedi.getRank());
        JediEntity jediAdded = jediRepository.save(jediEntity);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(jediAdded.getId())
                .toUri();
        return uri;
    }

    public Jedi getJedi(Integer id) {
        Optional<JediEntity> opt = jediRepository.findById(id);
        if (opt.isPresent()) {
            JediEntity jediEntity = opt.get();
            Jedi jedi = new Jedi();
            jedi.setId(jediEntity.getId());
            jedi.setName(jediEntity.getName());
            jedi.setRank(jediEntity.getRank());
            return jedi;
        } else {
            throw new JediNotFoundException(id);
        }
    }

    public URI updateJedi(Integer id, Jedi jedi) {
        Optional<JediEntity> opt = jediRepository.findById(id);
        if (opt.isPresent()) {
            JediEntity jediEntity = opt.get();
            jediEntity.setName(jedi.getName());
            jediEntity.setRank(jedi.getRank());
            jediRepository.save(jediEntity);
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(jedi.getId())
                    .toUri();
            return uri;
        } else {
            throw new JediNotFoundException(id);
        }
    }

    public List<Lightsaber> getLightsabers(Integer id) {
        Optional<JediEntity> opt = jediRepository.findById(id);
        if (opt.isPresent()) {
            JediEntity jediEntity = opt.get();
            List<Lightsaber> lightsabers = new ArrayList<>();
            for (LightsaberEntity lightsaberEntity : jediEntity.getLightsabers()) {
                Lightsaber lightsaber = new Lightsaber();
                lightsaber.setId(lightsaberEntity.getId());
                lightsaber.setColor(lightsaberEntity.getColor());
                lightsabers.add(lightsaber);
            }
            return lightsabers;
        } else {
            throw new LightsaberNotFoundException(id);
        }
    }

    public URI addLightsaber(Integer id, Lightsaber lightsaber) {
        Optional<JediEntity> opt = jediRepository.findById(id);
        if (opt.isPresent()) {
            JediEntity jediEntity = opt.get();
            LightsaberEntity lightsaberEntity = new LightsaberEntity();
            lightsaberEntity.setColor(lightsaber.getColor());
            jediEntity.getLightsabers().add(lightsaberEntity);
            jediRepository.save(jediEntity);
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(lightsaber.getId())
                    .toUri();
            return uri;
        } else {
            throw new LightsaberNotFoundException(id);
        }
    }
}

