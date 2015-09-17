package Unigraph.Base;

import Unigraph.Base.NGUGCustomDiagramObject;
import Uniwork.Base.NGObject;

public abstract class NGUGCustomDiagramObjectLayout extends NGObject {

    protected NGUGCustomDiagramObject FDiagramObject;

    public NGUGCustomDiagramObjectLayout(NGUGCustomDiagramObject aDiagramObject) {
        super();
        FDiagramObject = aDiagramObject;
    }

    public NGUGCustomDiagramObject getDiagramObject() {
        return FDiagramObject;
    }

}
