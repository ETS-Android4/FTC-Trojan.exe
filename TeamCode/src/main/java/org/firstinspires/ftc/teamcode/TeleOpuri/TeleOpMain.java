package org.firstinspires.ftc.teamcode.TeleOpuri;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.Hardware.HardwareM;


@TeleOp(name = "TeleOP", group = "Teste")

public class TeleOpMain extends OpMode
{
    HardwareM fer = new HardwareM();    //Variabile

    @Override
    public void init()      //Initializare Hardware
    {
        fer.init(hardwareMap, false);
        telemetry.addData("Robot" ,"Initializat");
    }

    @Override
    public void loop()      //Robot loop
    {
        //Gamepad 1
        double left;
        double right;

        double fata_spate = gamepad1.left_stick_y;
        double stanga_dreapta = gamepad1.right_stick_x;        //Range.clip?

        left = fata_spate - stanga_dreapta;
        right = fata_spate + stanga_dreapta;

        fer.frontl.setPower(left);
        fer.frontr.setPower(right);

        if(gamepad1.right_bumper)
            {
                fer.carusel.setPower(1);
            }
        else if(gamepad1.left_bumper)
            {
                fer.carusel.setPower(-1);
            }

        else if(gamepad1.a)
            {
                fer.carusel.setPower(0);
            }

        //Gamepad 2
        if(gamepad2.b)
        {
            fer.brat_1.setPower(Range.clip(gamepad2.left_stick_y, -.5, .5));
            telemetry.addData("Slowmode","Activat");
        }
        else
            {
                fer.brat_1.setPower(Range.clip(gamepad2.left_stick_y, -1, 1));
                telemetry.addData("Slowmode","Dezactivat");
            }

        if(gamepad2.left_bumper)
            {
                fer.peria.setPower(1);
                telemetry.addData("Perie","Spate");
            }
        else if(gamepad2.right_bumper)
            {
                fer.peria.setPower(-1);
                telemetry.addData("Perie","Fata");
            }

        else if(gamepad2.a)
            {
                fer.peria.setPower(0);
                telemetry.addData("Perie","Oprita");
            }
        telemetry.update();
    }
}