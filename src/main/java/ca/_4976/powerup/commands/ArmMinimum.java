package ca._4976.powerup.commands;

import ca._4976.powerup.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Created by 4976 on 2018-02-17.
 */
public class ArmMinimum extends ListenableCommand {

    @Override
    protected void initialize(){
        Robot.linkArm.moveArmMinimum();
    }

    @Override
    protected boolean isFinished() {
        return Robot.linkArm.checkArmMinimum();
    }
}