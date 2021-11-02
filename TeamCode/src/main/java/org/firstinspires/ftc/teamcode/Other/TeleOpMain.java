package org.firstinspires.ftc.teamcode.Other;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Test1", group = "Teste")

public class TeleOpMain extends OpMode
{
    DcMotor roataStanga, roataDreapta;
    DcMotor brat_1;
    Servo  servo_1, servo_2;

    @Override
    public void init()
    {
        //Motoare
        roataStanga  = hardwareMap.get(DcMotor.class, "motorStanga");
        roataDreapta = hardwareMap.get(DcMotor.class, "motorDreapta");
        brat_1       = hardwareMap.get(DcMotor.class, "motor1");

        //Servouri
        servo_1 = hardwareMap.get(Servo.class, "servo1");
        servo_2 = hardwareMap.get(Servo.class, "servo2");

        roataDreapta.setDirection(DcMotorSimple.Direction.FORWARD);    //Directie motoare
        roataStanga.setDirection(DcMotorSimple.Direction.REVERSE);
        brat_1.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void loop()
    {
        roataStanga.setPower(Range.clip(gamepad1.left_stick_y, -1, 1));   //Gamepad 1
        roataDreapta.setPower(Range.clip(gamepad1.right_stick_y, -1, 1));

        if(gamepad2.b)                                                              //Gamepad 2
        {
            brat_1.setPower(Range.clip(gamepad2.left_stick_y, -.7, .7));
        }
        else
        {
            brat_1.setPower(Range.clip(gamepad2.left_stick_y, -1, 1));
        }
    }
}