package ca._4976.powerup.commands;

import ca._4976.powerup.Robot;

public class SpitCubeCube extends ListenableCommand {

    @Override
    protected void initialize(){Robot.cubeHandler.spitGear();}

    @Override
    protected boolean isFinished() {
        return true;
    }

}