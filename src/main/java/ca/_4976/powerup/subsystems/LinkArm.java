package ca._4976.powerup.subsystems;

/*
Made by Cameron, Jacob, Ethan, Zach
*/

import ca._4976.powerup.Robot;
import ca._4976.powerup.commands.MoveArm;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;

import static ca.qormix.library.Lazy.use;

public final class LinkArm extends Subsystem implements Sendable {

    //Motor inside linkarm carriage - raises/lowers arm
    private final TalonSRX armMotor = new TalonSRX(4);

    //LinkArm encoder
    private Encoder armEnc = new Encoder(6,7);

    private double motorSpeed;
    private double armHighValue;
    private double armMidValue;
    private double armResetValue;
    private double armMinValue;

    public LinkArm(){
        use(NetworkTableInstance.getDefault().getTable("Link Arm"), armTable -> {

//            NetworkTableEntry p = armTable.getEntry("P");
//            NetworkTableEntry i = armTable.getEntry("I");
//            NetworkTableEntry d = armTable.getEntry("D");

            NetworkTableEntry armHigh = armTable.getEntry("45 - High");
            NetworkTableEntry armMid = armTable.getEntry("30 - Mid");
            NetworkTableEntry armReset = armTable.getEntry("0 - Reset");
            NetworkTableEntry armMin = armTable.getEntry("Minimum");

            NetworkTableEntry motorOut = armTable.getEntry("Manual Output");

//            p.setPersistent();
//            i.setPersistent();
//            d.setPersistent();

            armHigh.setPersistent();
            armMid.setPersistent();
            motorOut.setPersistent();
            armReset.setPersistent();
            armMin.setPersistent();

            motorSpeed = motorOut.getDouble(0.7);
            
            armHighValue = armHigh.getDouble(0);
            armMidValue = armMid.getDouble(0);
            armResetValue = armReset.getDouble(0);
            armMinValue = armMin.getDouble(0);
            
        });
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new MoveArm());
    }

    //move linkage arm
    public void moveLinkArm(){

        double armOut = Robot.oi.operator.getRawAxis(5);

        //dead zone
        if (Math.abs(armOut) <= 0.03) {
            armMotor.set(ControlMode.PercentOutput, 0);
        }

        else {
            armMotor.set(ControlMode.PercentOutput,0.5 * armOut);
        }
    }
    
    public double getArmEncoderValue(){
        return armEnc.getDistance();
    }

    /**
     * LinkArm presets and accompanying check methods
     */
    public void moveArmHigh(){


        if(getArmEncoderValue() > armHighValue){
            armMotor.set(ControlMode.PercentOutput, motorSpeed);
        }

        else if(getArmEncoderValue() < armHighValue){
            armMotor.set(ControlMode.PercentOutput, -motorSpeed);
        }
    }

    public boolean checkArmHigh(){
        
        if(getArmEncoderValue() >= (armHighValue - 200) && getArmEncoderValue() <= (armHighValue + 200)){
            return true;
        }

        else {
            return false;
        }
    }

    public void moveArmMid(){


        if(getArmEncoderValue() > armMidValue){
            armMotor.set(ControlMode.PercentOutput, motorSpeed);
        }

        else if(getArmEncoderValue() < armMidValue){
            armMotor.set(ControlMode.PercentOutput, -motorSpeed);
        }
    }

    public boolean checkArmMid(){

        if(getArmEncoderValue() >= (armMidValue - 200) && getArmEncoderValue() <= (armMidValue + 200)){
            return true;
        }

        else {
            return false;
        }
    }

    public void moveArmReset(){
        if(getArmEncoderValue() > armResetValue){
            armMotor.set(ControlMode.PercentOutput, motorSpeed);
        }

        else if(getArmEncoderValue() < armResetValue){
            armMotor.set(ControlMode.PercentOutput, -motorSpeed);
        }
    }

    public boolean checkArmReset(){

        if(getArmEncoderValue() >= (armResetValue - 200) && getArmEncoderValue() <= (armResetValue + 200)){

            return true;
        }

        else {
            return false;
        }
    }

    public void moveArmMinimum(){


        if(getArmEncoderValue() > armMinValue){
            armMotor.set(ControlMode.PercentOutput, motorSpeed);
        }

        else if(getArmEncoderValue() < armMinValue){
            armMotor.set(ControlMode.PercentOutput, -motorSpeed);
        }
    }

    public boolean checkArmMinimum(){

        if(getArmEncoderValue() >= (armMinValue - 200) && getArmEncoderValue() <= (armMinValue + 200)){

            return true;
        }

        else {
            return false;
        }
    }
}
