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
}
