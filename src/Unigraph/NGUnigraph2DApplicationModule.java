package Unigraph;

import Unigraph.Base.NGUGCustomDiagramObject;
import Unigraph.Base.NGUGDiagramEventListener;
import Unigraph.Base.NGUGDiagramObjectManager;
import Unigraph.Objects.NGUGClassDiagramObject;
import Unigraph.Objects.NGUGSimpleDiagramLink;
import Unigraph.Objects.NGUGTableDiagramObject;
import Unigraph.Visuals.*;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGVisualApplicationModule;
import Uniwork.Base.NGComponent;
import Uniwork.Misc.NGLogManager;

public class NGUnigraph2DApplicationModule extends NGVisualApplicationModule implements NGUnigraph2DAPI {

    protected NGUGDiagramObjectManager FObjectManager;
    protected NGUG2DDiagramLayoutManager FLayoutManager;

    @Override
    protected void DoBeforeInitialize() {
        super.DoBeforeInitialize();
        NGCustomStageItem item = FStageManager.addStageItem("Diagram");
        item.setCaption(String.format("%s.Diagram", getDescription()));
        item.setPosition(100, 100);
        FObjectManager.addEventListener((NGUGDiagramEventListener)item);
        FLayoutManager.addEventListener((NGUG2DDiagramLayoutEventListener)item);
    }

    public NGUnigraph2DApplicationModule(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FObjectManager = new NGUGDiagramObjectManager(this, NGUnigraphConsts.C_COMPONENT_DOM);
        FLayoutManager = new NGUG2DDiagramLayoutManager(this, NGUnigraphConsts.C_COMPONENT_DOLM);
        FStageManager.registerItemClass("Diagram", "Unigraph.NGUG2DDiagramStageItem");
    }

    @Override
    public void setLogManager(NGLogManager aLogManager) {
        super.setLogManager(aLogManager);
        FObjectManager.setLogManager(aLogManager);
    }

    @Override
    public NGUG2DDiagramLayer addLayer(String aName, Integer aZOrder) {
        return FLayoutManager.addLayer(aName, aZOrder);
    }

    @Override
    public NGUGClassDiagramObject addClass(String aName, Object aReference) {
        NGUGClassDiagramObject res = new NGUGClassDiagramObject(aName, aReference);
        FObjectManager.addObject(res);
        return res;
    }

    @Override
    public NGUG2DClassDiagramObjectLayout addClassLayout(NGUGClassDiagramObject aDiagramObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight) {
        NGUG2DClassDiagramObjectLayout res = new NGUG2DClassDiagramObjectLayout(aDiagramObject, aDiagramLayer, aWidth, aHeight);
        FLayoutManager.addObjectLayout(res);
        return res;
    }

    @Override
    public NGUGTableDiagramObject addTable(String aName, Object aReference) {
        NGUGTableDiagramObject res = new NGUGTableDiagramObject(aName, aReference);
        FObjectManager.addObject(res);
        return res;
    }

    @Override
    public NGUG2DTableDiagramObjectLayout addTableLayout(NGUGClassDiagramObject aDiagramObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight) {
        NGUG2DTableDiagramObjectLayout res = new NGUG2DTableDiagramObjectLayout(aDiagramObject, aDiagramLayer, aWidth, aHeight);
        FLayoutManager.addObjectLayout(res);
        return res;
    }

    @Override
    public NGUGSimpleDiagramLink addSimpleLink(NGUGCustomDiagramObject aFromObject, NGUGCustomDiagramObject aToObject) {
        NGUGSimpleDiagramLink res = new NGUGSimpleDiagramLink(aFromObject, aToObject);
        FObjectManager.addLink(res);
        return res;
    }

    @Override
    public NGUG2DSimpleDiagramLinkLayout addSimpleLinkLayout(NGUGSimpleDiagramLink aDiagramLink) {
        NGUG2DSimpleDiagramLinkLayout res = new NGUG2DSimpleDiagramLinkLayout(FLayoutManager, aDiagramLink);
        FLayoutManager.addLinkLayout(res);
        return res;
    }

}
