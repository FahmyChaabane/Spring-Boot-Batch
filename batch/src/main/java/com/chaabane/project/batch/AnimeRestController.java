package com.chaabane.project.batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/")
public class AnimeRestController {

    @Autowired
    private AnimeRepo animeRepo;

    @GetMapping("/anime")
    public Collection<AnimeDTO> load(@RequestParam(name="page", defaultValue = "0") int p,
                                     @RequestParam(name="size", defaultValue = "10") int s) {
        Page<AnimeDTO> animePages = animeRepo.findAll(PageRequest.of(p, s, Sort.by("id")));
        return animePages.getContent();
    }
}
