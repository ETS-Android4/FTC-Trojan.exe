package org.firstinspires.ftc.teamcode.Grupa2;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Hardware.HardwareM;

@Autonomous (name = "Autonomous1" , group = "Grupa2")

public class Autonomous1 extends LinearOpMode {
    HardwareM fer = new HardwareM();

    @Override
    public void runOpMode() throws InterruptedException {
        fer.init(hardwareMap, true);

        waitForStart();
        while (opModeIsActive()) {
        }
    }

    public void moveforward(int distanta, double putere) {
        fer.roataStanga.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fer.roataDreapta.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fer.roataStanga.setTargetPosition(distanta);
        fer.roataDreapta.setTargetPosition(distanta);

        fer.roataStanga.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fer.roataDreapta.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fer.roataStanga.setPower(putere);
        fer.roataDreapta.setPower(putere);

        while (fer.roataStanga.isBusy() && fer.roataDreapta.isBusy()) {
        }

        stopMotor();
    }

    public void stopMotor() {
        fer.roataStanga.setPower(0);
        fer.roataDreapta.setPower(0);
    }


    public void moveforward (double power, long time) {
        fer.roataStanga.setPower(power);
        fer.roataDreapta.setPower(power);
    }

    public void turnright (double power, long time) {
        fer.roataStanga.setPower(power);
        fer.roataDreapta.setPower(-power);
    }

    public void turnleft (double power, long time) {
        fer.roataStanga.setPower(-power);
        fer.roataDreapta.setPower(power);
    }

    public void moveback(double power, long time) {
        fer.roataStanga.setPower(-power);
        fer.roataDreapta.setPower(-power);
    }
}
