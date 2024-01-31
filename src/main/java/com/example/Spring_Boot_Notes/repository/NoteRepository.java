package com.example.Spring_Boot_Notes.repository;


import com.example.Spring_Boot_Notes.domein.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
