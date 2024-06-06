Main.java

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Random;

public class Main { //Is the UI - frontend

    public static TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {

        //Create a menu:
        //Put it in a while loop
        //Use scanner
        //if the user presses 1, we call CreateTask
        //if the user presses 2, we call showTodoList
        //if the user presses 3, ask the task name with isDone = true
        //if the user presses x, close the loop
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Press 1 to create a task.");
            System.out.println("Press 2 to show the ToDo list.");
            System.out.println("Press 3 to set a task as DONE.");
            System.out.println("Press 4 to to see the done tasks.");
            System.out.println("Press 5 to exit.");
            var userInput = scanner.nextLine();
            if(userInput.equals("1")){
                createTask();
            }else if(userInput.equals("2")){
                System.out.println("Words of wisdom to start with: " + getRandomQuote());
                showTodoList();
            }else if(userInput.equals("3")){
                showTodoList();
                System.out.println("Enter the finished task name: ");
                var taskName = scanner.nextLine();
                taskManager.setTaskAsDone(taskName);
            }else if(userInput.equals("4")){
                showDoneTasks();
            }else if(userInput.equals("5")){
                break;
            }else{
                break;
            }
        }
    }

    private static String getRandomQuote() {

        String[] quotes = {
                "The secret of getting ahead is getting started.",
                "Your time is limited, don't waste it living someone else's life.",
                "Don't wait. The time will never be just right.",
                "If you spend too much time thinking about a thing, you'll never get it done.",
                "The way to get started is to quit talking and begin doing."
        };

        int randomIndex = new Random().nextInt(quotes.length);
        return quotes[randomIndex];

    }


    public static void showDoneTasks(){
        var tasks = taskManager.getTasks();
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            var task = iterator.next();
            if(task.isDone){
                System.out.println("\nThis is a done TASK:");
                System.out.println("Name: " + task.name);
                System.out.println("Description :" + task.description);
                System.out.println("Task is done: " + task.isDone);

                iterator.remove();
            }
        }
    }
    public static void createTask(){
        Scanner scanner = new Scanner(System.in);
        // Input the task name
        System.out.println("Please input the name of the task: ");
        var name = scanner.nextLine();
        // Input the task description
        System.out.println("Please input the description of the task: ");
        var description = scanner.nextLine();

        var task = new Task(name, description);
        taskManager.addTask(task);
    }
    public static void showTodoList(){
        var tasks = taskManager.getTasks();
        for(var task : tasks){
            System.out.println("\nThis is a to do TASK:");
            System.out.println("Name: " + task.name);
            System.out.println("Description :" + task.description);
            System.out.println("Task is done: " + task.isDone);
        }
    }
}


TaskManager.java

import java.util.ArrayList;

public class TaskManager{
    //MVP: Minimum Viable Product
    //Be able to add a Task -> DONE
    //Have a list of all the tasks -> getTasks();
    //Set a task as done, by Task name

    private ArrayList<Task> tasks = new ArrayList<Task>();
    private ArrayList<Task> doneTasks = new ArrayList<Task>();

    //Because we want to use the default constructor
    // new TaskManager() - we don't need to add a custom constructor

    public void addTask(Task task){
        tasks.add(task);
    }

    public void removeTask(Task task){
        tasks.remove(task);
        doneTasks.add(task);
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public void setTaskAsDone(String taskName){
        tasks.stream()
                .filter(x -> x.name.equals(taskName))
                .findFirst()
                .ifPresent(x -> x.isDone = true);
    }

}


Task.java


/*
main.java -> we are getting the user input, we are sending this input to taskManager, show information to the user
taskManager.java -> we can add tasks to the list, we can mark them as done and we can get the list
task.java -> template for a task (name, description, date, itIsDone)
*/


public class Task{
    public String name;
    public String description;
    public boolean isDone;

    // var task = new Task(name, description);
    public Task(String name, String description){
        this.name = name;
        this.description = description;
    }
}
