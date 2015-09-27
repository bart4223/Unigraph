package Unigraph.Visuals;

import Unigraph.Base.NGUGCustomDiagramLink;
import Unigraph.Base.NGUGCustomDiagramLinkLayout;
import javafx.scene.paint.Color;

public class NGUG2DDiagramLinkLayout extends NGUGCustomDiagramLinkLayout {

    protected Color FLineColor;
    protected NGUG2DDiagramLayoutManager FLayoutManager;

    public NGUG2DDiagramLinkLayout(NGUG2DDiagramLayoutManager aLayoutManager, NGUGCustomDiagramLink aDiagramLink) {
        super(aDiagramLink);
        FLayoutManager = aLayoutManager;
        FLineColor = Color.BLACK;
    }

    public NGUG2DDiagramLayoutManager getLayoutManager() {
        return FLayoutManager;
    }

    public void setLineColor(Color aLineColor) {
        FLineColor = aLineColor;
    }

    public Color getLineColor() {
        return FLineColor;
    }

}
