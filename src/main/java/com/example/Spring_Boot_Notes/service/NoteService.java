package com.example.Spring_Boot_Notes.service;


import com.example.Spring_Boot_Notes.domein.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    List<Note> getAllNote();
    Note getNoteById(Long id);

    Note updateNote(Note note);

    Note createNote(Note note);

    void deleteNote(Long id);

}
