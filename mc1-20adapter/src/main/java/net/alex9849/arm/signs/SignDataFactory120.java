package net.alex9849.arm.signs;

import net.alex9849.arm.util.MaterialFinder120;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Sign;
import org.bukkit.block.data.type.WallSign;

public class SignDataFactory120 extends SignDataFactory {
    public SignData generateSignData(Location loc) {
        if (!MaterialFinder120.getInstance().getSignMaterials().contains(loc.getBlock().getType())) {
            return null;
        }

        BlockFace blockFace;
        SignAttachment signAttachment;

        if (loc.getBlock().getBlockData() instanceof Sign) {
            Sign sign = (Sign) loc.getBlock().getBlockData();
            blockFace = sign.getRotation();
            signAttachment = SignAttachment.GROUND;
        } else {
            WallSign wallSign = (WallSign) loc.getBlock().getBlockData();
            blockFace = wallSign.getFacing();
            signAttachment = SignAttachment.WALL;
        }

        return new SignData120(loc, signAttachment, blockFace);
    }

    @Override
    public SignData generateSignData(Location loc, SignAttachment signAttachment, BlockFace blockFace) {
        return new SignData120(loc, signAttachment, blockFace);
    }
}
