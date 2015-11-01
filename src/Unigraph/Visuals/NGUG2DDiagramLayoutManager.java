package Unigraph.Visuals;

import Unigraph.Base.*;
import Uniwork.Base.NGComponent;
import Uniwork.Graphics.NGPoint2D;

import java.util.ArrayList;
import java.util.EventObject;
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

    protected synchronized void raiseLayerRefreshEvent(NGUG2DDiagramLayer aDiagramLayer) {
        NGUG2DDiagramLayerEvent event = new NGUG2DDiagramLayerEvent(this, aDiagramLayer);
        for (NGUGDiagramLayoutEventListener listener : FEventListeners) {
            if (listener instanceof NGUG2DDiagramLayoutEventListener) {
                NGUG2DDiagramLayoutEventListener listenerLayer = (NGUG2DDiagramLayoutEventListener)listener;
                listenerLayer.handleLayerRefresh(event);
            }
        }
    }

    protected synchronized void raiseRefreshEvent() {
        for (NGUGDiagramLayoutEventListener listener : FEventListeners) {
            if (listener instanceof NGUG2DDiagramLayoutEventListener) {
                NGUG2DDiagramLayoutEventListener listenerLayer = (NGUG2DDiagramLayoutEventListener)listener;
                listenerLayer.handleRefresh(new EventObject(this));
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

    public void Refresh() {
        raiseRefreshEvent();
    }

    public void Refresh(NGUG2DDiagramLayer aDiagramLayer) {
        raiseLayerRefreshEvent(aDiagramLayer);
    }

    public NGUGCustomDiagramObject getDiagramObject(NGPoint2D aPosition) {
        NGUG2DDiagramObjectLayout res = null;
        for (NGUGCustomDiagramObjectLayout layout : FObjectLayouts) {
            if (layout instanceof NGUG2DDiagramObjectLayout) {
                NGUG2DDiagramObjectLayout layout1 = (NGUG2DDiagramObjectLayout)layout;
                if (layout1.Hit(aPosition) && ((res == null) || layout1.getDiagramLayerZOrder() > res.getDiagramLayerZOrder())) {
                    res = layout1;
                }
            }
        }
        if (res != null)
            return res.getDiagramObject();
        else
            return null;
    }

}
