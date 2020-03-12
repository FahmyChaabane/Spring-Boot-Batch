package com.chaabane.project.batch;

import java.util.List;

public class AnimeResponse {

    private List<AnimeDTO> animeDTOArrayList;
    private int[] pagesNumber;

    public List<AnimeDTO> getAnimeDTOArrayList() {
        return animeDTOArrayList;
    }

    public void setAnimeDTOArrayList(List<AnimeDTO> animeDTOArrayList) {
        this.animeDTOArrayList = animeDTOArrayList;
    }

    public int[] getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int[] pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    @Override
    public String toString() {
        return "AnimeResponse{" +
                "animeDTOArrayList=" + animeDTOArrayList +
                ", pagesNumber=" + pagesNumber +
                '}';
    }
}
