package org.firstinspires.ftc.teamcode.Autonome;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.Hardware.HardwareM;

@Autonomous (name="Rosu_Sus",group="Autonome")
public class Autonoma_Rosu_Sus extends TemplateAutonoma
{
//    HardwareM fer = new HardwareM();

    @Override
    public void runOpMode() throws InterruptedException
    {
        waitForStart();
        while(opModeIsActive())
        {
            fer.init(hardwareMap, false);
            fata_spate(.5,HardwareM.NEVEREST40_TICKS_PER_INCH*15);
            //TODO:telemetry.addData("Rotatii", )
        }
    }
}
