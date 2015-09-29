package Unigraph.Visuals;

import Unigraph.Base.*;
import Uniwork.Base.NGComponent;

import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.Iterator;

public class NGUG2DDiagramLayoutManager extends NGComponent {

    protected ArrayList<NGUGCustomDiagramObjectLayout> FObjectLayouts;
    protected ArrayList<NGUGCustomDiagramLinkLayout> FLinkLayouts;
    protected ArrayList<NGUGDiagramLayoutEventListener> FEventListeners;
    protected ArrayList<NGUG2DDiagramLayer> FDiagramLayers;

    protected synchronized void raiseLayerAddedEvent(NGUG2DDiagramLayer aDiagramLayer) {
        NGUG2DDiagramLayerEvent event = new NGUG2DDiagramLayerEvent(this, aDiagramLayer);
        for (NGUGDiagramLayoutEventListener listener : FEventListeners) {
            if (listener instanceof NGUG2DDiagramLayoutEventListener) {
                NGUG2DDiagramLayoutEventListener listenerLayer = (NGUG2DDiagramLayoutEventListener)listener;
                listenerLayer.handleLayerAdded(event);
            }
        }
    }

    protected synchronized void raiseObjectLayoutAddedEvent(NGUGCustomDiagramObjectLayout aDiagramObjectLayout) {
        NGUGDiagramObjectLayoutEvent event = new NGUGDiagramObjectLayoutEvent(this, aDiagramObjectLayout);
        for (NGUGDiagramLayoutEventListener listener : FEventListeners) {
            listener.handleObjectLayoutAdded(event);
        }
    }

    protected synchronized void raiseLinkLayoutAddedEvent(NGUGCustomDiagramLinkLayout aDiagramLinkLayout) {
        NGUGDiagramLinkLayoutEvent event = new NGUGDiagramLinkLayoutEvent(this, aDiagramLinkLayout);
        for (NGUGDiagramLayoutEventListener listener : FEventListeners) {
            listener.handleLinkLayoutAdded(event);
        }
    }

    public NGUG2DDiagramLayoutManager(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FObjectLayouts = new ArrayList<>();
        FLinkLayouts = new ArrayList<>();
        FEventListeners = new ArrayList<>();
        FDiagramLayers = new ArrayList<>();
    }

    public Iterator<NGUGCustomDiagramObjectLayout> getObjectLayouts() {
        return FObjectLayouts.iterator();
    }

    public Iterator<NGUGCustomDiagramLinkLayout> getLinkLayouts() {
        return FLinkLayouts.iterator();
    }

    public void addEventListener(NGUGDiagramLayoutEventListener aListener)  {
        FEventListeners.add(aListener);
    }

    public void removeEventListener(NGUGDiagramLayoutEventListener aListener)   {
        FEventListeners.remove(aListener);
    }

    public NGUG2DDiagramLayer addLayer(String aName, Integer aZOrder, Double aOpacity) {
        NGUG2DDiagramLayer res = new NGUG2DDiagramLayer(this, aName, aZOrder, aOpacity);
        FDiagramLayers.add(res);
        raiseLayerAddedEvent(res);
        return res;
    }

    public void addObjectLayout(NGUG2DDiagramObjectLayout aDiagramObjectLayout) {
        FObjectLayouts.add(aDiagramObjectLayout);
        raiseObjectLayoutAddedEvent(aDiagramObjectLayout);
    }

    public void addLinkLayout(NGUGCustomDiagramLinkLayout aDiagramLinkLayout) {
        FLinkLayouts.add(aDiagramLinkLayout);
        raiseLinkLayoutAddedEvent(aDiagramLinkLayout);
    }

    public NGUGCustomDiagramObjectLayout getObjectLayout(NGUGCustomDiagramObject aDiagramObject) {
        for (NGUGCustomDiagramObjectLayout layout : FObjectLayouts) {
            if (layout.getDiagramObject().equals(aDiagramObject))
                return layout;
        }
        return null;
    }

    public NGUGCustomDiagramLinkLayout getLinkLayout(NGUGCustomDiagramLink aDiagramLink) {
        for (NGUGCustomDiagramLinkLayout layout : FLinkLayouts) {
            if (layout.getDiagramLink().equals(aDiagramLink))
                return layout;
        }
        return null;
    }

}
