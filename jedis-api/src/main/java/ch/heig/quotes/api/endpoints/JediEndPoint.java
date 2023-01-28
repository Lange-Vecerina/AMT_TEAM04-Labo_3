package ch.heig.quotes.api.endpoints;
import ch.heig.quotes.api.entities.JediEntity;
import ch.heig.quotes.api.repositories.JediRepository;
//import org.openapitools.api.QuotesApi;
import ch.heig.quotes.api.exceptions.QuoteNotFoundException;
//import org.openapitools.model.Quote;
import ch.heig.quotes.api.entities.JediEntity;
import ch.heig.quotes.api.repositories.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.openapitools.model.Jedi;
import org.openapitools.api.JedisApi;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class JediEndPoint implements JedisApi {

        @Autowired
        private JediRepository jediRepository;

        @Override
        public ResponseEntity<List<Jedi>> getJedis() {
            List<JediEntity> jediEntities= jediRepository.findAll();
            List<Jedi> jedis  = new ArrayList<>();
            for (JediEntity jediEntity : jediEntities) {
                Jedi jedi = new Jedi();
                jedi.setId(jediEntity.getId());
                jedi.setName(jediEntity.getName());
                jedi.setRank(jediEntity.getRank());
                jedis.add(jedi);
            }
            return new ResponseEntity<List<Jedi>>(jedis,HttpStatus.OK);
        }

        @Override
        public ResponseEntity<Void> addJedi(@RequestBody Jedi jedi) {
            JediEntity jediEntity = new JediEntity();
            jediEntity.setName(jedi.getName());
            jediEntity.setRank(jedi.getRank());
            JediEntity jediAdded = jediRepository.save(jediEntity);
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(jediAdded.getId())
                    .toUri();
            return ResponseEntity.created(uri).build();
        }

        @Override
        public ResponseEntity<Jedi> getJedi(Integer id) {
            Optional<JediEntity> opt = jediRepository.findById(id);
            if (opt.isPresent()) {
                JediEntity jediEntity = opt.get();
                Jedi jedi = new Jedi();
                jedi.setId(jediEntity.getId());
                jedi.setName(jediEntity.getName());
                jedi.setRank(jediEntity.getRank());
                return new ResponseEntity<Jedi>(jedi,HttpStatus.OK);
            } else {
                throw new QuoteNotFoundException(id);
            }
        }

}

/*@RestController
public class QuotesEndPoint implements QuotesApi {

    @Autowired
    private QuoteRepository quoteRepository;

    @Override
    public ResponseEntity<List<Quote>> getQuotes() {
        List<QuoteEntity> quoteEntities= quoteRepository.findAll();
        List<Quote> quotes  = new ArrayList<>();
        for (QuoteEntity quoteEntity : quoteEntities) {
            Quote quote = new Quote();
            quote.setId(quoteEntity.getId());
            quote.setAuthor(quoteEntity.getAuthor());
            quote.setCitation(quoteEntity.getCitation());
            quotes.add(quote);
        }
        return new ResponseEntity<List<Quote>>(quotes,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> addQuote(@RequestBody Quote quote) {
        QuoteEntity quoteEntity = new QuoteEntity();
        quoteEntity.setAuthor(quote.getAuthor());
        quoteEntity.setCitation(quote.getCitation());
        QuoteEntity quoteAdded = quoteRepository.save(quoteEntity);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(quoteAdded.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Quote> getQuote(Integer id) {
        Optional<QuoteEntity> opt = quoteRepository.findById(id);
        if (opt.isPresent()) {
            QuoteEntity quoteEntity = opt.get();
            Quote quote = new Quote();
            quote.setId(quoteEntity.getId());
            quote.setAuthor(quoteEntity.getAuthor());
            quote.setCitation(quoteEntity.getCitation());
            return new ResponseEntity<Quote>(quote, HttpStatus.OK);
        } else {
//            return ResponseEntity.notFound().build();
            throw new QuoteNotFoundException(id);
        }
    }

}*/
