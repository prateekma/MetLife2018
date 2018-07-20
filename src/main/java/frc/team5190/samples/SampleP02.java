package frc.team5190.samples;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.TimedRobot;

public class SampleP02 extends TimedRobot {

    private Long startTime;

    private TalonSRX myTalonSRX = new TalonSRX(1);

    @Override
    public void autonomousInit() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void autonomousPeriodic() {
        if (System.currentTimeMillis() - startTime < 10.0) {
            myTalonSRX.set(ControlMode.PercentOutput, 0.5);
        } else {
            myTalonSRX.set(ControlMode.PercentOutput, 0.0);
        }
    }
}
