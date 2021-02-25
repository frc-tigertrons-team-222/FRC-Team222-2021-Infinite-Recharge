package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Drive_Arcade extends CommandBase {
  private final Drivetrain m_subsystem;

    public Drive_Arcade(Drivetrain subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
  }

  
  @Override
  public void execute() {
  
  double moveSpeed = -RobotContainer.Controller.getRawAxis(1);
  double rotateSpeed = RobotContainer.Controller.getRawAxis(4);

  if (Math.abs(moveSpeed) < 0.13) {
    // within 10% joystick, make it zero 
  moveSpeed = 0;
  }
  if (Math.abs(rotateSpeed) < 0.13) {
    // within 10% joystick, make it zero 
    rotateSpeed = 0;
  }
  
  m_subsystem.arcadeDrive(moveSpeed,rotateSpeed);
  m_subsystem.leftEncoderABSPos();
  }

  @Override
  public void end(boolean interrupted) {
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}