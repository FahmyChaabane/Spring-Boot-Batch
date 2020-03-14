package com.chaabane.project.batch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepo extends JpaRepository<AnimeDTO, String> {

    @Query(value = "select a from AnimeDTO a where a.title like :x")
    public Page<AnimeDTO> animeDTOByTitles(@Param("x") String title, Pageable pageable);
}
