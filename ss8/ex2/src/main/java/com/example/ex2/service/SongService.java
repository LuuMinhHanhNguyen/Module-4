package com.example.ex2.service;

import com.example.ex2.model.Song;
import com.example.ex2.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository iSongRepository;
    @Override
    public List<Song> getAllSongs() {
        return iSongRepository.findAllByDeleteFlagIsFalse();
    }


    @Transactional
    @Override
    public void save(Song newSong) {
        newSong.setDeleteFlag(false);
        iSongRepository.save(newSong);
    }

    @Override
    public Song findById(Integer id) {
        return iSongRepository.findById(id).get();
    }

    @Override
    public boolean checkExistence(Integer id) {
        return iSongRepository.existsById(id);
    }


    @Transactional
    @Override
    public void deleteSong(Integer songId) {
        Song deletedSong = this.findById(songId);
        deletedSong.setDeleteFlag(true);
        iSongRepository.save(deletedSong);
    }



}
