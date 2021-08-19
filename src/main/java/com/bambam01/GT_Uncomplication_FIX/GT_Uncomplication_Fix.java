package com.bambam01.GT_Uncomplication_FIX;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.TransformerExclusions({"com.bambam01.GT_Uncomplication_Fix"})
public class GT_Uncomplication_Fix implements IFMLLoadingPlugin
{
    @Override
    public String[] getASMTransformerClass()
    {
        return new String[]{"com.bambam01.GT_Uncomplication_FIX.GT_Uncomplication_FixClassTransformer"};
    }

    @Override
    public String getModContainerClass()
    {

        return "com.bambam01.GT_Uncomplication_FIX.GT_Uncomplication_FixContainer";
    }

    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass()
    {
        return null;
    }
}
