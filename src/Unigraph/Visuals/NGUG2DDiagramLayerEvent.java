package Unigraph.Visuals;

import java.util.EventObject;

public class NGUG2DDiagramLayerEvent extends EventObject {

    protected NGUG2DDiagramLayer FDiagramLayer;

    public NGUG2DDiagramLayerEvent(Object source, NGUG2DDiagramLayer aDiagramLayer) {
        super(source);
        FDiagramLayer = aDiagramLayer;
    }

    public NGUG2DDiagramLayer getDigramLayer() {
        return FDiagramLayer;
    }

}
