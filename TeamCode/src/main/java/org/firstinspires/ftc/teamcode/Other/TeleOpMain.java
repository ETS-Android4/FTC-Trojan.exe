package org.firstinspires.ftc.teamcode.Other;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Grupa2.HardwareMap2;
import org.firstinspires.ftc.teamcode.Hardware.HardwareM;


@TeleOp(name = "Test1", group = "Teste")

public class TeleOpMain extends OpMode
{
    HardwareMap2 fer = new HardwareMap2();    //Variabile

    @Override
    public void init()      //Initializare Hardware
    {
        fer.init(hardwareMap, false);
    }

    @Override
    public void loop()      //Robot loop
    {
        fer.roataStanga.setPower(Range.clip(gamepad1.left_stick_y, -1, 1));   //Gamepad 1
        fer.roataDreapta.setPower(Range.clip(gamepad1.right_stick_y, -1, 1));

        if(gamepad2.b)                                                                  //Gamepad 2
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

        else if(gamepad2.a) fer.peria.setPower(0);
        telemetry.addData("Perie","Oprita");
        telemetry.update();
    }
}