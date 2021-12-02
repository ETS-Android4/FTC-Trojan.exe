package org.firstinspires.ftc.teamcode.Grupa1;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


public class autonoma_1 extends LinearOpMode
{
    hwgrupa1 fer = new hwgrupa1 ();

    @Override
    public void runOpMode() throws InterruptedException
    {
        fer.init(hardwareMap, true);
    }
    public void stopMotor()
    {
        fer.roataStanga.setPower(0);
        fer.roataDreapta.setPower(0);
    }

    public void fata_spate (double putere, int distanta)  ///pentru deplasarea in spate se pune parametrul putere cu -
    {
        fer.roataStanga.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fer.roataDreapta.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fer.roataStanga.setTargetPosition(distanta);
        fer.roataDreapta.setTargetPosition(distanta);

        fer.roataStanga.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fer.roataDreapta.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fer.roataStanga.setPower(putere);
        fer.roataDreapta.setPower(putere);

        while(fer.roataStanga.isBusy() && fer.roataDreapta.isBusy() )
        {}

        stopMotor();

    }

    public void dreapta (double putere, int distanta)
    {
        fer.roataStanga.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fer.roataDreapta.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fer.roataStanga.setTargetPosition(distanta);
        fer.roataDreapta.setTargetPosition(distanta);

        fer.roataStanga.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fer.roataDreapta.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fer.roataStanga.setPower(putere);
        fer.roataDreapta.setPower(0);

        while(fer.roataStanga.isBusy() )
        {}

        stopMotor();
    }

    public void stanga (double putere, int distanta)
    {
        fer.roataStanga.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fer.roataDreapta.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fer.roataStanga.setTargetPosition(distanta);
        fer.roataDreapta.setTargetPosition(distanta);

        fer.roataStanga.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fer.roataDreapta.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fer.roataStanga.setPower(0);
        fer.roataDreapta.setPower(putere);

        while(fer.roataDreapta.isBusy() )
        {}

        stopMotor();
    }

    public void peria (double putere, int rotatii) //!
    {
        fer.peria.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fer.peria.setDirection(DcMotorSimple.Direction.FORWARD); //!
        fer.peria.setTargetPosition(rotatii);
        fer.peria.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fer.peria.setPower(putere); ///pentru directia fata se pune cu + si pt spate cu -

        while(fer.peria.isBusy() )
        {}

        stopMotor();
    }

    public void brat (double putere, int rotatii)
    {
        fer.brat_1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fer.brat_1.setDirection(DcMotorSimple.Direction.FORWARD); ///nu stim cum e pus exact motorul, ne uitam la scoala pt directie
        fer.brat_1.setTargetPosition(rotatii);
        fer.brat_1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fer.brat_1.setPower(putere);

        while(fer.brat_1.isBusy() )
        {}

        stopMotor();

    }
}

