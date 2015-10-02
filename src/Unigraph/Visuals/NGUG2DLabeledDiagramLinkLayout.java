package Unigraph.Visuals;

import Unigraph.Base.NGUGCustomDiagramLink;
import Unigraph.Objects.NGUGLabeledDiagramLink;
import Unigraph.Objects.NGUGSimpleDiagramLink;
import javafx.scene.paint.Color;

public class NGUG2DLabeledDiagramLinkLayout extends NGUG2DDiagramLinkLayout {

    protected Integer FWidth;
    protected Integer FHeigth;
    protected Color FLinkColor;

    public NGUG2DLabeledDiagramLinkLayout(NGUG2DDiagramLayoutManager aLayoutManager, NGUGCustomDiagramLink aDiagramLink, Integer aWidth, Integer aHeight) {
        super(aLayoutManager, aDiagramLink);
        FWidth = aWidth;
        FHeigth = aHeight;
        FLinkColor = Color.WHITE;
    }

    public NGUGLabeledDiagramLink getLabeledDiagramLink() {
        return (NGUGLabeledDiagramLink)FDiagramLink;
    }

    public Integer getWidth() {
        return FWidth;
    }

    public Integer getHeight() {
        return FHeigth;
    }

    public Color getLinkColor() {
        return FLinkColor;
    }

    public void setLinkColor(Color aLinkColor) {
        FLinkColor = aLinkColor;
    }

}
