package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HardwareM
{
    public DcMotor roataStanga = null;
    public DcMotor roataDreapta = null;
    public DcMotor brat_1 = null;
    public DcMotor peria = null;

    public Servo servo_1 = null;
    public Servo servo_2 = null;

    HardwareMap hwMap = null;
    private ElapsedTime perioada = new ElapsedTime();

    public HardwareM(){}

    public void init (HardwareMap hwMap)
    {
        //Motoare
        roataStanga  = hwMap.get(DcMotor.class, "motorStanga");
        roataDreapta = hwMap.get(DcMotor.class, "motorDreapta");
        brat_1       = hwMap.get(DcMotor.class, "motor1");
        peria        = hwMap.get(DcMotor.class, "peria");

        roataDreapta.setDirection(DcMotorSimple.Direction.FORWARD);    //Directie motoare
        roataStanga.setDirection(DcMotorSimple.Direction.REVERSE);
        brat_1.setDirection(DcMotorSimple.Direction.FORWARD);
        peria.setDirection(DcMotorSimple.Direction.FORWARD);

        roataDreapta.setPower(0);
        roataStanga.setPower(0);
        brat_1.setPower(0);
        peria.setPower(0);

        roataDreapta.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        roataStanga.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        brat_1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        peria.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        roataDreapta.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        roataStanga.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        brat_1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        peria.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        //Servouri
        servo_1 = hwMap.get(Servo.class, "servo1");
        servo_2 = hwMap.get(Servo.class, "servo2");

    }
}
