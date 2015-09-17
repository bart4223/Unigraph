package Unigraph.Objects;

import Unigraph.Base.NGUGCustomDiagramObject;

import java.util.ArrayList;
import java.util.Iterator;

public class NGUGClassDiagramObject extends NGUGCustomDiagramObject {

    protected ArrayList<String> FMembers;
    protected ArrayList<String> FMethods;

    public NGUGClassDiagramObject(String aName) {
        this(aName, null);
    }

    public NGUGClassDiagramObject(String aName, Object aReference) {
        super(aName, aReference);
        FMembers = new ArrayList<>();
        FMethods = new ArrayList<>();
    }

    @Override
    public final String getKind() {
        return "Class";
    }

    public Iterator<String> getMembers() {
        if (FReference != null)
            return null;
        else
            return FMembers.iterator();
    }

    public void addMember(String aField) {
        FMembers.add(aField);
    }

    public Iterator<String> getMethods() {
        if (FReference != null)
            return null;
        else
            return FMethods.iterator();
    }

    public void addMethod(String aMethod) {
        FMethods.add(aMethod);
    }

}
