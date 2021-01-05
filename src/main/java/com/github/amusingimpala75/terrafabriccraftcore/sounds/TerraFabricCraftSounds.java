package com.github.amusingimpala75.terrafabriccraftcore.sounds;

import com.github.amusingimpala75.terrafabriccraftcore.TerraFabricCraftCore;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class TerraFabricCraftSounds {

    public static final SoundEvent CERAMIC_BREAK = registerSound("item.ceramic_break");
    public static final SoundEvent FIRE_STARTER = registerSound("item.fire_starter");
    public static final SoundEvent JUG_BLOW = registerSound("item.jug.blow");
    public static final SoundEvent ROOSTER_CRY = registerSound("mob.rooster.cry");
    public static final SoundEvent STONE_DRAG = registerSound("quern.stone_drag");
    public static final SoundEvent BELLOWS_BLOW = registerSound("bellows.blow.air");
    public static final SoundEvent DIRT_SLIDE = registerSound("dirt.slide.short");
    public static final SoundEvent ROCK_SLIDE_LONG = registerSound("rock.slide.long");
    public static final SoundEvent ROCK_SLIDE_SHORT = registerSound("rock.slide.short");
    public static final SoundEvent ANVIL_METAL_IMPACT = registerSound("anvil.metal_impact");
    public static final SoundEvent DEER_SAY = registerSound("mob.deer.say");
    public static final SoundEvent DEER_CRY = registerSound("mob.deer.cry");
    public static final SoundEvent DEER_HURT = registerSound("mob.deer.hurt");
    public static final SoundEvent DEER_DEATH = registerSound("mob.deer.death");
    public static final SoundEvent BEAR_SAY = registerSound("mob.bear.say");
    public static final SoundEvent BEAR_CRY = registerSound("mob.bear.cry");
    public static final SoundEvent BEAR_CUB_CRY = registerSound("mob.bear.cub.cry");
    public static final SoundEvent BEAR_HURT = registerSound("mob.bear.hurt");
    public static final SoundEvent BEAR_DEATH = registerSound("mob.bear.death");
    public static final SoundEvent PHEASANT_SAY = registerSound("mob.pheasant.say");
    public static final SoundEvent PHEASANT_CHICK_SAY = registerSound("mob.pheasant.chick.say");
    public static final SoundEvent PHEASANT_HURT = registerSound("mob.pheasant.hurt");
    public static final SoundEvent PHEASANT_DEATH = registerSound("mob.pheasant.death");
    public static final SoundEvent CRICKET = registerSound("mob.cricket");
    public static final SoundEvent FROG = registerSound("mob.frog");
    public static final SoundEvent MUSIC = registerSound("music.tfc");

    public static void registerSounds() {

    }

    public static SoundEvent registerSound(String location) {
        Identifier id = TerraFabricCraftCore.getId(location);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
