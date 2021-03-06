package Unigraph.Objects;

import Unigraph.Base.NGUGCustomDiagramObject;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class NGUGTableDiagramObject extends NGUGCustomDiagramObject {

    protected CopyOnWriteArrayList<String> FFields;

    public NGUGTableDiagramObject(String aName) {
        this(aName, null);
    }

    public NGUGTableDiagramObject(String aName, Object aReference) {
        super(aName, aReference);
        FFields = new CopyOnWriteArrayList<>();
    }

    @Override
    public final String getKind() {
        return "Table";
    }

    public Iterator<String> getFields() {
        return FFields.iterator();
    }

    public void addField(String aField) {
        FFields.add(aField);
    }

}
