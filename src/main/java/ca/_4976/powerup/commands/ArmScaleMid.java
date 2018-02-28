package ca._4976.powerup.commands;

import ca._4976.powerup.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Created by 4976 on 2018-02-17.
 */
public class ArmScaleMid extends ListenableCommand{

    @Override
    protected void initialize(){

    }

    @Override
    protected void execute(){
        System.out.println("Arm high ran");
        Robot.linkArm.moveArmMid();
    }

    @Override
    protected boolean isFinished() {
        return Robot.linkArm.checkArmMid();
    }
}