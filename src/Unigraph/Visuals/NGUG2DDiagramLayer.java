package Unigraph.Visuals;

import Uniwork.Base.NGObject;

import java.util.UUID;

public class NGUG2DDiagramLayer extends NGObject {

    protected String FID;
    protected String FName;
    protected Integer FZOrder;
    protected NGUG2DDiagramLayoutManager FLayoutManager;

    public NGUG2DDiagramLayer(NGUG2DDiagramLayoutManager aLayoutManager, String aName, Integer aZOrder) {
        super();
        FID = UUID.randomUUID().toString();
        FName = aName;
        FZOrder = aZOrder;
        FLayoutManager = aLayoutManager;
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

}
