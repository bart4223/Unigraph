package Unigraph.Objects;

import Unigraph.Base.NGUGCustomDiagramObject;

public class NGUGLabeledDiagramLink extends NGUGSimpleDiagramLink {

    protected String FName;

    public NGUGLabeledDiagramLink(NGUGCustomDiagramObject aFromObject, NGUGCustomDiagramObject aToObject, String aName) {
        super(aFromObject, aToObject);
        FName = aName;
    }

    public String getName() {
        return FName;
    }

}
