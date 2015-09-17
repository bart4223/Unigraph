package Unigraph.Objects;

import Unigraph.Base.NGUGCustomDiagramLink;

public class NGUGSimpleDiagramLink extends NGUGCustomDiagramLink {

    public NGUGSimpleDiagramLink(String aFromID, String aToID) {
        super(aFromID, aToID);
    }

    public final String getKind() {
        return "Simple";
    }

}
