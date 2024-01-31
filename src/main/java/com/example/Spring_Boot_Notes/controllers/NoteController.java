package com.example.Spring_Boot_Notes.controllers;


import com.example.Spring_Boot_Notes.domein.Note;
import com.example.Spring_Boot_Notes.service.NoteImplementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteImplementService noteImplementService;


    @GetMapping
    public ResponseEntity<List> getAll(){
        return new ResponseEntity<>(noteImplementService.getAllNote(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteImplementService.createNote(note), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable("id")Long id){
        Note note;
        try {
            note = noteImplementService.getNoteById(id);
        } catch (RuntimeException a){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Note());
        }
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@RequestBody Note note, Long id){
        return new ResponseEntity<>(noteImplementService.updateNote(note), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id){
        noteImplementService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
