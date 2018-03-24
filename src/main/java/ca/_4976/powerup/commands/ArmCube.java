package ca._4976.powerup.commands;

import ca._4976.powerup.Robot;

/**
 * Created by 4976 on 2018-02-17.
 */
public class ArmCube extends ListenableCommand {

    public ArmCube(){
        requires(Robot.linkArm);
    }

    @Override
    protected void initialize(){
        Robot.linkArm.moveArmTarget(Robot.linkArm.armHighValue);
    }

    @Override
    protected boolean isFinished() {
        return Robot.elevator.testInputs(false) || Robot.linkArm.testArmInput() || Robot.linkArm.checkArmTarget();
    }

    @Override
    protected void end(){
        Robot.linkArm.resetArmFlags();
        Robot.linkArm.setHoldingSpeed();
    }
}
