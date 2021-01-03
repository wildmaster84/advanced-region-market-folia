package net.alex9849.arm.commands;

import net.alex9849.arm.Messages;
import net.alex9849.arm.Permission;
import net.alex9849.arm.regions.Region;

import java.util.Arrays;

public class SetProtectionOfContinuance extends BooleanRegionOptionModifyCommand {

    public SetProtectionOfContinuance() {
        super("setprotectionofcontinuance", Arrays.asList(Permission.ADMIN_SET_PROTECTION_OF_CONTINUANCE), "ProtectionOfContinuance", false, Messages.SUBREGION_PROTECTION_OF_CONTINUANCE_ERROR);
    }

    @Override
    protected void applySetting(Region region, Boolean setting) {
        region.setProtectionOfContinuance(setting);
    }
}
