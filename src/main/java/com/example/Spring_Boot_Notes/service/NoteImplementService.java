package com.example.Spring_Boot_Notes.service;


import com.example.Spring_Boot_Notes.domein.Note;
import com.example.Spring_Boot_Notes.repository.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class NoteImplementService implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public List<Note> getAllNote() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(null);
    }

    @Override
    public Note updateNote(Note note) {

        Note noteById = getNoteById(note.getId());
        noteById.setId(note.getId());
        noteById.setHeading(note.getHeading());
        noteById.setContent(note.getContent());
        noteById.setLocalDateTime(note.getLocalDateTime());
        return noteRepository.save(noteById);
    }

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long id) {
        Note noteById = getNoteById(id);
        noteRepository.delete(noteById);
    }
}
