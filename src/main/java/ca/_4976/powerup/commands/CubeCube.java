package ca._4976.powerup.commands;

import ca._4976.powerup.Robot;

/**
 * Created by 4976 on 2018-03-09.
 */
public class CubeCube extends ListenableCommand{

    @Override
    protected void initialize(){
        Robot.cubeHandler.incrementACount();

        if(Robot.cubeHandler.getAButtonCount() != 2) {
            Robot.cubeHandler.intakeCube();
        }
    }

    @Override
    protected void execute(){
        System.out.println("A COUNT EXEC: " + Robot.cubeHandler.getAButtonCount());

        Robot.cubeHandler.cubeCurrent();
    }

    @Override
    protected boolean isFinished(){
        if(Robot.cubeHandler.getAButtonCount() != 2 && !Robot.motion.isRecording()) {
            return Robot.cubeHandler.currentFlag;
        }

        else {
            return true;
        }
    }

    @Override
    protected void end(){

        if(Robot.cubeHandler.getAButtonCount() == 2){// && Robot.cubeHandler.currentFlag){
            new AutoCube().start();
        }

        else {
            Robot.cubeHandler.resetFlags();
        }
    }
}
