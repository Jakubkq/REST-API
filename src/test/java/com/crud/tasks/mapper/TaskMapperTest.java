package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskMapperTest {

    private final TaskMapper mapper = new TaskMapper();

    @Test
    public void mapToTask() {
        TaskDto taskDto = new TaskDto(1L, "test_title", "test_content");

        Task task = mapper.mapToTask(taskDto);

        assertEquals(taskDto.getId(), task.getId());
        assertEquals(taskDto.getTitle(), task.getTitle());
        assertEquals(taskDto.getContent(), task.getContent());
    }

    @Test
    public void mapToTaskDto() {
        Task task = new Task(1L, "test_title", "test_content");

        TaskDto taskDto = mapper.mapToTaskDto(task);

        assertEquals(task.getId(), taskDto.getId());
        assertEquals(task.getTitle(), taskDto.getTitle());
        assertEquals(task.getContent(), taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoList() {
        Task task1 = new Task(1L, "test_title_1", "test_content_1");
        Task task2 = new Task(2L, "test_title_2", "test_content_2");
        List<Task> taskList = Arrays.asList(task1, task2);

        List<TaskDto> taskDtoList = mapper.mapToTaskDtoList(taskList);

        assertEquals(2, taskDtoList.size());
        assertEquals(task1.getId(), taskDtoList.get(0).getId());
        assertEquals(task1.getTitle(), taskDtoList.get(0).getTitle());
        assertEquals(task1.getContent(), taskDtoList.get(0).getContent());
        assertEquals(task2.getId(), taskDtoList.get(1).getId());
        assertEquals(task2.getTitle(), taskDtoList.get(1).getTitle());
        assertEquals(task2.getContent(), taskDtoList.get(1).getContent());
    }
}