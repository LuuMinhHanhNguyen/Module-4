package com.example.ex2.service;

import com.example.ex2.model.Song;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ISongService {
    List<Song> getAllSongs();

    void save(Song newSong);

    void deleteSong(Integer songId);

    Song findById(Integer id);

    boolean checkExistence(Integer id);


}
