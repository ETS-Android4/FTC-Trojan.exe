package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareM extends LinearOpMode
{
    public DcMotor roataStanga  = null;     //Motoare fata
    public DcMotor roataDreapta = null;

    public DcMotor brat_S       = null;     //Motoare brat
    public DcMotor brat_D       = null;
    public DcMotor brat_A       = null;

    public DcMotor peria        = null;     //Altele
    public DcMotor carusel      = null;

//    private ElapsedTime perioada = new ElapsedTime();

    public void init (HardwareMap hardwaremap, Boolean useEncoders)
    {
        //Motoare
        roataStanga  = hardwaremap.get(DcMotor.class, "motorStanga");
        roataDreapta = hardwaremap.get(DcMotor.class, "motorDreapta");
        brat_S       = hardwaremap.get(DcMotor.class, "motorS");
        brat_D       = hardwaremap.get(DcMotor.class, "motorD");
        brat_A       = hardwaremap.get(DcMotor.class, "motor3");
        peria        = hardwaremap.get(DcMotor.class, "motorPeria");
        carusel      = hardwaremap.get(DcMotor.class, "motorCarusel");

        set0Behaviour(roataStanga, roataDreapta, brat_S, brat_D, brat_A, peria, carusel);  //set 0 Behaivior

        setDirectionF(roataDreapta, brat_S, brat_D, brat_A, peria, carusel);               //set Directions Forward
        setDirectionR(roataStanga, brat_S);                                        //set Directions Reverse

        setEncoders(useEncoders, roataStanga, roataDreapta, brat_S, brat_D, brat_A, peria, carusel);    //set encoders

        setPow0(roataStanga, roataDreapta, brat_S, brat_D, brat_A, peria, carusel);    //setPower 0
    }

    private void setPow0(DcMotor ... motors) {
        for (DcMotor m:motors)
            m.setPower(0);
    }

    private void setEncoders(Boolean use, DcMotor ... motors) {
        if (use) {
            for (DcMotor m:motors) {
                m.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);           //Cu Encodere
                m.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            }
        }
        else for (DcMotor m:motors)
                 m.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    private void set0Behaviour(DcMotor ... motors) {
        for (DcMotor m:motors)
            m.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    private void setDirectionF(DcMotor ... motors) {
        for (DcMotor m:motors)
            m.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    private void setDirectionR(DcMotor ... motors) {
        for (DcMotor m:motors)
            m.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void runOpMode(){}
    public HardwareM(){}    //Constructor
}
