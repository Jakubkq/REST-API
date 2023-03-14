package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.DbService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DbServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private DbService dbService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllTasks() {
        // given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "Test Task 1", "Test Description 1"));
        taskList.add(new Task(2L, "Test Task 2", "Test Description 2"));

        Mockito.when(taskRepository.findAll()).thenReturn(taskList);

        // when
        List<Task> result = dbService.getAllTasks();

        // then
        Assertions.assertEquals(taskList, result);
    }

    @Test
    public void testSaveTask() {
        // given
        Task task = new Task(1L, "Test Task", "Test Description");

        Mockito.when(taskRepository.save(task)).thenReturn(task);

        // when
        Task result = dbService.saveTask(task);

        // then
        Assertions.assertEquals(task, result);
    }

    @Test
    public void testGetTaskSuccess() throws TaskNotFoundException {
        // given
        Long id = 1L;
        Task task = new Task(id, "Test Task", "Test Description");

        Mockito.when(taskRepository.findById(id)).thenReturn(Optional.of(task));

        // when
        Task result = dbService.getTask(id);

        // then
        Assertions.assertEquals(task, result);
    }

    @Test
    public void testDeleteByIdSuccess() throws TaskNotFoundException {
        // given
        Long id = 1L;
        Task task = new Task(id, "Test Task", "Test Description");

        Mockito.when(taskRepository.findById(id)).thenReturn(Optional.of(task));

        // when
        dbService.deleteById(id);

        // then
        Mockito.verify(taskRepository, Mockito.times(1)).deleteById(id);
    }
}