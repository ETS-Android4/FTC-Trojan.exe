package org.firstinspires.ftc.teamcode.Autonome;

import org.firstinspires.ftc.teamcode.Hardware.HardwareM;
public class Autonoma_Rosu_Jos extends TemplateAutonoma
{
    HardwareM fer = new HardwareM();

    @Override
    public void runOpMode() throws InterruptedException {
        fer.init(hardwareMap);
    }
}
