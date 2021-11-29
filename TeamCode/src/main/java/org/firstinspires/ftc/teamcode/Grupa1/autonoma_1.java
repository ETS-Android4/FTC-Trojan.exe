package org.firstinspires.ftc.teamcode.Grupa1;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


public class autonoma_1 extends LinearOpMode
{
    hwgrupa1 fer = new hwgrupa1 ();

    @Override
    public void runOpMode() throws InterruptedException
    {
        fer.init(hwgrupa1, true);

    waitForStart();

    while (opModeIsActive()) { }

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

   public void stopMotor()
    {
        fer.roataStanga.setPower(0);
        fer.roataDreapta.setPower(0);
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
        fer.roataDreapta.setPower(putere);

        while(fer.roataStanga.isBusy() && fer.roataDreapta.isBusy() )
        {}

        stopMotor();
    }
}

