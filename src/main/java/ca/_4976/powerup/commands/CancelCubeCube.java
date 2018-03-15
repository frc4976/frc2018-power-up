package ca._4976.powerup.commands;

import ca._4976.powerup.Robot;

public class CancelCubeCube extends ListenableCommand {
    @Override
    protected void initialize(){
        Robot.cubeHandler.stop();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end(){
        Robot.cubeHandler.resetACount();
    }
}