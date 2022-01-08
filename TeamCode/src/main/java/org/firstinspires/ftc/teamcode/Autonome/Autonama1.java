package org.firstinspires.ftc.teamcode.Autonome;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Hardware.HardwareM;

public class Autonama1 extends LinearOpMode {
    HardwareM fer = new HardwareM();

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        fer.init(hardwareMap,true);
        while (opModeIsActive())
        {
            fata_spate(1, 2000);
        }
    }

    public void fata_spate (double putere, int rotatii) {
        fer.roataStanga.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fer.roataDreapta.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fer.roataStanga.setTargetPosition(rotatii);
        fer.roataDreapta.setTargetPosition(rotatii);

        fer.roataStanga.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fer.roataDreapta.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fer.roataStanga.setPower(putere);
        fer.roataDreapta.setPower(putere);

        while(fer.roataStanga.isBusy() && fer.roataDreapta.isBusy()) {}

        stopMotor();
    }

    public void dreapta (double putere, int rotatii) {
        fer.roataStanga.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fer.roataDreapta.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fer.roataStanga.setTargetPosition(rotatii);
        fer.roataDreapta.setTargetPosition(rotatii);

        fer.roataStanga.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fer.roataDreapta.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fer.roataStanga.setPower(putere);
        fer.roataDreapta.setPower(-putere);

        while(fer.roataStanga.isBusy()) {}

        stopMotor();
    }

    public void stanga (double putere, int rotatii) {
        fer.roataStanga.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fer.roataDreapta.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fer.roataStanga.setTargetPosition(rotatii);
        fer.roataDreapta.setTargetPosition(rotatii);

        fer.roataStanga.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fer.roataDreapta.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fer.roataStanga.setPower(-putere);
        fer.roataDreapta.setPower(putere);

        while(fer.roataDreapta.isBusy()) {}

        stopMotor();
    }

    public void peria (double putere, int rotatii) {
        fer.peria.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fer.peria.setTargetPosition(rotatii);
        fer.peria.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fer.peria.setPower(putere);

        while(fer.peria.isBusy()) {}

        stopMotor();
    }

    public void brat (double putere, int rotatii) {
        fer.brat_S.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fer.brat_D.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fer.brat_S.setTargetPosition(rotatii);
        fer.brat_D.setTargetPosition(rotatii);
        fer.brat_S.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fer.brat_D.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fer.brat_S.setPower(putere);
        fer.brat_D.setPower(putere);

        while(fer.brat_S.isBusy() || fer.brat_D.isBusy()){}

        stopMotor();
    }

    public void stopMotor(DcMotor ... motors) {
        for (DcMotor m:motors)
            m.setPower(0);
    }
}
