package notekeeper;

import java.io.Serializable;

public class ModuleInfo implements Serializable {
    private String mModuleId;
    private String mModuleTitle;
    private boolean isComplete;

    public ModuleInfo(String moduleId, String moduleTitle){
        this(moduleId, moduleTitle, false);
    }

    public ModuleInfo(String moduleId, String moduleTitle, boolean isComplete){
        this.mModuleId = moduleId;
        this.mModuleTitle = moduleTitle;
        this.isComplete = isComplete;
    }
    public String getmModuleId() {
        return mModuleId;
    }

    public void setmModuleId(String mModuleId) {
        this.mModuleId = mModuleId;
    }

    public String getmModuleTitle() {
        return mModuleTitle;
    }

    public void setmModuleTitle(String mModuleTitle) {
        this.mModuleTitle = mModuleTitle;
    }
    public void setModuleCompleteStatus(boolean status){
        this.isComplete = status;
    }
    public boolean getModulecompleteStatus(){
        return isComplete;
    }

}
