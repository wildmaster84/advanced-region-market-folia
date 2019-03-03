package net.alex9849.arm.Handler.listener;

import net.alex9849.arm.regions.Region;
import net.alex9849.arm.regions.RegionManager;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.vehicle.VehicleCreateEvent;

import java.util.List;

public class EntitySpawnListener implements Listener {

    @EventHandler
    public void entitySpawnEvent(EntitySpawnEvent event) {
        if(event.isCancelled()) {
            return;
        }
        if(event.getEntityType() == EntityType.PLAYER) {
            return;
        }

        List<Region> regions = RegionManager.getRegionsByLocation(event.getLocation());

        for(Region region : regions) {
            if(region.getEntityLimitGroup().isLimitReached(region, event.getEntityType(), region.getExtraEntityAmount(event.getEntityType()))) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void vehicleSpawnEvent(VehicleCreateEvent event) {
        if(event.isCancelled()) {
            return;
        }
        List<Region> regions = RegionManager.getRegionsByLocation(event.getVehicle().getLocation());

        for(Region region : regions) {
            if(region.getEntityLimitGroup().isLimitReached(region, event.getVehicle().getType(), region.getExtraEntityAmount(event.getVehicle().getType()))) {
                event.setCancelled(true);
            }
        }
    }

}
