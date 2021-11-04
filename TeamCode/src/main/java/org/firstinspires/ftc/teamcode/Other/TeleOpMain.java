package org.firstinspires.ftc.teamcode.Other;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.Hardware.HardwareM;


@TeleOp(name = "Test1", group = "Teste")

public class TeleOpMain extends OpMode
{
    HardwareM fer = new HardwareM();
    boolean apasat = false;
    boolean apasat1 = false;

    @Override
    public void init()
    {
        fer.init(hardwareMap);
    }

    @Override
    public void loop()
    {
        fer.roataStanga.setPower(Range.clip(gamepad1.left_stick_y, -1, 1));   //Gamepad 1
        fer.roataDreapta.setPower(Range.clip(gamepad1.right_stick_y, -1, 1));

        if(gamepad2.b)                                                              //Gamepad 2
        {
            fer.brat_1.setPower(Range.clip(gamepad2.left_stick_y, -.5, .5));
            telemetry.addLine("Mod slow activat - brat");
        }
        else
            {
                fer.brat_1.setPower(Range.clip(gamepad2.left_stick_y, -1, 1));
            }

        if(gamepad2.left_bumper && !apasat)
            {
                fer.peria.setPower(1);
                apasat = true;
            }
            else if(!gamepad2.left_bumper) apasat = false;

        if(gamepad2.right_bumper && !apasat1)
            {
                fer.peria.setPower(-1);
                apasat1 = true;
            }
            else if(!gamepad2.right_bumper) apasat1 = false;

//        else if(gamepad2.a)
//            peria.setPower(0);
    }
}