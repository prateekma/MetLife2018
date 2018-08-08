package frc.team5190.samples;

import edu.wpi.first.wpilibj.TimedRobot;

public class SampleP02B extends TimedRobot {

    private Long timer = 0L;

    @Override
    public void autonomousInit() {
        timer = System.currentTimeMillis();
    }

    @Override
    public void autonomousPeriodic() {
        if (System.currentTimeMillis() - timer > 20000) {
            System.out.println("Hello, world!");
            timer = System.currentTimeMillis();
        }
    }
}
