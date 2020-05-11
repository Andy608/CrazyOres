package com.crazyores.init.registration;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class DoubleRegistryObject<FIRST extends IForgeRegistryEntry<? super FIRST>,
        SEC extends IForgeRegistryEntry<? super SEC>> {

    private final RegistryObject<FIRST> firstRegistryObject;
    private final RegistryObject<SEC> secRegistryObject;

    public DoubleRegistryObject(RegistryObject<FIRST> firstRegistryObject, RegistryObject<SEC> secRegistryObject) {
        this.firstRegistryObject = firstRegistryObject;
        this.secRegistryObject = secRegistryObject;
    }

    @Nonnull
    public FIRST getFirst() {
        return firstRegistryObject.get();
    }

    @Nonnull
    public SEC getSecond() {
        return  secRegistryObject.get();
    }
}
