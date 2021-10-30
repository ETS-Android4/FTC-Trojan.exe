package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;  //IMportam fisierul pt clasa OpMode
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name="Test1")
public class TeleOp extends OpMode
{

    DcMotor leftFront;
    Servo servo1;
    int i=1;

    @Override
    public void init()
    {

        leftFront = hardwareMap.get(DcMotor.class, "motor1");
        servo1 = hardwareMap.get(Servo.class, "servo1");
    }

    @Override
    public void loop()
    {

        leftFront.setPower(1);
        servo1.setPosition(1.2);

    }
}
