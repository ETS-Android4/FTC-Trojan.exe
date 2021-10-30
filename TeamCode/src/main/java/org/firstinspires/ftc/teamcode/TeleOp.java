package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;  //IMportam fisierul pt clasa OpMode
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


@Autonomous(name="Test1")
public class TeleOp extends OpMode
{
    DcMotor roataStanga, roataDreapta;
    DcMotor brat_1, brat_2;
    Servo servo_1, servo_2;

    @Override
    public void init()
    {

        roataStanga  = hardwareMap.get(DcMotor.class, "motorStanga");
        roataDreapta = hardwareMap.get(DcMotor.class, "motorDreapta");
        brat_1       = hardwareMap.get(DcMotor.class, "motor1");
        brat_2       = hardwareMap.get(DcMotor.class, "motor2");

        servo_1 = hardwareMap.get(Servo.class, "servo1");
        servo_2 = hardwareMap.get(Servo.class, "servo2");
    }

    @Override
    public void loop()
    {
        roataStanga.setPower(Range.clip(gamepad1.left_stick_y, -1, 1));
        roataDreapta.setPower(Range.clip(gamepad1.right_stick_y, -1, 1));

    }
}