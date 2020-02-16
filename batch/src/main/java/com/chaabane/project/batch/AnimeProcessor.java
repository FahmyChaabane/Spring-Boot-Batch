package com.chaabane.project.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AnimeProcessor implements ItemProcessor<AnimeDTO, AnimeDTO> {

    private static final Logger log = LoggerFactory.getLogger(AnimeProcessor.class);
    @Override
    public AnimeDTO process(final AnimeDTO animeDTO) throws Exception {
        final String id = animeDTO.getId();
        final String title = animeDTO.getTitle().toUpperCase();
        final String description = animeDTO.getDescription();
        final AnimeDTO transformedAnimeDTO = new AnimeDTO(id, title, description, new Date());
        log.info("Converting (" + animeDTO + ") into (" + transformedAnimeDTO + ")");
        return transformedAnimeDTO;
    }
}
