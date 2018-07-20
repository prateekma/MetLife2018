package frc.team5190.samples;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.TimedRobot;

public class SampleP03 extends TimedRobot {

    private TalonSRX myTalonSRX = new TalonSRX(1);
    private PIDController pidController = new PIDController(1.0, 0.0, 0.0, 1 / 25.0, 0.1);

    @Override
    public void autonomousInit() {
        myTalonSRX.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
    }

    @Override
    public void autonomousPeriodic() {
        double output = pidController.getPIDOutput(toFPS(myTalonSRX.getSelectedSensorVelocity(0), 1440, 3), 5.0);
        myTalonSRX.set(ControlMode.PercentOutput, output);
    }

    private double toFPS(double ticks, double sensorUnitsPerRotation, double wheelRadiusInches) {
        return (ticks / sensorUnitsPerRotation * (2.0 * Math.PI * wheelRadiusInches) / 12.0) * 10.0;
    }


    class PIDController {
        double kP, kI, kD, kV, kS;

        double integrand = 0.0;
        double lastError = 0.0;

        PIDController(double kP, double kI, double kD, double kV, double kS) {
            this.kP = kP;
            this.kI = kI;
            this.kD = kD;
            this.kV = kV;
            this.kS = kS;
        }

        double getPIDOutput(double current, double setpoint) {
            double error = setpoint - current;
            integrand += error;

            double derivative = error - lastError;

            double output = kP * error + kI * integrand + kD * derivative * kV * setpoint + Math.signum(setpoint) * kS;
            lastError = error;

            return output;
        }
    }
}
