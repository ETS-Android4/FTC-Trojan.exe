package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HardwareM
{
    public DcMotor roataStanga  = null;     //Motoare
    public DcMotor roataDreapta = null;
    public DcMotor brat_1       = null;
    public DcMotor peria        = null;
    public DcMotor carusel      = null;

    public Servo servo_1 = null;            //Servouri
    public Servo servo_2 = null;

            HardwareMap hwMap    = null;    //Altele
    private ElapsedTime perioada = new ElapsedTime();

    public HardwareM(){}                    //Constructor

    public void init (HardwareMap hwMap, Boolean useEncoders)
    {
        //Motoare
        roataStanga  = hwMap.get(DcMotor.class, "motorStanga");
        roataDreapta = hwMap.get(DcMotor.class, "motorDreapta");
        brat_1       = hwMap.get(DcMotor.class, "motor1");
        peria        = hwMap.get(DcMotor.class, "peria");
        carusel      = hwMap.get(DcMotor.class, "Carusel");

        roataDreapta.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);  //Power 0 behavior
        roataStanga.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        brat_1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        peria.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        carusel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        roataDreapta.setDirection(DcMotorSimple.Direction.FORWARD);          //Directie motoare
        roataStanga.setDirection(DcMotorSimple.Direction.REVERSE);
        brat_1.setDirection(DcMotorSimple.Direction.FORWARD);
        peria.setDirection(DcMotorSimple.Direction.FORWARD);
        carusel.setDirection(DcMotorSimple.Direction.FORWARD);

        if (useEncoders) {
            roataDreapta.setMode(DcMotor.RunMode.RUN_USING_ENCODER);           //Cu Encodere
            roataStanga.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            brat_1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            peria.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            carusel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
        else{
            roataDreapta.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);           //Fara Encodere
            roataStanga.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            brat_1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            peria.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            carusel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        roataDreapta.setPower(0);                                            //setPower 0
        roataStanga.setPower(0);
        brat_1.setPower(0);
        peria.setPower(0);
        carusel.setPower(0);

        //Servouri
        servo_1 = hwMap.get(Servo.class, "servo1");
        servo_2 = hwMap.get(Servo.class, "servo2");

    }
}
