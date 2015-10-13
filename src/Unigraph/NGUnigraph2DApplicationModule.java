package Unigraph;

import Unigraph.Base.NGUGCustomDiagramObject;
import Unigraph.Base.NGUGDiagramEventListener;
import Unigraph.Base.NGUGDiagramObjectManager;
import Unigraph.Objects.*;
import Unigraph.Visuals.*;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGVisualApplicationModule;
import Uniwork.Base.NGComponent;
import Uniwork.Misc.NGLogManager;
import Uniwork.Misc.NGStrings;

public class NGUnigraph2DApplicationModule extends NGVisualApplicationModule implements NGUnigraph2DAPI {

    protected NGUGDiagramObjectManager FObjectManager;
    protected NGUG2DDiagramLayoutManager FLayoutManager;

    @Override
    protected void DoBeforeInitialize() {
        super.DoBeforeInitialize();
        NGCustomStageItem item = FStageManager.addStageItem("Diagram");
        item.setCaption(NGStrings.addString(getDescription(), "Diagram", "."));
        item.setPosition(600, 200);
        FObjectManager.addEventListener((NGUGDiagramEventListener)item);
        FLayoutManager.addEventListener((NGUG2DDiagramLayoutEventListener)item);
    }

    public NGUnigraph2DApplicationModule(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FObjectManager = new NGUGDiagramObjectManager(this, NGUnigraphConsts.C_COMPONENT_DOM);
        FLayoutManager = new NGUG2DDiagramLayoutManager(this, NGUnigraphConsts.C_COMPONENT_DOLM);
        FStageManager.registerItemClass("Diagram", "Unigraph.UI.NGUG2DDiagramStageItem");
    }

    @Override
    public void setLogManager(NGLogManager aLogManager) {
        super.setLogManager(aLogManager);
        FObjectManager.setLogManager(aLogManager);
        FLayoutManager.setLogManager(aLogManager);
    }

    @Override
    public void Refresh() {
        FLayoutManager.Refresh();
    }

    @Override
    public void Refresh(NGUG2DDiagramLayer aDiagramLayer) {
        FLayoutManager.Refresh(aDiagramLayer);
    }

    @Override
    public NGUG2DDiagramLayer addLayer(String aName, Integer aZOrder, Double aOpacity) {
        return FLayoutManager.addLayer(aName, aZOrder, aOpacity);
    }

    @Override
    public NGUGCustomDiagramObject getObjectByRef(Object aRefObject) {
        return FObjectManager.getDiagramObjectByRef(aRefObject);
    }

    @Override
    public NGUGBoxDiagramObject addBox(String aName) {
        return addBox(aName, null);
    }

    @Override
    public NGUGBoxDiagramObject addBox(String aName, Object aReference) {
        NGUGBoxDiagramObject res = new NGUGBoxDiagramObject(aName, aReference);
        FObjectManager.addDiagramObject(res);
        return res;
    }

    @Override
    public NGUG2DBoxDiagramObjectLayout addBoxLayout(NGUGBoxDiagramObject aBoxObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight) {
        NGUG2DBoxDiagramObjectLayout res = new NGUG2DBoxDiagramObjectLayout(aBoxObject, aDiagramLayer, aWidth, aHeight);
        FLayoutManager.addObjectLayout(res);
        return res;
    }

    @Override
    public NGUGClassDiagramObject addClass(String aName) {
        return addClass(aName, null);
    }

    @Override
    public NGUGClassDiagramObject addClass(String aName, Object aReference) {
        NGUGClassDiagramObject res = new NGUGClassDiagramObject(aName, aReference);
        FObjectManager.addDiagramObject(res);
        return res;
    }

    @Override
    public NGUG2DClassDiagramObjectLayout addClassLayout(NGUGClassDiagramObject aClassObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight) {
        NGUG2DClassDiagramObjectLayout res = new NGUG2DClassDiagramObjectLayout(aClassObject, aDiagramLayer, aWidth, aHeight);
        FLayoutManager.addObjectLayout(res);
        return res;
    }

    @Override
    public NGUGTableDiagramObject addTable(String aName) {
        return addTable(aName, null);
    }

    @Override
    public NGUGTableDiagramObject addTable(String aName, Object aReference) {
        NGUGTableDiagramObject res = new NGUGTableDiagramObject(aName, aReference);
        FObjectManager.addDiagramObject(res);
        return res;
    }

    @Override
    public NGUG2DTableDiagramObjectLayout addTableLayout(NGUGTableDiagramObject aTableObject, NGUG2DDiagramLayer aDiagramLayer, Integer aWidth, Integer aHeight) {
        NGUG2DTableDiagramObjectLayout res = new NGUG2DTableDiagramObjectLayout(aTableObject, aDiagramLayer, aWidth, aHeight);
        FLayoutManager.addObjectLayout(res);
        return res;
    }

    @Override
    public NGUGSimpleDiagramLink addSimpleLink(NGUGCustomDiagramObject aFromObject, NGUGCustomDiagramObject aToObject) {
        NGUGSimpleDiagramLink res = new NGUGSimpleDiagramLink(aFromObject, aToObject);
        FObjectManager.addDiagramLink(res);
        return res;
    }

    @Override
    public NGUG2DSimpleDiagramLinkLayout addSimpleLinkLayout(NGUGSimpleDiagramLink aDiagramLink) {
        NGUG2DSimpleDiagramLinkLayout res = new NGUG2DSimpleDiagramLinkLayout(FLayoutManager, aDiagramLink);
        FLayoutManager.addLinkLayout(res);
        return res;
    }

    @Override
    public NGUGLabeledDiagramLink addLabeledLink(NGUGCustomDiagramObject aFromObject, NGUGCustomDiagramObject aToObject, String aName) {
        NGUGLabeledDiagramLink res = new NGUGLabeledDiagramLink(aFromObject, aToObject, aName);
        FObjectManager.addDiagramLink(res);
        return res;
    }

    @Override
    public NGUG2DLabeledDiagramLinkLayout addLabeledLinkLayout(NGUGLabeledDiagramLink aDiagramLink, Integer aWidth, Integer aHeight) {
        NGUG2DLabeledDiagramLinkLayout res = new NGUG2DLabeledDiagramLinkLayout(FLayoutManager, aDiagramLink, aWidth, aHeight);
        FLayoutManager.addLinkLayout(res);
        return res;
    }

}
