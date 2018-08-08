package frc.team5190.samples;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;

public class SampleP03 extends TimedRobot {

    private TalonSRX leftMaster = new TalonSRX(1);
    private TalonSRX leftSlave = new TalonSRX(2);

    private TalonSRX rightMaster = new TalonSRX(3);
    private TalonSRX rightSlave = new TalonSRX(4);

    @Override
    public void robotInit() {
        leftMaster.setInverted(false);
        leftSlave.setInverted(false);
        leftSlave.follow(leftMaster);

        rightMaster.setInverted(true);
        rightSlave.setInverted(true);
        rightSlave.follow(rightMaster);
    }

    @Override
    public void autonomousPeriodic() {
        leftMaster.set(ControlMode.PercentOutput, 0.60);
        rightMaster.set(ControlMode.PercentOutput, 0.60);
    }
}