package Unigraph.Objects;

import Unigraph.Base.NGUGCustomDiagramLink;
import Unigraph.Base.NGUGCustomDiagramObject;

public class NGUGSimpleDiagramLink extends NGUGCustomDiagramLink {

    public NGUGSimpleDiagramLink(NGUGCustomDiagramObject aFromObject, NGUGCustomDiagramObject aToObject) {
        super(aFromObject, aToObject);
    }

    public final String getKind() {
        return "Simple";
    }

}
