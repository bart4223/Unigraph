package Unigraph.Visuals;

import Unigraph.Base.NGUGCustomDiagramLinkLayout;
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


}
