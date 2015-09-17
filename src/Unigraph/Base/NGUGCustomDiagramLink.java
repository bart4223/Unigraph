package Unigraph.Base;

import Uniwork.Base.NGObject;

public abstract class NGUGCustomDiagramLink extends NGObject {

    protected String FFromID;
    protected String FToID;

    public NGUGCustomDiagramLink(String aFromID, String aToID) {
        super();
        FFromID = aFromID;
        FToID = aToID;
    }

    public String getKind() {
        return "";
    }

    public String getFromID() {
        return FFromID;
    }

    public String getToID() {
        return FToID;
    }

}
