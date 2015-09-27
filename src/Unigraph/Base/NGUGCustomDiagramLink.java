package Unigraph.Base;

import Uniwork.Base.NGObject;

public abstract class NGUGCustomDiagramLink extends NGObject {

    protected NGUGCustomDiagramObject FFromObject;
    protected NGUGCustomDiagramObject FToObject;

    public NGUGCustomDiagramLink(NGUGCustomDiagramObject aFromObject, NGUGCustomDiagramObject aToObject) {
        super();
        FFromObject = aFromObject;
        FToObject = aToObject;
    }

    public String getKind() {
        return "";
    }

    public NGUGCustomDiagramObject getFromObject() {
        return FFromObject;
    }

    public NGUGCustomDiagramObject getToObject() {
        return FToObject;
    }

}
