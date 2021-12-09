package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HardwareM extends LinearOpMode
{
    public DcMotor roataStanga = null;     //Motoare fata
    public DcMotor roataDreapta = null;
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
        roataStanga = hardwaremap.get(DcMotor.class, "motorFS");
        roataDreapta = hardwaremap.get(DcMotor.class, "motorFD");
        brat_1       = hardwaremap.get(DcMotor.class, "motor1");
        peria        = hardwaremap.get(DcMotor.class, "peria");
        carusel      = hardwaremap.get(DcMotor.class, "Carusel");

        set0Behaviour(roataStanga, roataDreapta, backl, backr, brat_1, peria, carusel);  //set 0 Behaivior

        setDirectionF(roataDreapta, backr, brat_1, peria, carusel);  //set Directions Forward
        setDirectionR(roataStanga, backl);  //set Directions Reverse

        setEncoders(useEncoders, roataStanga, roataDreapta, backl, backr, brat_1, peria, carusel);  //set encoders

        setPow0(roataStanga, roataDreapta, backl, backr, brat_1, peria, carusel);    //setPower 0

        //Servouri
        servo_1 = hardwaremap.get(Servo.class, "servo1");
        servo_2 = hardwaremap.get(Servo.class, "servo2");

    }

    private void setPow0(DcMotor ... motors)
    {
        for (DcMotor m:motors)
            m.setPower(0);
    }

    private void setEncoders(Boolean use, DcMotor ... motors)
    {
        for (DcMotor m:motors) {
            if (use)
            {
                m.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);           //Cu Encodere
                m.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            }
            else m.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }

    private void set0Behaviour(DcMotor ... motors)
    {
        for (DcMotor m:motors)
            m.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    private void setDirectionF(DcMotor ... motors)
    {
        for (DcMotor m:motors)
            m.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    private void setDirectionR(DcMotor ... motors)
    {
        for (DcMotor m:motors)
            m.setDirection(DcMotorSimple.Direction.REVERSE);
    }


    @Override
    public void runOpMode(){}
}
