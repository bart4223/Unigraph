package Unigraph.Base;

import Uniwork.Base.NGObject;

import java.util.UUID;

public abstract class NGUGCustomDiagramObject extends NGObject {

    protected String FID;
    protected String FName;
    protected String FDescription;
    protected Object FReference;
    protected Boolean FIsSelected;

    public NGUGCustomDiagramObject(String aName) {
        this(aName, null);
    }

    public NGUGCustomDiagramObject(String aName, Object aReference) {
        super();
        FID = UUID.randomUUID().toString();
        FName = aName;
        FReference = aReference;
        FIsSelected = false;
    }

    public String getKind() {
        return "";
    }

    public String getID() {
        return FID;
    }

    public String getName() {
        return FName;
    }

    public String getDescription() {
        return FDescription;
    }

    public void setDescription(String aDescription) {
        FDescription = aDescription;
    }

    public Object getReference() {
        return FReference;
    }

    public void setIsSelected(Boolean aValue) {
        FIsSelected = aValue;
    }

    public Boolean getIsSelected() {
        return FIsSelected;
    }

}
