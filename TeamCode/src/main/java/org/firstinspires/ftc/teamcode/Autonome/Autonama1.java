package org.firstinspires.ftc.teamcode.Autonome;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Hardware.HardwareM;

public class Autonama1 extends AutonomaTest {
    HardwareM fer = new HardwareM();

    @Override
    public void runOpMode() throws InterruptedException {
        

        waitForStart();
        while (opModeIsActive())
            {
                fata(2000, 0.5);
            }


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
}
