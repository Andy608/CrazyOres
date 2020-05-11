package com.crazyores.init.registration;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class DoubleDeferredRegister<FIRST extends IForgeRegistryEntry<FIRST>, SEC extends IForgeRegistryEntry<SEC>> {

    private final DeferredRegister<FIRST> firstRegister;
    private final DeferredRegister<SEC> secondRegister;

    public DoubleDeferredRegister(String modid, IForgeRegistry<FIRST> firstRegistry,
              IForgeRegistry<SEC> secondRegistry) {
        firstRegister = new DeferredRegister<>(firstRegistry, modid);
        secondRegister = new DeferredRegister<>(secondRegistry, modid);
    }

    public <F extends FIRST, S extends SEC, W extends DoubleRegistryObject<F, S>> W register(String name,
            Supplier<? extends F> firstSup, Supplier<? extends S> secSup,
            BiFunction<RegistryObject<F>, RegistryObject<S>, W> objectWrapper) {
        return objectWrapper.apply(firstRegister.register(name, firstSup), secondRegister.register(name, secSup));
    }

    public <F extends FIRST, S extends SEC, W extends DoubleRegistryObject<F, S>> W register(String name,
             Supplier<? extends F> firstSup, Function<F, S> secSup,
             BiFunction<RegistryObject<F>, RegistryObject<S>, W> objectWrapper) {
        RegistryObject<F> firstObj = firstRegister.register(name, firstSup);
        return objectWrapper.apply(firstObj, secondRegister.register(name, () -> secSup.apply(firstObj.get())));
    }

    public void register(IEventBus bus) {
        firstRegister.register(bus);
        secondRegister.register(bus);
    }
}
