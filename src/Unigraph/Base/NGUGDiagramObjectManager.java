package Unigraph.Base;

import Unigraph.NGUnigraphConsts;
import Uniwork.Base.NGComponent;

import java.util.ArrayList;
import java.util.Iterator;

public class NGUGDiagramObjectManager extends NGComponent {

    protected ArrayList<NGUGCustomDiagramObject> FObjects;
    protected ArrayList<NGUGCustomDiagramLink> FLinks;
    protected ArrayList<NGUGDiagramEventListener> FEventListeners;

    protected synchronized void raiseObjectAddedEvent(NGUGCustomDiagramObject aDiagramObject) {
        NGUGDiagramObjectEvent event = new NGUGDiagramObjectEvent(this, aDiagramObject);
        for (NGUGDiagramEventListener listener : FEventListeners) {
            listener.handleObjectAdded(event);
        }
    }

    protected synchronized void raiseLinkAddedEvent(NGUGCustomDiagramLink aDiagramLink) {
        NGUGDiagramLinkEvent event = new NGUGDiagramLinkEvent(this, aDiagramLink);
        for (NGUGDiagramEventListener listener : FEventListeners) {
            listener.handleLinkAdded(event);
        }
    }

    public NGUGDiagramObjectManager(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FObjects = new ArrayList<>();
        FLinks = new ArrayList<>();
        FEventListeners = new ArrayList<>();
    }

    public Iterator<NGUGCustomDiagramObject> getObjects() {
        return FObjects.iterator();
    }

    public Iterator<NGUGCustomDiagramLink> getLinks() {
        return FLinks.iterator();
    }

    public void addEventListener(NGUGDiagramEventListener aListener)  {
        FEventListeners.add(aListener);
    }

    public void removeEventListener(NGUGDiagramEventListener aListener)   {
        FEventListeners.remove(aListener);
    }

    public void addDiagramObject(NGUGCustomDiagramObject aDiagramObject) {
        FObjects.add(aDiagramObject);
        raiseObjectAddedEvent(aDiagramObject);
        writeInfo(NGUnigraphConsts.C_DEBUG_OBJECT_ADD, String.format("Diagram object %s [%s] added", aDiagramObject.getKind(), aDiagramObject.getName()));
    }

    public void addDiagramLink(NGUGCustomDiagramLink aDiagramLink) {
        FLinks.add(aDiagramLink);
        raiseLinkAddedEvent(aDiagramLink);
        writeInfo(NGUnigraphConsts.C_DEBUG_OBJECT_ADD, String.format("Diagram link %s added", aDiagramLink.getKind()));
    }

    public NGUGCustomDiagramObject getDiagramObjectByID(String aID) {
        for (NGUGCustomDiagramObject obj : FObjects) {
            if (obj.getID().equals(aID))
                return obj;
        }
        return null;
    }

    public NGUGCustomDiagramObject getDiagramObjectByRef(Object aRefObject) {
        for (NGUGCustomDiagramObject obj : FObjects) {
            if (obj.getReference().equals(aRefObject))
                return obj;
        }
        return null;
    }

}
