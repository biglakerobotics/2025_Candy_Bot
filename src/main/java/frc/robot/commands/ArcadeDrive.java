package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends Command {
    private final Drivetrain m_Drivetrain;
    private final CommandXboxController m_Controller;

    private double forward;
    private double rotation;

    public ArcadeDrive(CommandXboxController mXboxController, Drivetrain mDrivetrain) {
        m_Drivetrain = mDrivetrain;
        m_Controller = mXboxController;
        addRequirements(m_Drivetrain);
    }

    @Override
    public void execute() {
        if (m_Controller.getRawAxis(2) > 0 ) {
            forward = m_Controller.getLeftY() * Constants.LEFT_DRIVE_VELOCITY;
            rotation = m_Controller.getLeftX() * Constants.ROTATION_VELOCITY;
            m_Drivetrain.mDifferentialDrive.arcadeDrive(forward, rotation);
        } else {
            forward = m_Controller.getLeftY() * Constants.LEFT_SLOW_VELOCITY;
            rotation = m_Controller.getLeftX() * Constants.ROTATION_VELOCITY;
            m_Drivetrain.mDifferentialDrive.arcadeDrive(forward, rotation);
        }
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
