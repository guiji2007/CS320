import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

	@Test
	public void addTaskShouldThrowExceptionWhenDuplicateID() {
		// Given 
		String tastID1 = "Task1 ID";
		String name = "Task 4 name";
		String desc = "Task 4 due date";
		
		//Throw exception when the task ID already exists
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.addTask(tastID1, name, desc);	
        });
		
	}
	@Test
	public void addTaskShouldReturnTrueWhenUnitID() {

		//Given
		String taskID2 = "Task4 ID";
		String name = "Task 4 name";
		String desc = "Task 4 due date";
		
		// When
		
		Task actual = TaskService.addTask(taskID2, name, desc);
		Task expected = TaskService.tasks.get(TaskService.tasks.size()-1);
				
		//Then
		assertAll(
				()->assertEquals(actual.getName(), expected.getName()), 
				()->assertEquals(actual.getDesc(), expected.getDesc())
		);
				
		
	}

	
	@Test
	public void deleteTaskShouldThrowExceptionWhenIDNotExist() {
		//Given
		String taskID3 = "Task10 ID";
		
		//Throw exception when the task ID already exists
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService.deleteTask(taskID3);	
		
        });
	}

	@Test
	public void deleteTaskShouldReturnTrueWhenExistingID() {
		//Given
		String taskID4 = "Task1 ID";
		Boolean taskIsDeleted = null;
		
		TaskService.deleteTask(taskID4);
		
		for (int i = 0; i<TaskService.tasks.size(); i++) {
			if (TaskService.tasks.get(i).getID().equals(taskID4)) {
				taskIsDeleted = false;
			}
			else taskIsDeleted = true;
		}
		
		assertTrue(taskIsDeleted);
		
	}
	
	@Test
	public void testUpdateTask() {
		//Given
		String ID = "Task3 ID";
		String newName = "Task 5 name";
		String newDesc = "Task 5 desc";
		
		//When
		Task taskUpdated = TaskService.updateTask(ID, newName, newDesc);
		
		Boolean expected = taskUpdated.getName().equals(newName) && taskUpdated.getDesc().equals(newDesc);
		
		//Then
		
		assertTrue(expected);
		
	}
	
	
	
	
	
	
}
