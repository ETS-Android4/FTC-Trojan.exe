package org.firstinspires.ftc.teamcode.Autonome;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
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
}
