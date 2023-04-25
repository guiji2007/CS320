import java.util.ArrayList;
import java.util.Arrays;



class TaskService {
    static Task task1 = new Task("Task1 ID", "Task 1 name", "Task 1 due date");
    static Task task2 = new Task("Task2 ID", "Task 2 name", "Task 2 due date");
    static Task task3 = new Task("Task3 ID", "Task 3 name", "Task 3 due date");

    static ArrayList<Task> tasks = new ArrayList<>(Arrays.asList(task1, task2, task3));

    public static Task addTask(String ID, String name, String desc){
        if (tasks.stream().anyMatch(task -> task.getID().equals(ID))){
        	 throw new IllegalArgumentException("ID already exists");
        }
        Task task4 = new Task(ID, name, desc);
        tasks.add(task4); 
        System.out.println("The task has been added!");
        return task4;
  
    }
    
    
    public static void deleteTask(String ID){
        if (tasks.stream().anyMatch(task -> task.getID().equals(ID))){
            tasks.removeIf(task -> task.getID().equals(ID));
            System.out.println("The task has been deleted!");
        }else{
            throw new IllegalArgumentException("ID does not exist!");
        }
    }
    
    
    public static Task updateTask(String ID, String name, String desc) {
    	
    	Task taskToUpdate = tasks.stream()
    			.filter(task-> ID.equals(task.getID()))
    			.findAny()
    			.orElse(null);
    	
    	taskToUpdate.setName(name);
    	taskToUpdate.setDesc(desc);
    	
    	System.out.println("The task has been updated!");
    	
    	return taskToUpdate;
    	
    }
    
    
    
    
}