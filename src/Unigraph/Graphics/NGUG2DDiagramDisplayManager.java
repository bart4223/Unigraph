package Unigraph.Graphics;

import Unigraph.Base.NGUGCustomDiagramLinkLayout;
import Unigraph.Base.NGUGCustomDiagramObjectLayout;
import Uniwork.Visuals.NGDisplayController;
import Uniwork.Visuals.NGDisplayManager;
import javafx.scene.canvas.Canvas;

import java.util.concurrent.CopyOnWriteArrayList;

public class NGUG2DDiagramDisplayManager extends NGDisplayManager {

    protected CopyOnWriteArrayList<NGUGCustomDiagramObjectLayout> FObjectLayouts;
    protected CopyOnWriteArrayList<NGUGCustomDiagramLinkLayout> FLinkLayouts;

    protected void CreateDiagramDisplayController() {
        // Object-DC's
        NGDisplayController dc = new NGUG2DClassObjectDisplayController(FCanvas);
        addController(dc);
        dc = new NGUG2DTableObjectDisplayController(FCanvas);
        addController(dc);
        dc = new NGUG2DBoxObjectDisplayController(FCanvas);
        addController(dc);
        // Link-DC's
        dc = new NGUG2DSimpleLinkDisplayController(FCanvas);
        addController(dc);
        dc = new NGUG2DLabeledLinkDisplayController(FCanvas);
        addController(dc);
    }

    protected NGDisplayController getDiagramDisplayController(NGUGCustomDiagramObjectLayout aDiagramObjectLayout) {
        for (NGDisplayController dc : FControllers) {
            if (dc instanceof NGUGDiagramDisplayController) {
                NGUGDiagramDisplayController ddc = (NGUGDiagramDisplayController)dc;
                if (ddc.SupportLayoutClass(aDiagramObjectLayout.getClass()))
                    return dc;
            }
        }
        return null;
    }

    protected NGDisplayController getDiagramDisplayController(NGUGCustomDiagramLinkLayout aDiagramLinkLayout) {
        for (NGDisplayController dc : FControllers) {
            if (dc instanceof NGUGDiagramDisplayController) {
                NGUGDiagramDisplayController ddc = (NGUGDiagramDisplayController)dc;
                if (ddc.SupportLayoutClass(aDiagramLinkLayout.getClass()))
                    return dc;
            }
        }
        return null;
    }

    @Override
    protected void InternalRender() {
        FGC.clearRect(FPosition.getXAsInt() * FPixelSize, FPosition.getYAsInt() * FPixelSize, FWidth, FHeight);
        // Links
        for (NGUGCustomDiagramLinkLayout layout : FLinkLayouts) {
            NGDisplayController dc = getDiagramDisplayController(layout);
            dc.setProperty(dc, "DiagramLinkLayout", layout);
            setCurrentController(dc);
            super.InternalRender();
        }
        // Objects
        for (NGUGCustomDiagramObjectLayout layout : FObjectLayouts) {
            NGDisplayController dc = getDiagramDisplayController(layout);
            dc.setProperty(dc, "DiagramObjectLayout", layout);
            setCurrentController(dc);
            super.InternalRender();
        }
    }

    public NGUG2DDiagramDisplayManager(Canvas aCanvas) {
        this(aCanvas, "");
    }

    public NGUG2DDiagramDisplayManager(Canvas aCanvas, String aName) {
        super(aCanvas, aName);
        CreateDiagramDisplayController();
        FObjectLayouts = new CopyOnWriteArrayList<>();
        FLinkLayouts = new CopyOnWriteArrayList<>();
    }

    public void addObjectLayout(NGUGCustomDiagramObjectLayout aObjectLayout) {
        FObjectLayouts.add(aObjectLayout);
    }

    public void removeObjectLayout(NGUGCustomDiagramObjectLayout aObjectLayout) {
        FObjectLayouts.remove(aObjectLayout);
    }

    public void addLinkLayout(NGUGCustomDiagramLinkLayout aLinkLayout) {
        FLinkLayouts.add(aLinkLayout);
    }

    public void removeLinkLayout(NGUGCustomDiagramLinkLayout aLinkLayout) {
        FLinkLayouts.remove(aLinkLayout);
    }

}
