package org.firstinspires.ftc.teamcode.Grupa1;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name= "autonoma_2", group= "Grupa1")
public class autonoma_2 extends autonoma_1
{


    @Override
    public void runOpMode() throws InterruptedException
    {
        waitForStart();

        while(opModeIsActive())
        {
            fata_spate(1,120);
            dreapta(1,20);  ///am estimat 20 pt intoarcere la dreapta de 90 de grade
            fata_spate(1,120);
            dreapta(1,20);
            fata_spate(1,120);
            dreapta(1,20);
            fata_spate(1,120);
            brat(0.5,5) ;   ///am estimat roatiile
            peria(-1,20);   ///peria se misca in spate
        }
    }
}
