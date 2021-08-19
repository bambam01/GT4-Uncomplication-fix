package com.bambam01.GT_Uncomplication_FIX;

import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

import java.util.Collections;

public class GT_Uncomplication_FixContainer extends DummyModContainer {

    public GT_Uncomplication_FixContainer(){
        super(new ModMetadata());
        ModMetadata meta = getMetadata();
        meta.modId = "GT_Uncomplication_Fix";
        meta.name = "GT Uncomplication Fix";
        meta.description = "Fix an incompatibility between Gregteg4 and Uncomplication";
        meta.version = "1.7.10-1.0";
        meta.authorList = Collections.singletonList("bambam01");
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller)
    {
        bus.register(this);
        return true;
    }
}
