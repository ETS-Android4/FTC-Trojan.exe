package org.firstinspires.ftc.teamcode.Autonome;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Hardware.HardwareM;

@Autonomous(name = "Autonoma Copil",group = "Test")
public class AutonomaCopil extends AutonomaTest {       //Extinde AutonomaTest, deci extinde si LinearOpMode

    HardwareM fer = new HardwareM();

    @Override
    public void runOpMode() throws InterruptedException
    {
        fer.init(hardwareMap, true);          //Initializare

        waitForStart();                                 //Loop
        while(opModeIsActive())
        {
            fata(1440, 1);
        }
    }

}
