package com.example.ex2.repository;

import com.example.ex2.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISongRepository extends JpaRepository<Song, Integer> {
    List<Song> findAllByDeleteFlagIsFalse();
}
