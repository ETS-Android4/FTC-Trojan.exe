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
    DcMotor brat_1, brat_2;
    Servo  servo_1, servo_2;

    @Override
    public void init()
    {
        //Motoare
        roataStanga  = hardwareMap.get(DcMotor.class, "motorStanga");
        roataDreapta = hardwareMap.get(DcMotor.class, "motorDreapta");
        brat_1       = hardwareMap.get(DcMotor.class, "motor1");
        brat_2       = hardwareMap.get(DcMotor.class, "motor2");

        //Servouri
        servo_1 = hardwareMap.get(Servo.class, "servo1");
        servo_2 = hardwareMap.get(Servo.class, "servo2");

        roataDreapta.setDirection(DcMotorSimple.Direction.REVERSE);    //Directie motoare
        roataStanga.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void loop()
    {
        roataStanga.setPower(Range.clip(gamepad1.left_stick_y,   -1, 1));
        roataDreapta.setPower(Range.clip(gamepad1.right_stick_y, -1, 1));

//        if(Range.clip(gamepad1.left_stick_x, -1, 1) <= 0)
//        {
//            roataStanga.setPower(Range.clip(gamepad1.right_stick_y, -1, 1) + Range.clip(gamepad1.left_stick_x, -1, 1));
//            roataDreapta.setPower(Range.clip(gamepad1.right_stick_y, -1, 1));
//        }
//        else
//            {
//                roataStanga.setPower(Range.clip(gamepad1.right_stick_y, -1, 1));
//                roataDreapta.setPower(Range.clip(gamepad1.right_stick_y, -1, 1) - Range.clip(gamepad1.left_stick_x, -1, 1));
//            }

    }
}