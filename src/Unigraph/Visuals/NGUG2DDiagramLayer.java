package Unigraph.Visuals;

import Uniwork.Base.NGObject;

import java.awt.geom.Arc2D;
import java.util.UUID;

public class NGUG2DDiagramLayer extends NGObject {

    protected String FID;
    protected String FName;
    protected Integer FZOrder;
    protected NGUG2DDiagramLayoutManager FLayoutManager;
    protected Double FOpacity;

    public NGUG2DDiagramLayer(NGUG2DDiagramLayoutManager aLayoutManager, String aName, Integer aZOrder) {
        this(aLayoutManager, aName, aZOrder, 1.0);
    }

    public NGUG2DDiagramLayer(NGUG2DDiagramLayoutManager aLayoutManager, String aName, Integer aZOrder, Double aOpacity) {
        super();
        FID = UUID.randomUUID().toString();
        FName = aName;
        FZOrder = aZOrder;
        FLayoutManager = aLayoutManager;
        FOpacity = aOpacity;
    }

    public String getID() {
        return FID;
    }

    public NGUG2DDiagramLayoutManager getLayoutManager() {
        return FLayoutManager;
    }

    public String getName() {
        return FName;
    }

    public Integer getZOrder() {
        return FZOrder;
    }

    public Double getOpacity() {
        return FOpacity;
    }

}
