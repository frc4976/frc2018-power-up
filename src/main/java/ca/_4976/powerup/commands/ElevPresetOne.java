package ca._4976.powerup.commands;

import ca._4976.powerup.Robot;
import edu.wpi.first.wpilibj.command.Command;

public final class ElevPresetOne extends Command {
    public ElevPresetOne() {

    }

    @Override
    protected void execute() {
        Robot.elevator.groundPS();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
    }
}