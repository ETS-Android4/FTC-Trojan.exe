package org.firstinspires.ftc.teamcode.Other;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.Hardware.HardwareM;


@TeleOp(name = "Test1", group = "Teste")

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
        fer.roataStanga.setPower(Range.clip(gamepad1.left_stick_y, -1, 1));
        fer.roataDreapta.setPower(Range.clip(gamepad1.right_stick_y, -1, 1));

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
            telemetry.update();
        }
        else
            {
                fer.brat_1.setPower(Range.clip(gamepad2.left_stick_y, -1, 1));
                telemetry.addData("Slowmode","Dezactivat");
                telemetry.update();
            }

        if(gamepad2.left_bumper)
            {
                fer.peria.setPower(1);
                telemetry.addData("Perie","Spate");
                telemetry.update();
            }

        else if(gamepad2.right_bumper)
            {
                fer.peria.setPower(-1);
                telemetry.addData("Perie","Fata");
                telemetry.update();
            }

        else if(gamepad2.a)
            {
                fer.peria.setPower(0);
                telemetry.addData("Perie","Oprita");
            }
        telemetry.update();
    }
}