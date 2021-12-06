package org.firstinspires.ftc.teamcode.Grupa2;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Hardware.HardwareM;

@Autonomous (name = "Autonomous2" , group = "Grupa2")

public class Autonomous2 extends LinearOpMode {
    HardwareM fer = new HardwareM();

    @Override
    public void runOpMode() throws InterruptedException {
        fer.init(hardwareMap, true);

        waitForStart();

        while (opModeIsActive()) {
         moveforward( 0.5 ,1000) ;
         stopMotor() ;
         turnright( 0.5 , 1000) ;
         stopMotor() ;
         moveback(0.5 , 1000) ;
         stopMotor() ;
         turnleft(0.5 , 1000 ) ;
         stopMotor() ;

        }
    }

    public void moveforward (int  distanta, double putere) {
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
        sleep(time);
    }

    public void turnright (double power, long time) {
        fer.roataStanga.setPower(power);
        fer.roataDreapta.setPower(-power);
        sleep(time);
    }

    public void turnleft (double power, long time) {
        fer.roataStanga.setPower(-power);
        fer.roataDreapta.setPower(power);
        sleep(time);
    }

    public void moveback (double power, long time) {
        fer.roataStanga.setPower(-power);
        fer.roataDreapta.setPower(-power);
        sleep(time);
    }
}
