package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.OperatorConstants;

public class Drivetrain extends SubsystemBase {
    // Define Motor controllers here
    TalonFX leftLeaderMotorController = new TalonFX(Constants.LEFT_LEAD_MOTOR_ID);
    TalonFX leftFollowMotorController = new TalonFX(Constants.LEFT_FOLLOW_MOTOR_ID);
    TalonFX rightLeaderMotorController = new TalonFX(Constants.RIGHT_LEAD_MOTOR_ID);
    TalonFX rightFollowMotorController = new TalonFX(Constants.RIGHT_FOLLOW_MOTOR_ID);

    public final DifferentialDrive mDifferentialDrive;

    public Drivetrain() {
        TalonFXConfiguration globalTalonFXConfig = new TalonFXConfiguration();
        TalonFXConfiguration leftLeadTalonFXConfig = new TalonFXConfiguration();
        TalonFXConfiguration rightLeadTalonFXConfig = new TalonFXConfiguration();
        TalonFXConfiguration leftFollowTalonFXConfig = new TalonFXConfiguration();
        TalonFXConfiguration rightFollowTalonFXConfig = new TalonFXConfiguration();

        // Global Motor Configs
        // globalTalonFXConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        // globalTalonFXConfig.MotorOutput.DutyCycleNeutralDeadband = OperatorConstants.JOYSTICK_DEADBAND;

        // Left Lead motor configs
        leftLeadTalonFXConfig.MotorOutput.Inverted = Constants.LEFT_DRIVE_INVERT_DIRECTION;
        leftLeadTalonFXConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        leftLeadTalonFXConfig.MotorOutput.DutyCycleNeutralDeadband = OperatorConstants.JOYSTICK_DEADBAND;
        leftLeaderMotorController.getConfigurator().apply(leftLeadTalonFXConfig);

        // Right Lead motor configs
        rightLeadTalonFXConfig.MotorOutput.Inverted = Constants.RIGHT_DRIVE_INVERT_DIRECTION;
        rightLeadTalonFXConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        rightLeadTalonFXConfig.MotorOutput.DutyCycleNeutralDeadband = OperatorConstants.JOYSTICK_DEADBAND;
        rightLeaderMotorController.getConfigurator().apply(rightLeadTalonFXConfig);

        // Left Follow motor configs
        leftFollowTalonFXConfig.MotorOutput.Inverted = Constants.LEFT_DRIVE_INVERT_DIRECTION;
        leftFollowTalonFXConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        leftFollowTalonFXConfig.MotorOutput.DutyCycleNeutralDeadband = OperatorConstants.JOYSTICK_DEADBAND;
        leftFollowMotorController.getConfigurator().apply(leftFollowTalonFXConfig);
        leftFollowMotorController.setControl(new Follower(leftLeaderMotorController.getDeviceID(), false));

        // Right Follow motor configs
        rightFollowTalonFXConfig.MotorOutput.Inverted = Constants.RIGHT_DRIVE_INVERT_DIRECTION;
        rightFollowTalonFXConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        rightFollowTalonFXConfig.MotorOutput.DutyCycleNeutralDeadband = OperatorConstants.JOYSTICK_DEADBAND;
        rightFollowMotorController.getConfigurator().apply(rightFollowTalonFXConfig);
        rightFollowMotorController.setControl(new Follower(rightLeaderMotorController.getDeviceID(), false));

        mDifferentialDrive = new DifferentialDrive(leftLeaderMotorController::set, rightLeaderMotorController::set);
    }

    public void setLeftMotorOutput(double mSpeed) {
        leftLeaderMotorController.set(mSpeed);
        leftFollowMotorController.set(mSpeed);
    }

    public void setRightMotorOutput(double mSpeed) {
        rightLeaderMotorController.set(mSpeed);
        rightFollowMotorController.set(mSpeed);
    }

    @Override
    public void periodic() {
        
    }

    @Override
    public void simulationPeriodic() {

    }
}
