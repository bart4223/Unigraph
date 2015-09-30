package Unigraph.Visuals;

import Unigraph.Base.NGUGCustomDiagramObject;
import Unigraph.Objects.NGUGBoxDiagramObject;

public class NGUG2DBoxDiagramObjectLayout extends NGUG2DDiagramObjectLayout {

    public NGUG2DBoxDiagramObjectLayout(NGUGCustomDiagramObject aDiagramObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight) {
        super(aDiagramObject, aDiagramLayer, aWidth, aHeight);
    }

    public NGUGBoxDiagramObject getBoxDiagramObject() {
        return (NGUGBoxDiagramObject)FDiagramObject;
    }

}
