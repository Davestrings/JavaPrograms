package notekeeper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CourseInfo implements Serializable {
    private String courseId;
    private String courseTitle;
    private List<ModuleInfo> modules = new ArrayList<>();

    public CourseInfo(String cId, String cTitle, List<ModuleInfo> module) {
        courseId = cId;
        courseTitle = cTitle;
        modules = module;
    }
    public CourseInfo(String cId, String cTitle){
        courseId = cId;
        courseTitle = cTitle;
    }
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
    public void addModules(ModuleInfo module){
        modules.add(module);
    }
    public void removeModule(ModuleInfo module){
        for(ModuleInfo moduleInfo : modules){
            if(moduleInfo.getmModuleId() == module.getmModuleId())
                modules.remove(module);
        }
    }
    public List<ModuleInfo> getModules(){
        return modules;
    }

    @Override
    public String toString(){
        return courseTitle;
    }

}
