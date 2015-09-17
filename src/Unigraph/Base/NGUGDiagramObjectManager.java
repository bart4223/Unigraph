package Unigraph.Base;

import Unigraph.NGUnigraphConsts;
import Uniwork.Base.NGComponent;

import java.util.ArrayList;
import java.util.Iterator;

public class NGUGDiagramObjectManager extends NGComponent {

    protected ArrayList<NGUGCustomDiagramObject> FObjects;
    protected ArrayList<NGUGCustomDiagramLink> FLinks;

    public NGUGDiagramObjectManager(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FObjects = new ArrayList<>();
        FLinks = new ArrayList<>();
    }

    public Iterator<NGUGCustomDiagramObject> getObjects() {
        return FObjects.iterator();
    }

    public Iterator<NGUGCustomDiagramLink> getLinks() {
        return FLinks.iterator();
    }

    public void addObject(NGUGCustomDiagramObject aDiagramObject) {
        FObjects.add(aDiagramObject);
        writeInfo(NGUnigraphConsts.C_DEBUG_OBJECT_ADD, String.format("Diagram object %s [%s] added", aDiagramObject.getKind(), aDiagramObject.getName()));
    }

    public void addLink(NGUGCustomDiagramLink aDiagramLink) {
        FLinks.add(aDiagramLink);
        writeInfo(NGUnigraphConsts.C_DEBUG_OBJECT_ADD, String.format("Diagram link %s added", aDiagramLink.getKind()));
    }

}
