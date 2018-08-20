package frc.team5190.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

    double time;
    double kP = 0.07;

    TalonSRX leftMaster = new TalonSRX(1);
    TalonSRX leftSlave = new TalonSRX(2);
    TalonSRX leftSlave2 = new TalonSRX(3);

    TalonSRX rightMaster = new TalonSRX(4);
    TalonSRX rightSlave = new TalonSRX(5);
    TalonSRX rightSlave2 = new TalonSRX(6);

    @Override
    public void robotInit() {

    }

    
    @Override
    public void autonomousInit() {
        time = System.currentTimeMillis();

        // Let slaves follow master
        leftSlave.follow(leftMaster);
        leftSlave2.follow(leftMaster);

        rightSlave.follow(rightMaster);
        rightSlave2.follow(rightMaster);

        // Motor Inversion
        leftMaster.setInverted(true);
        leftSlave.setInverted(false);
        leftSlave2.setInverted(false);

        rightMaster.setInverted(false);
        rightSlave.setInverted(true);
        rightSlave2.setInverted(true);

        leftMaster.setSensorPhase(false);
        rightMaster.setSensorPhase(false);

        leftMaster.setSelectedSensorPosition(0, 0, 0);
        rightMaster.setSelectedSensorPosition(0, 0, 0);
    }

    @Override
    public void robotPeriodic() {

    }

    
    @Override
    public void teleopInit() {
        
    }

    
    @Override 
    public void disabledInit() {

    }


    @Override
    public void autonomousPeriodic() {
        if (System.currentTimeMillis() - time <  3000L) {
            leftMaster.set(ControlMode.PercentOutput, 0.4);
            rightMaster.set(ControlMode.PercentOutput, 0.4);
        } else {
            leftMaster.set(ControlMode.PercentOutput, 0.0);
            rightMaster.set(ControlMode.PercentOutput, 0.0);
        }

      
    }


    @Override 
    public void teleopPeriodic() {
        System.out.println("Hello world");
    }


    @Override
    public void disabledPeriodic() {

    }
}