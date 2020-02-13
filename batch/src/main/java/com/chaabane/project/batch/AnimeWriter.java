package com.chaabane.project.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimeWriter implements ItemWriter<AnimeDTO> {

    @Autowired
    private AnimeRepo animeRepo;

    private static final Logger log = LoggerFactory.getLogger(AnimeProcessor.class);

    @Override
    public void write(List<? extends AnimeDTO> list) throws Exception {
        animeRepo.saveAll(list);
        log.info(list + " Save Successfully!");

    }
}
