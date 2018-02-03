package ca._4976.powerup.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Ramp extends Subsystem{
    //Jack, Quoc, Charlotte, Corey

    //Ramp motor used to rotate the ramp up and down
    TalonSRX rampMotor = new TalonSRX(5);

    //Solenoid used to deploy the ramp
    DoubleSolenoid solenoidRamp = new DoubleSolenoid(0,1);

    public void end(){}

    //When start button is pushed fire solenoid to deploy the ramp
    //Start and back button may also be held simultaneously as an override
    public void deployRamp(){

    }

    //Upon the push of the right bumper the ramp motor will spin (counter)-clockwise upwards
    public void rampUp(){

    }

    //Upon the push of the left bumper the ramp motor will spin (counter)-clockwise downwards
    public void rampDown(){

    }

    @Override
    protected void initDefaultCommand() {

    }
}