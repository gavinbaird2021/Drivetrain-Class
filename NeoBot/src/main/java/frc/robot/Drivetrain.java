package frc.robot;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Drivetrain{

    final int canIDleft1 = 1;
    final int canIDleft2 = 2;
    final int canIDright1 = 3;
    final int canIdright2 = 4;

//  haha funny numbers = 69 420 

   CANSparkMax m_left1 = new CANSparkMax(1, MotorType.kBrushless);
   CANEncoder m_leftencoder = m_left1.getEncoder();

   CANSparkMax m_left2 = new CANSparkMax(2, MotorType.kBrushless);
   
   CANSparkMax m_right1 = new CANSparkMax(3, MotorType.kBrushless);
   CANEncoder m_rightencoder = m_right1.getEncoder();

   CANSparkMax m_right2 = new CANSparkMax(4, MotorType.kBrushless);

    public Drivetrain(){
        m_left1.setInverted(false);
        m_left2.setInverted(false);
        m_right1.setInverted(true);
        m_right2.setInverted(true);

        m_left2.follow(m_left1);
        m_right2.follow(m_right1);
    }

    public double getRightEnc(){
        return m_rightencoder.getPosition();
    }

    public double getLeftEnc(){
        return m_leftencoder.getPosition();
    }

    public double getAvgEnc(){
        return (getRightEnc() + getLeftEnc()) / 2;
    }

    public void resetEnc(){
        m_rightencoder.setPosition(0);
        m_leftencoder.setPosition(0);
    }
    public void Drive(double leftPower, double rightPower){
        m_left1.set(leftPower);
        m_right1.set(rightPower);
    }        
    
}
   
