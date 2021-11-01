package org.firstinspires.ftc.teamcode.Other;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (name = "Viraje", group = "Teste")

public class Viraje extends OpMode {

    DcMotor roataStanga, roataDreapta;

    @Override
    public void init()
    {
        //Motoare
        roataStanga  = hardwareMap.get(DcMotor.class, "motorStanga");
        roataDreapta = hardwareMap.get(DcMotor.class, "motorDreapta");

        roataDreapta.setDirection(DcMotorSimple.Direction.REVERSE);    //Directie motoare
        roataStanga.setDirection(DcMotorSimple.Direction.FORWARD);

    }

    @Override
    public void loop()
    {
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

//        double left;
//        double right;
//
//        double drive = gamepad1.left_stick_y;       //right_stick_y
//        double turn = gamepad1.left_stick_x;        //Range.clip?
//
//        left = drive + turn;
//        right = drive - turn;
//
//        roataStanga.setPower(left);
//        roataDreapta.setPower(right);

    }
}
