import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

	@Test 
	public void testTask() {
        Task task = new Task("CS3200401", "JUnit Test", "Test the JUnit framework");
        assertTrue(task.getID().equals("CS3200401"));
        assertTrue(task.getName().equals("JUnit Test"));
        assertTrue(task.getDesc().equals("Test the JUnit framework"));

    }	
	@Test
	public void testTaskID() {
		
		//ID too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901234567890123456789012345678901234567", "JUnit Test", "Test the JUnit framework");
        });
        
        // ID is null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "JUnit Test", "Test the JUnit framework");
        });
        
	}
	@Test
	public void testTaskName() {
	
		// Check Name too Long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("CS3200401", "JUnit Teeeeeeeeeeeeeeeeeeeeeest", "Test the JUnit framework");
        });
		// Name is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("CS3200401", null, "Test the JUnit framework");
        });
	}
	@Test
	public void testTaskDescTooLong() {
		//Check Task Description too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("CS3200401", "JUnit Test", " Test the JUnit framework Test the JUnit frameworkTest the JUnit framework Test the JUnit framework Test the JUnit framework");
        });
		
		//check task description null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("CS3200401", "JUnit Test", null);
        });
	
	}
	
	@Test
	public void testSetName() {
		
		Task task = new Task( );
		
		//test set name to be null or too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setName(null);	
        });
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setName("JUnit Teeeeeeeeeeeeeeeeeeeeeest");
        });
		
		// test set name in appropriate form
		String newName = "Junit 5 Test";
		task.setName(newName);
		assertEquals(task.getName( ), newName);
		
	}

	@Test
	public void testSetDesc() {
		// Given
		Task task = new Task();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setDesc(null);
			
        });
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			task.setDesc("\" Test the JUnit framework Test the JUnit frameworkTest the JUnit framework Test the JUnit framework Test the JUnit framework\"");
        });
		
		String newDesc = " Test the JUnit 5 Framework";
		
		task.setDesc(newDesc);
		assertEquals(task.getDesc( ), newDesc);
	}
	
	@Test
	public void testGetters() {
		String name = "JUnit Test";
		String desc = "Test the JUnit framework";
		Task task = new Task("CS3200401", name, desc);
		
		assertEquals(task.getName( ), name);
		assertEquals(task.getDesc( ), desc);
		
	}

}