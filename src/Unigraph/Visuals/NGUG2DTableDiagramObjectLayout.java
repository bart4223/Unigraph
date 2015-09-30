package Unigraph.Visuals;

import Unigraph.Base.NGUGCustomDiagramObject;
import Unigraph.Objects.NGUGTableDiagramObject;

public class NGUG2DTableDiagramObjectLayout extends NGUG2DDiagramObjectLayout {

    public NGUG2DTableDiagramObjectLayout(NGUGCustomDiagramObject aDiagramObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight) {
        super(aDiagramObject, aDiagramLayer, aWidth, aHeight);
    }

    public NGUGTableDiagramObject getTableDiagramObject() {
        return (NGUGTableDiagramObject)FDiagramObject;
    }

}
