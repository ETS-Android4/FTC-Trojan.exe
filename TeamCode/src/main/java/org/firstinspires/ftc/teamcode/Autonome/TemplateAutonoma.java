package org.firstinspires.ftc.teamcode.Autonome;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Hardware.HardwareM;

public class TemplateAutonoma extends LinearOpMode {
    HardwareM fer = new HardwareM();

    @Override
    public void runOpMode() throws InterruptedException {fer.init(hardwareMap,true);}

    public void fata_spate (double power, int rotatii) {
        fer.goToPosition(power, rotatii, fer.roataStanga, fer.roataDreapta);

        while(fer.roataStanga.isBusy() || fer.roataDreapta.isBusy()) {}
        fer.stopMotors(fer.roataDreapta, fer.roataStanga);
    }

    public void virajDreapta (double power, int rotatii) {
        fer.goToPosition(power, rotatii, fer.roataStanga, fer.roataDreapta);

        while(fer.roataStanga.isBusy() || fer.roataDreapta.isBusy()) {}
        fer.stopMotors(fer.roataDreapta, fer.roataStanga);
    }

    public void virajStanga (double power, int rotatii) {
        fer.goToPosition(power, rotatii, fer.roataStanga, fer.roataDreapta);

        while(fer.roataDreapta.isBusy()) {}
        fer.stopMotors(fer.roataDreapta, fer.roataStanga);
    }

    public void rotireDreapta (double power, int rotatii) {

    }

    public void rotireStanga (double power, int rotatii) {

    }

    public void brat (double power, int rotatii) {
        fer.goToPosition(power, rotatii, fer.brat_S, fer.brat_D);

        while(fer.brat_S.isBusy() || fer.brat_D.isBusy()){}
        fer.stopMotors(fer.brat_S, fer.brat_D);
    }

    public void scripete (double power, int rotatii) {
        fer.goToPosition(power, rotatii, fer.brat_S, fer.brat_D);

        while(fer.brat_S.isBusy() || fer.brat_D.isBusy()){}
        fer.stopMotors(fer.brat_S, fer.brat_D);
    }

    public void peria (double power, int rotatii) {
        fer.goToPosition(power, rotatii, fer.peria);

        while(fer.peria.isBusy()) {}
        fer.stopMotors(fer.peria);
    }
}
