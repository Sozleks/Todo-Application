package ru.sozleks.todo.repository;

import ru.sozleks.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task, Long> {
    
}