package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HardwareM extends LinearOpMode
{
    public DcMotor frontl = null;     //Motoare fata
    public DcMotor frontr = null;
    public DcMotor backl = null;     //Motoare spate
    public DcMotor backr = null;
    public DcMotor brat_1       = null;
    public DcMotor peria        = null;
    public DcMotor carusel      = null;

    public Servo servo_1 = null;            //Servouri
    public Servo servo_2 = null;

            HardwareMap hwMap    = null;    //Altele
    private ElapsedTime perioada = new ElapsedTime();

    public HardwareM(){}                    //Constructor

    public void init (HardwareMap hardwaremap, Boolean useEncoders)
    {
        //Motoare
        frontl = hardwaremap.get(DcMotor.class, "motorFS");
        frontr = hardwaremap.get(DcMotor.class, "motorFD");
        backl = hardwaremap.get(DcMotor.class, "motorSS");
        backr = hardwaremap.get(DcMotor.class, "motorSD");
        brat_1       = hardwaremap.get(DcMotor.class, "motor1");
        peria        = hardwaremap.get(DcMotor.class, "peria");
        carusel      = hardwaremap.get(DcMotor.class, "Carusel");

        set0Behaviour(frontl, frontr, backl, backr, brat_1, peria, carusel);
//        frontr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);  //Phower 0 behavior
//        frontl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        backr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        backl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        brat_1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        peria.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        carusel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        setDirection(frontl, frontr, backl, backr, brat_1, peria, carusel);
//        frontr.setDirection(DcMotorSimple.Direction.FORWARD);          //Directie motoare
//        frontl.setDirection(DcMotorSimple.Direction.REVERSE);
//        backr.setDirection(DcMotorSimple.Direction.FORWARD);
//        backl.setDirection(DcMotorSimple.Direction.REVERSE);
//        brat_1.setDirection(DcMotorSimple.Direction.FORWARD);
//        peria.setDirection(DcMotorSimple.Direction.FORWARD);
//        carusel.setDirection(DcMotorSimple.Direction.FORWARD);

        setEncoders(useEncoders, frontl, frontr, backl, backr, brat_1, peria, carusel);
//        if (useEncoders) {
//            frontr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);           //Cu Encodere
//            frontl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//            backr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//            backl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//            brat_1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//            peria.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//            carusel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//            frontr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            frontl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            backr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            backl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            brat_1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            peria.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            carusel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        }
//        else{
//            frontr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);           //Fara Encodere
//            frontl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//            backr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//            backl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//            brat_1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//            peria.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//            carusel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        }

        setPow0(frontl, frontr, backl, backr, brat_1, peria, carusel);    //setPower 0
//        frontr.setPower(0);
//        frontl.setPower(0);
//        backr.setPower(0);
//        backl.setPower(0);
//        brat_1.setPower(0);
//        peria.setPower(0);
//        carusel.setPower(0);

        //Servouri
        servo_1 = hardwaremap.get(Servo.class, "servo1");
        servo_2 = hardwaremap.get(Servo.class, "servo2");

    }

    private void setPow0(DcMotor ... motors)
    {
        for (DcMotor m:motors)
            m.setPower(0);
    }
    private void setEncoders(Boolean useE, DcMotor ... motors)
    {
        for (DcMotor m:motors) {
            if (useE)
            {
                m.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);           //Cu Encodere
                m.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            }
            else
            {
                m.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            }
        }
    }
    private void set0Behaviour(DcMotor ... motors)
    {
        for (DcMotor m:motors)
            m.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    private void setDirection(DcMotor frontl, DcMotor frontr, DcMotor backl, DcMotor backr, DcMotor brat_1, DcMotor peria, DcMotor carusel)
    {
        frontr.setDirection(DcMotorSimple.Direction.FORWARD);          //Directie motoare
        frontl.setDirection(DcMotorSimple.Direction.REVERSE);
        backr.setDirection(DcMotorSimple.Direction.FORWARD);
        backl.setDirection(DcMotorSimple.Direction.REVERSE);
        brat_1.setDirection(DcMotorSimple.Direction.FORWARD);
        peria.setDirection(DcMotorSimple.Direction.FORWARD);
        carusel.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void runOpMode(){}
}
