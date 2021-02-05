package com.github.amusingimpala75.terrafabriccraftcore.block;

import com.github.amusingimpala75.terrafabriccraftcore.TerraFabricCraftCore;
import com.github.amusingimpala75.terrafabriccraftcore.models.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.model.Model;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class DebugBlockEntity extends BlockEntity {

    private int loop = 9;
    private static final List<Pair<Model, String>> models = new ArrayList<>();

    public DebugBlockEntity() {
        super(Registry.BLOCK_ENTITY_TYPE.get(TerraFabricCraftCore.getId("debug_block_entity")));
    }

    public void interact() {
        if (this.loop < models.size()) {
            this.loop++;
        } else {
            this.loop = 0;
        }
    }

    public Pair<Model, String> getCurrentModel() {
        return models.get(loop);
    }

    public static List<Pair<Model, String>> getModels() {
        return models;
    }

    static {
        models.add(new Pair<>(new BassModel(), "mob/bass"));
        models.add(new Pair<>(new BearModel(), "mob/bear"));
        models.add(new Pair<>(new ChickenModel(), "mob/rooster"));
        models.add(new Pair<>(new CowModel(), "mob/bull"));
        models.add(new Pair<>(new DeerModel(), "mob/deer"));
        //models.add(new HorseModel());
        models.add(new Pair<>(new PheasantModel(), "mob/pheasantm"));
        models.add(new Pair<>(new PigModel(), "mob/pig"));
        //models.add(new Pair<>(new QuiverModel(), "models/armor/leatherquiver_1"));
        models.add(new Pair<>(new SheepModel(), "mob/sheep"));
        //models.add(new Pair<>(new SheepModel2(), "mob/sheep"));
        //models.add(new Pair<>(new SkeletonModel<>(), "mob/bear"));
        //models.add(new SquidModel());
        //models.add(new UngulateModel());
        //models.add(new WolfModel());
    }
}
