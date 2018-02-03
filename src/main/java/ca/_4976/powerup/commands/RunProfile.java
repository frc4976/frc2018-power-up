package ca._4976.powerup.commands;

import ca._4976.powerup.Robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command will begin running the profile that is saved in memory.
 */
public final class RunProfile extends Command {

    public RunProfile() { willRunWhenDisabled(); }

    private Joystick driver = new Joystick(0);

    @Override protected void initialize() {

            System.out.println("run");
            Robot.drive.resetEncoderPosition();
            Robot.drive.setUserControlEnabled(false);
            Robot.motion.run();
        }


    @Override protected boolean isFinished() { return !Robot.motion.isRunning(); }

    @Override protected void end() { Robot.drive.setUserControlEnabled(true); }
}
