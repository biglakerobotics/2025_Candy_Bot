package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class DualStickTankDriveCommand extends Command {
    private final Drivetrain m_Drivetrain;
    private final CommandXboxController m_Controller;

    private double leftStickInput;
    private double rightStickInput;

    public DualStickTankDriveCommand(CommandXboxController mXboxController, Drivetrain mDrivetrain) {
        m_Drivetrain = mDrivetrain;
        m_Controller = mXboxController;
        addRequirements(m_Drivetrain);
    }

    @Override
    public void execute() {
        if (m_Controller.getRawAxis(2) > 0 ) {
            leftStickInput = m_Controller.getLeftY() * Constants.LEFT_DRIVE_VELOCITY;
            rightStickInput = m_Controller.getRightY() * Constants.RIGHT_DRIVE_VELOCITY;
        } else {
            leftStickInput = m_Controller.getLeftY() * Constants.LEFT_SLOW_VELOCITY;
            rightStickInput = m_Controller.getRightY() * Constants.RIGHT_SLOW_VELOCITY;
        }
        m_Drivetrain.setLeftMotorOutput(leftStickInput);
        m_Drivetrain.setRightMotorOutput(rightStickInput);
    }
}
