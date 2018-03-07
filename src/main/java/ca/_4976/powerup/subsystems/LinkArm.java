package ca._4976.powerup.subsystems;

/*
Made by Cameron, Jacob, Ethan, Zach
*/

import ca._4976.powerup.Robot;
import ca._4976.powerup.commands.MoveArm;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;

import static ca.qormix.library.Lazy.use;

public final class LinkArm extends Subsystem implements Sendable {

    //Motor inside linkarm carriage - raises/lowers arm
    public final TalonSRX armMotor = new TalonSRX(4);

    //Motor values
    private double motorSpeed = 0.5;
    private double holdingPower = -0.1; //compensate for reversal of motor

    //Preset values
    private double armHighValue = 4800;
    private double arm45Value = 2700;
    private double arm30Value = 2445;
    private double armLevelValue = 0;
    private double armDefault2Value = -2100;

    //Preset tolerance
    private double tolerance;

    public LinkArm(){
        armMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);

        tolerance = 200;
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new MoveArm());
    }

    //move linkage arm
    public void moveLinkArm(){

//         System.out.println("Arm encoder: " + getArmEncoderValue());

        double armOut = Robot.oi.operator.getRawAxis(5);
        double motorOut;

        //dead zone
        if (Math.abs(armOut) <= 0.15) {
            motorOut = holdingPower;
        }

        else {
            motorOut = armOut;
        }

        armMotor.set(ControlMode.PercentOutput, motorOut);


    }

    public void setHoldingSpeed(){
        armMotor.set(ControlMode.PercentOutput, holdingPower);
    }


    /**
     * Gets the negative value of the linkage arm encoder
     *
     * @return -arm encoder value
     */
    public double getArmEncoderValue(){
        double value = armMotor.getSensorCollection().getQuadraturePosition();

        return -value;
    }

    /**
     * Resets the arm encoder to its 0 position
     */
    public void resetArmEncoder(){
        armMotor.getSensorCollection().setQuadraturePosition(0,0);
    }


    /**
     * LinkArm presets and accompanying check methods
     */
    public void moveArm30(){

        if(getArmEncoderValue() > arm30Value){
            armMotor.set(ControlMode.PercentOutput, motorSpeed);
        }

        else if(getArmEncoderValue() < armHighValue){
            armMotor.set(ControlMode.PercentOutput, -motorSpeed);
        }
    }

    public boolean checkArm30(){
        return getArmEncoderValue() >= (arm30Value - tolerance) && getArmEncoderValue() <= (arm30Value + tolerance);
    }

    public void moveArm45(){

        if(getArmEncoderValue() > arm45Value){
            armMotor.set(ControlMode.PercentOutput, motorSpeed);
        }

        else if(getArmEncoderValue() < arm45Value){
            armMotor.set(ControlMode.PercentOutput, -motorSpeed);
        }
    }

    public boolean checkArm45(){
        return getArmEncoderValue() >= (arm45Value - tolerance) && getArmEncoderValue() <= (arm45Value + tolerance);
    }

    public void moveArmLevel(){
        if(getArmEncoderValue() > armLevelValue){
            armMotor.set(ControlMode.PercentOutput, motorSpeed);
        }

        else if(getArmEncoderValue() < armLevelValue){
            armMotor.set(ControlMode.PercentOutput, -motorSpeed);
        }
    }

    public boolean checkArmLevel(){
        return getArmEncoderValue() >= (armLevelValue) && getArmEncoderValue() <= (armLevelValue + tolerance);
    }

    public void moveArmCube(){


        if(getArmEncoderValue() > armDefault2Value){
            armMotor.set(ControlMode.PercentOutput, motorSpeed);
        }

        else if(getArmEncoderValue() < armDefault2Value){
            armMotor.set(ControlMode.PercentOutput, -motorSpeed);
        }
    }

    public boolean checkArmCube(){
        return getArmEncoderValue() >= (armDefault2Value - tolerance) && getArmEncoderValue() <= (armDefault2Value + tolerance);
    }
}
