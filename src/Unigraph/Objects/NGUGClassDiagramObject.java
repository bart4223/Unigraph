package Unigraph.Objects;

import Unigraph.Base.NGUGCustomDiagramObject;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class NGUGClassDiagramObject extends NGUGCustomDiagramObject {

    protected CopyOnWriteArrayList<String> FMembers;
    protected CopyOnWriteArrayList<String> FMethods;

    public NGUGClassDiagramObject(String aName) {
        this(aName, null);
    }

    public NGUGClassDiagramObject(String aName, Object aReference) {
        super(aName, aReference);
        FMembers = new CopyOnWriteArrayList<>();
        FMethods = new CopyOnWriteArrayList<>();
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
