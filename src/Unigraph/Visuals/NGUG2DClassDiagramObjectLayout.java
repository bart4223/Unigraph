package Unigraph.Visuals;

import Unigraph.Base.NGUGCustomDiagramObject;
import Unigraph.Objects.NGUGClassDiagramObject;

public class NGUG2DClassDiagramObjectLayout extends NGUG2DDiagramObjectLayout {

    public NGUG2DClassDiagramObjectLayout(NGUGCustomDiagramObject aDiagramObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight) {
        super(aDiagramObject, aDiagramLayer, aWidth, aHeight);
    }

    public NGUGClassDiagramObject getClassDiagramObject() {
        return (NGUGClassDiagramObject)FDiagramObject;
    }

}
