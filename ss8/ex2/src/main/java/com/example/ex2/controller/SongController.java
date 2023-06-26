package com.example.ex2.controller;

import com.example.ex2.model.Song;
import com.example.ex2.model.SongDTO;
import com.example.ex2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;

@RequestMapping("/songs")
@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;

    @RequestMapping()
    public String showAll(Model model) {
        model.addAttribute("songs", iSongService.getAllSongs());
        return "/home";
    }

    @GetMapping("/create")
    public String addNewSong(Model model) {
        model.addAttribute("songDTO", new SongDTO());
        return "/create";
    }

    @PostMapping("/create")
    public String addNewSong(@Validated @ModelAttribute SongDTO songDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new SongDTO().validate(songDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Song songEntity = new Song();
        BeanUtils.copyProperties(songDTO, songEntity);
        iSongService.save(songEntity);
        redirectAttributes.addFlashAttribute("message", "Song added!");
        return "redirect:/songs";
    }

    @PostMapping("/delete")
    public String deleteSong(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        iSongService.deleteSong(id);
        redirectAttributes.addFlashAttribute("message", "Song deleted!");
        return "redirect:/songs";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (iSongService.checkExistence(id)) {
            model.addAttribute("songDTO", iSongService.findById(id));
            return "/update";
        } else {
            redirectAttributes.addFlashAttribute("message", "Invalid ID!");
            return "redirect:/songs";
        }

    }

    @PostMapping("/update")
    public String updateSong(@Validated @ModelAttribute SongDTO songDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new SongDTO().validate(songDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/update";
        }

        Song songEntity = new Song();
        BeanUtils.copyProperties(songDTO, songEntity);
        iSongService.save(songEntity);
        redirectAttributes.addFlashAttribute("message", "Song updated!");
        return "redirect:/songs";
    }


}
