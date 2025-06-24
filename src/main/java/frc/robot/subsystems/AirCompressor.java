package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class AirCompressor extends SubsystemBase {
    private final Compressor pcmCompressor;
    private final Solenoid launchSolenoid;

    public AirCompressor() {
        pcmCompressor = new Compressor(Constants.PCM_CAN_ID, PneumaticsModuleType.CTREPCM);
        launchSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.SOLENOID_PORT_ID);

        // Enable closed-loop control for the compressor
        pcmCompressor.enableDigital();
    }

    public void enableSolenoid() {
        if (launchSolenoid.get()) {
            return;
        } else {
            launchSolenoid.toggle();
        }
    }

    public void disableSolenoid() {
        if (launchSolenoid.get()) {
            launchSolenoid.toggle();
        } else {
            return;
        }
    }

    @Override
    public void periodic() {

    }
}
