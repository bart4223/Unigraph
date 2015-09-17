package Unigraph.Base;

import Unigraph.Base.NGUGCustomDiagramLink;
import Uniwork.Base.NGObject;

public abstract class NGUGCustomDiagramLinkLayout extends NGObject {

    public NGUGCustomDiagramLink FDiagramLink;

    public NGUGCustomDiagramLinkLayout(NGUGCustomDiagramLink aDiagramLink) {
        super();
        FDiagramLink = aDiagramLink;
    }

    public NGUGCustomDiagramLink getDiagramLink() {
        return FDiagramLink;
    }

}
