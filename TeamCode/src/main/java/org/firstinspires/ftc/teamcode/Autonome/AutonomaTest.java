package org.firstinspires.ftc.teamcode.Autonome;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.Hardware.HardwareM;

public class AutonomaTest extends LinearOpMode {

    HardwareM fer = new HardwareM();

    @Override
    public void runOpMode() throws InterruptedException
    {
        fer.init(hardwareMap, true); //Initializare

        waitForStart();                     //Loop
        while(opModeIsActive())
        {}
    }

    public void fata(int distanta, double putere)
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
}
