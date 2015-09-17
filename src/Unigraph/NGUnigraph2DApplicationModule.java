package Unigraph;

import Unigraph.Base.NGUGDiagramObjectManager;
import Unigraph.Objects.NGUGClassDiagramObject;
import Unigraph.Objects.NGUGSimpleDiagramLink;
import Unigraph.Objects.NGUGTableDiagramObject;
import Unigraph.Visuals.NGUG2DClassDiagramObjectLayout;
import Unigraph.Visuals.NGUG2DDiagramObjectLayoutManager;
import Unigraph.Visuals.NGUG2DSimpleDiagramLinkLayout;
import Unigraph.Visuals.NGUG2DTableDiagramObjectLayout;
import Uniwork.Appl.NGVisualApplicationModule;
import Uniwork.Base.NGComponent;
import Uniwork.Misc.NGLogManager;

public class NGUnigraph2DApplicationModule extends NGVisualApplicationModule implements NGUnigraphAPI {

    protected NGUGDiagramObjectManager FObjectManager;
    protected NGUG2DDiagramObjectLayoutManager FObjectLayoutManager;

    public NGUnigraph2DApplicationModule(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FObjectManager = new NGUGDiagramObjectManager(this, NGUnigraphConsts.C_COMPONENT_DOM);
        FObjectLayoutManager = new NGUG2DDiagramObjectLayoutManager(this, NGUnigraphConsts.C_COMPONENT_DOLM);
    }

    @Override
    public void setLogManager(NGLogManager aLogManager) {
        super.setLogManager(aLogManager);
        FObjectManager.setLogManager(aLogManager);
    }

    @Override
    public NGUGClassDiagramObject addClass(String aName, Object aReference) {
        NGUGClassDiagramObject res = new NGUGClassDiagramObject(aName, aReference);
        FObjectManager.addObject(res);
        return res;
    }

    @Override
    public NGUG2DClassDiagramObjectLayout addClassLayout(NGUGClassDiagramObject aDiagramObject, Integer aWidth, Integer aHeight) {
        NGUG2DClassDiagramObjectLayout res = new NGUG2DClassDiagramObjectLayout(aDiagramObject, aWidth, aHeight);
        FObjectLayoutManager.addObjectLayout(res);
        return res;
    }

    @Override
    public NGUGTableDiagramObject addTable(String aName, Object aReference) {
        NGUGTableDiagramObject res = new NGUGTableDiagramObject(aName, aReference);
        FObjectManager.addObject(res);
        return res;
    }

    @Override
    public NGUG2DTableDiagramObjectLayout addTableLayout(NGUGClassDiagramObject aDiagramObject, Integer aWidth, Integer aHeight) {
        NGUG2DTableDiagramObjectLayout res = new NGUG2DTableDiagramObjectLayout(aDiagramObject, aWidth, aHeight);
        FObjectLayoutManager.addObjectLayout(res);
        return res;
    }

    @Override
    public NGUGSimpleDiagramLink addSimpleLink(String aFromID, String aToID) {
        NGUGSimpleDiagramLink res = new NGUGSimpleDiagramLink(aFromID, aToID);
        FObjectManager.addLink(res);
        return res;
    }

    @Override
    public NGUG2DSimpleDiagramLinkLayout addSimpleLinkLayout(NGUGSimpleDiagramLink aDiagramLink) {
        NGUG2DSimpleDiagramLinkLayout res = new NGUG2DSimpleDiagramLinkLayout(aDiagramLink);
        FObjectLayoutManager.addLinkLayout(res);
        return res;
    }

}
