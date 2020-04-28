package com.crazyores.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.crazyores.init.CoreItems;
import com.crazyores.item.CopperBucket;
import com.crazyores.item.CopperMilkBucket;

import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;

public class CopperBucketWrapper implements IFluidHandlerItem, ICapabilityProvider {

	private final LazyOptional<IFluidHandlerItem> holder = LazyOptional.of(() -> this);

    @Nonnull
    protected ItemStack container;

    public CopperBucketWrapper(@Nonnull ItemStack container)
    {
        this.container = container;
    }
	
	@Override
    public ItemStack getContainer()
    {
        return container;
    }

	public boolean canFillFluidType(FluidStack fluid)
    {
        if (fluid.getFluid() == Fluids.WATER || fluid.getFluid() == Fluids.LAVA || fluid.getFluid().getRegistryName().equals(new ResourceLocation("milk")))
        {
            return true;
        }
        return fluid.getFluid().getAttributes().getBucket(fluid) != null;
    }

    @Nonnull
    public FluidStack getFluid()
    {
        Item item = container.getItem();
        if (item instanceof CopperBucket)
        {
            return new FluidStack(((BucketItem)item).getFluid(), FluidAttributes.BUCKET_VOLUME);
        }
        else
        {
            return FluidStack.EMPTY;
        }
    }

    protected void setFluid(@Nonnull FluidStack fluidStack)
    {
        if (fluidStack.isEmpty())
            container = new ItemStack(CoreItems.COPPER_BUCKET_EMPTY.get());
        else
            container = FluidUtil.getFilledBucket(fluidStack);
    }

    @Override
    public int getTanks() {

        return 1;
    }

    @Nonnull
    @Override
    public FluidStack getFluidInTank(int tank) {

        return getFluid();
    }

    @Override
    public int getTankCapacity(int tank) {

        return FluidAttributes.BUCKET_VOLUME;
    }

    @Override
    public boolean isFluidValid(int tank, @Nonnull FluidStack stack) {

        return true;
    }

    @Override
    public int fill(FluidStack resource, FluidAction action)
    {
        if (container.getCount() != 1 || resource.getAmount() < FluidAttributes.BUCKET_VOLUME || container.getItem() instanceof CopperMilkBucket || !getFluid().isEmpty() || !canFillFluidType(resource))
        {
            return 0;
        }

        if (action.execute())
        {
            setFluid(resource);
        }

        return FluidAttributes.BUCKET_VOLUME;
    }

    @Nonnull
    @Override
    public FluidStack drain(FluidStack resource, FluidAction action)
    {
        if (container.getCount() != 1 || resource.getAmount() < FluidAttributes.BUCKET_VOLUME)
        {
            return FluidStack.EMPTY;
        }

        FluidStack fluidStack = getFluid();
        if (!fluidStack.isEmpty() && fluidStack.isFluidEqual(resource))
        {
            if (action.execute())
            {
                setFluid(FluidStack.EMPTY);
            }
            return fluidStack;
        }

        return FluidStack.EMPTY;
    }

    @Nonnull
    @Override
    public FluidStack drain(int maxDrain, FluidAction action)
    {
        if (container.getCount() != 1 || maxDrain < FluidAttributes.BUCKET_VOLUME)
        {
            return FluidStack.EMPTY;
        }

        FluidStack fluidStack = getFluid();
        if (!fluidStack.isEmpty())
        {
            if (action.execute())
            {
                setFluid(FluidStack.EMPTY);
            }
            return fluidStack;
        }

        return FluidStack.EMPTY;
    }
    
    @Override
    @Nonnull
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction facing)
    {
        return CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY.orEmpty(capability, holder);
    }

}
