package com.crazyores.init.registration;

import java.util.function.Function;
import java.util.function.Supplier;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class CoreDeferredRegister<T extends IForgeRegistryEntry<T>> {
	
	protected final DeferredRegister<T> reg;
	
	public CoreDeferredRegister(String modid, IForgeRegistry<T> registry) {
		reg = new DeferredRegister<>(registry, modid);
	}
	
	public <I extends T, W extends CoreRegistryObject<I>> W register(String name, Supplier<? extends I> supplier, Function<RegistryObject<I>, W> objectWrapper) {
		return objectWrapper.apply(reg.register(name, supplier));
	}
	
	public void register(IEventBus bus) {
		reg.register(bus);
	}

}
