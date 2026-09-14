package net.obboble.obboblemod.entities;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.animal.turtle.Turtle;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.monster.zombie.ZombifiedPiglin;
import net.minecraft.world.entity.npc.villager.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

import static net.obboble.obboblemod.EntityTypes.VAGUELY_NAMED;

public class VaguelyNamed extends Monster {
    public VaguelyNamed(EntityType<? extends VaguelyNamed> type, Level level) {
        super(type, level);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(2, new SpearUseGoal<>(this, 1.0, 1.0, 10.0F, 2.0F));
//        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
    }



//    public static AttributeSupplier.Builder createAttributes() {
//        return Monster.createMonsterAttributes()
//                .add(Attributes.FOLLOW_RANGE, 35.0)
//                .add(Attributes.MOVEMENT_SPEED, 0.23F)
//                .add(Attributes.ATTACK_DAMAGE, 3.0)
//                .add(Attributes.ARMOR, 2.0);
//    }


//    public static final EntityDataAccessor<Integer> MY_DATA =
//            SynchedEntityData.defineId(
//                    // The class of the entity.
//                    VaguelyNamed.class,
//                    // The entity data accessor type.
//                    EntityDataSerializers.INT
//            );



//    @Override
//    protected void readAdditionalSaveData(ValueInput input) {}
//
//    @Override
//    protected void addAdditionalSaveData(ValueOutput output) {}
//
//    @Override
//    protected void defineSynchedData(SynchedEntityData.Builder builder) {
//        // Our default value is zero.
//        builder.define(MY_DATA, 0);
//    }
//
//    @Override
//    public boolean hurtServer(ServerLevel level, DamageSource damageSource, float amount) {
//        return true;
//    }
}
