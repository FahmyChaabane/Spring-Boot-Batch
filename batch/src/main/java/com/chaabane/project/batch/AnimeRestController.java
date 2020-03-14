package com.chaabane.project.batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class AnimeRestController {

    @Autowired
    private AnimeRepo animeRepo;

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/anime")
    public ResponseEntity<AnimeResponse> load(@RequestParam(name="page", defaultValue = "0") int p,
                                     @RequestParam(name="size", defaultValue = "50") int s,
                                              @RequestParam(name="criterion", defaultValue ="") String criterion){
        AnimeResponse animeResponse = new AnimeResponse();
        try {
            //Page<AnimeDTO> animePageable= animeRepo.findAll(PageRequest.of(p, s, Sort.by("id")));
            Page<AnimeDTO> animePageable= animeRepo.animeDTOByTitles("%"+criterion+"%", PageRequest.of(p,s,Sort.by("id")));
            animeResponse.setAnimeDTOArrayList(animePageable.getContent());
            animeResponse.setPagesNumber(new int[animePageable.getTotalPages()]);
        } catch(Exception e) {
            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(animeResponse, HttpStatus.OK);
    }
}
