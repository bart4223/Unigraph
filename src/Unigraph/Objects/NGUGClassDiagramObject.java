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
        return FMembers.iterator();
    }

    public void addMember(String aMember) {
        FMembers.add(aMember);
    }

    public Iterator<String> getMethods() {
        return FMethods.iterator();
    }

    public void addMethod(String aMethod) {
        FMethods.add(aMethod);
    }

}
