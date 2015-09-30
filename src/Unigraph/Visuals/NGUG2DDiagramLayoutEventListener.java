package Unigraph.Visuals;

import Unigraph.Base.NGUGDiagramLayoutEventListener;

import java.util.EventObject;

public interface NGUG2DDiagramLayoutEventListener extends NGUGDiagramLayoutEventListener {

    void handleRefresh(EventObject e);
    void handleLayerRefresh(NGUG2DDiagramLayerEvent e);
    void handleLayerAdded(NGUG2DDiagramLayerEvent e);

}
