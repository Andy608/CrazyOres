package com.crazyores.init.registration;

import java.util.function.Supplier;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class CoreRegistryObject<T extends IForgeRegistryEntry<? super T>> implements Supplier<T> {

    protected RegistryObject<T> registryObject;

    public CoreRegistryObject(RegistryObject<T> registryObject) {
        this.registryObject = registryObject;
    }

    @Override
    public T get() {
        return registryObject.get();
    }

    public String getInternalRegistryName() {
        return registryObject.getId().getPath();
    }
}