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
        fer.frontl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fer.frontr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fer.frontl.setTargetPosition(distanta);
        fer.frontr.setTargetPosition(distanta);

        fer.frontl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fer.frontr.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fer.frontl.setPower(putere);
        fer.frontr.setPower(putere);

        while(fer.frontl.isBusy() && fer.frontr.isBusy() )
        {}

        stopMotor();
    }

    public void stopMotor()
    {
        fer.frontl.setPower(0);
        fer.frontr.setPower(0);
    }
}
