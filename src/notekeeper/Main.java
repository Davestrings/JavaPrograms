package notekeeper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static ObjectOutputStream output;
    private static ObjectInputStream input;

    public static void main(String[] args){
        openFile();
        writeRecord();
        readFile();
        readRecord();
    }
    public static void openFile(){
        try{
            FileOutputStream file = new FileOutputStream("course.tmp", true);
            output = new ObjectOutputStream(file);
        }catch(IOException ex){
        System.err.println("Error opening file");
        System.exit(-1);
        }
    }
    public static void writeRecord(){
        ModuleInfo tModule = new ModuleInfo("class members", "Instance variable", false);
        ModuleInfo tModule2 = new ModuleInfo("Iterators2", "For loop", true);
        ModuleInfo tModule3 = new ModuleInfo("Iterators3", "Do while", true);
        ModuleInfo tModule1 = new ModuleInfo("Iterators1", "while loop", false);

        List<ModuleInfo> module = new ArrayList<>();
        List<ModuleInfo> modules = new ArrayList<>();

        CourseInfo course1 = new CourseInfo("Java Basics", "Methods and Classes", module);
        CourseInfo course2 = new CourseInfo("Java Fundamentals", "Iterators", modules);

        module.add(tModule);
        modules.add(tModule2);
        modules.add(tModule1);
        modules.add(tModule3);

        List<CourseInfo> courseInfos = new ArrayList<>();
        courseInfos.add(course1);
        courseInfos.add(course2);

        try{
            output.writeObject(courseInfos);
            output.close();
            System.out.println("Object has been serialized");
        }catch (IOException ex){
            System.err.println("Error writing to file");
            System.exit(-1);
        }


    }
    public static void readFile(){
        try{
            FileInputStream file = new FileInputStream("course.tmp");
            input = new ObjectInputStream(file);
        }catch(IOException ex){
            System.err.println("Error opening file");
            System.exit(-1);
        }
    }
    public static void readRecord(){
        try{
            List<CourseInfo> courseInfos = (List<CourseInfo>) input.readObject();
            for(CourseInfo course : courseInfos){
                System.out.println(course);
            }
            input.close();
            System.out.println("File read sucessfully");
        }catch (IOException ex){
            System.err.println("Error reading file");
            System.exit(-1);
        }catch (ClassNotFoundException ex){
            System.err.println("Class cast error");
            System.exit(-1);
        }
    }
}
