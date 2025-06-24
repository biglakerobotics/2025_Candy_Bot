package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AirCompressor;

public class LaunchCandy extends Command {
    private final AirCompressor m_AirCompressor;

    public LaunchCandy(AirCompressor airCompressor) {
        m_AirCompressor = airCompressor;
        addRequirements(m_AirCompressor);
    }

    @Override
    public void initialize() {
        System.out.println("Launching Candy!!!!");
    }

    @Override
    public void execute() {
        m_AirCompressor.enableSolenoid();
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("Retracting launcher...");
        m_AirCompressor.disableSolenoid();
    }
}
