package Unigraph.Visuals;

import Unigraph.Base.NGUGCustomDiagramLink;
import Unigraph.Base.NGUGCustomDiagramLinkLayout;
import Unigraph.Base.NGUGCustomDiagramObject;
import Unigraph.Base.NGUGCustomDiagramObjectLayout;
import Uniwork.Base.NGComponent;

import java.util.ArrayList;
import java.util.Iterator;

public class NGUG2DDiagramObjectLayoutManager extends NGComponent {

    protected ArrayList<NGUGCustomDiagramObjectLayout> FObjectLayouts;
    protected ArrayList<NGUGCustomDiagramLinkLayout> FLinkLayouts;

    public NGUG2DDiagramObjectLayoutManager(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FObjectLayouts = new ArrayList<>();
        FLinkLayouts = new ArrayList<>();
    }

    public Iterator<NGUGCustomDiagramObjectLayout> getObjectLayouts() {
        return FObjectLayouts.iterator();
    }

    public Iterator<NGUGCustomDiagramLinkLayout> getLinkLayouts() {
        return FLinkLayouts.iterator();
    }

    public void addObjectLayout(NGUGCustomDiagramObjectLayout aDiagramObjectLayout) {
        FObjectLayouts.add(aDiagramObjectLayout);
    }

    public void addLinkLayout(NGUGCustomDiagramLinkLayout aDiagramLinkLayout) {
        FLinkLayouts.add(aDiagramLinkLayout);
    }

    public NGUGCustomDiagramObjectLayout getObjectLayout(NGUGCustomDiagramObject aDiagramObject) {
        for (NGUGCustomDiagramObjectLayout layout : FObjectLayouts) {
            if (layout.getDiagramObject().equals(aDiagramObject))
                return  layout;
        }
        return null;
    }

    public NGUGCustomDiagramLinkLayout getLinkLayout(NGUGCustomDiagramLink aDiagramLink) {
        for (NGUGCustomDiagramLinkLayout layout : FLinkLayouts) {
            if (layout.getDiagramLink().equals(aDiagramLink))
                return  layout;
        }
        return null;
    }

}
